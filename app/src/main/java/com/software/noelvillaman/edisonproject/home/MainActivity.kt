package com.software.noelvillaman.edisonproject.home

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.software.noelvillaman.edisonproject.R
import com.software.noelvillaman.edisonproject.adapters.MovieListResultAdapter
import com.software.noelvillaman.edisonproject.model.MovieModel
import com.software.noelvillaman.edisonproject.model.Results
import com.software.noelvillaman.edisonproject.networking.MovieApi
import com.software.noelvillaman.edisonproject.utils.MovieSelectedListener
import com.software.noelvillaman.edisonproject.viewmodel.MovieViewmodel
import com.software.noelvillaman.edisonproject.viewmodel.ResultsMovieViewmodel
import com.software.noelvillaman.edisonproject.viewmodel.SelectedResultViewmodel
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.error_message_container.*
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity(), MovieSelectedListener {
    private var viewModel: MovieViewmodel? = null
    private var resultViewmodel : ResultsMovieViewmodel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        resultViewmodel = ViewModelProvider(this).get(ResultsMovieViewmodel::class.java)
        movie_container?.adapter = MovieListResultAdapter(this, resultViewmodel!!, this, this)
        movie_container?.layoutManager = LinearLayoutManager(this)
        observeResultViemodel()
    }

    private fun observeResultViemodel(){
        val temaObservador = Observer<List<Results>> { movies ->
            if (movies != null){
                movie_container.visibility = View.VISIBLE
            }
        }

        resultViewmodel!!.getMovieResults().observe(this, temaObservador)

        resultViewmodel!!.error.observe(this, Observer { isError ->
            if (isError) {
                tv_error_msg.visibility = View.VISIBLE
                movie_container.visibility = View.GONE
                tv_error_msg.text = getString(R.string.something_went_wrong)
            } else {
                tv_error_msg.visibility = View.GONE
                tv_error_msg.text = null

            }
        })

        resultViewmodel?.getLoaindResults()?.observe(this, Observer<Boolean> { isLoading ->

            loading_view!!.visibility = if (isLoading) View.VISIBLE else View.GONE
            if (isLoading) {
                tv_error_msg.visibility = View.GONE
                movie_container!!.visibility = View.GONE
            }
        })
    }

    override fun onMovieSelected(tema: MovieModel) {}

    override fun onResultSelected(result: Results) {
        val selectedResult = ViewModelProvider(this).get(SelectedResultViewmodel::class.java)
        selectedResult.setSelectedMovie(result)
    }

}