package com.software.noelvillaman.edisonproject.adapters

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import com.software.noelvillaman.edisonproject.R
import com.software.noelvillaman.edisonproject.home.MainActivity
import com.software.noelvillaman.edisonproject.home.MovieDetails
import com.software.noelvillaman.edisonproject.model.Results
import com.software.noelvillaman.edisonproject.utils.MovieSelectedListener
import com.software.noelvillaman.edisonproject.viewmodel.MovieViewmodel
import com.software.noelvillaman.edisonproject.viewmodel.ResultsMovieViewmodel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.movie_list_view.view.*

class MovieListResultAdapter(val mContext : Context, viewModel : ResultsMovieViewmodel,
lifecycleOwner: LifecycleOwner, private val movieSelectedListener: MovieSelectedListener) : RecyclerView.Adapter<MovieListResultAdapter.MovieViewHolder>() {

    private var resultsSelectedListener : MovieSelectedListener? = null
    private val resultData = ArrayList<Results>()

    init {
        this.resultsSelectedListener = movieSelectedListener
        viewModel.resultsMovies.observe(lifecycleOwner, Observer { movies ->
            resultData.clear()
            if (movies != null){
                resultData.addAll(movies)
            }
            notifyDataSetChanged()
        })
        setHasStableIds(true)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_list_view, parent, false)
        return resultsSelectedListener?.let { MovieViewHolder(view, it) }!!
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(resultData[position])
        val myObject = resultData[position]

        holder.itemView.setOnClickListener({
            showDetailsActivity(myObject, position)
        })
    }

    private fun showDetailsActivity(movie : Results, position: Int){
        val intent = Intent(mContext, MovieDetails::class.java)
        intent.putExtra("movie", movie)
        intent.putExtra("position", position)
        mContext.startActivity(intent)
    }

    override fun getItemCount() = resultData.size

    override fun getItemId(position: Int): Long {
        return resultData[position].id!!.toLong()
    }

    class MovieViewHolder(movieView : View, movieSelectedListener: MovieSelectedListener) : RecyclerView.ViewHolder(movieView){
        @BindView(R.id.tv_movie_title)
        var titleMovie : TextView
        @BindView(R.id.tv_movie_description)
        var movieDescription : TextView

        @BindView(R.id.imageView_movie)
        var moviePoster : ImageView

        private var resultMovies : Results

        init {
            titleMovie = movieView.findViewById(R.id.tv_movie_title)
            movieDescription = movieView.findViewById(R.id.tv_movie_description)
            moviePoster = movieView.findViewById(R.id.imageView_movie)
            resultMovies = Results()
            movieView.setOnClickListener({
                if (resultMovies != null){
                    Log.d("TAGRESULTS", "All good!")
                }
            })
        }

        fun bind(movies : Results){
            this.resultMovies = movies
            titleMovie.text = movies.title
            movieDescription.text = movies.overview
            Picasso.get().load("https://image.tmdb.org/t/p/original/${movies.backdrop_path}").into(moviePoster)
        }
    }
}