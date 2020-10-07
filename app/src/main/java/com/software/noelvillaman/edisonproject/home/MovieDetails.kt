package com.software.noelvillaman.edisonproject.home

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.software.noelvillaman.edisonproject.R
import com.software.noelvillaman.edisonproject.model.Results
import com.software.noelvillaman.edisonproject.networking.MovieApi
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.content_scrolling.*
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieDetails : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)
        setSupportActionBar(findViewById(R.id.toolbar))

        val movieObject = intent.getParcelableExtra<Results>("movie")!!
        findViewById<CollapsingToolbarLayout>(R.id.toolbar_layout).title = movieObject.title
        val position = intent.getIntExtra("position", 0)
        fetchMovies(position)

        getObjecInfo(movieObject)
    }

    private fun getObjecInfo(result: Results){
        Picasso.get().load("https://image.tmdb.org/t/p/original/${result.backdrop_path}").into(
            details_movie_image
        )
        details_movie_title.text = "Title: ${result.title}"
        details_movie_overview.text = "${result.overview} \n\n Release date: ${result.release_date?.let {
            arrangeDate(
                it
            )
        }}"
        result.genre_ids?.get(0)
    }

    private fun arrangeDate(string: String) : String{
        val year = string.substring(0, 4)
        val month = string.substring(5, 7)
        val day = string.substring(8, 10)
        return "$month/$day/$year"
    }


    private fun fetchMovies(position: Int){
        val mylist = ArrayList<Int>()
        val movieCall = MovieApi.instance.listOfMovie
        movieCall?.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(
                call: Call<ResponseBody>,
                response: Response<ResponseBody>
            ) {
                var myStringBundle = ""
                val json = JSONObject(response.body()!!.string())
                val item3Holder = json.getJSONArray("results")
                for (i in 0 until item3Holder.length()) {
                    val jsonobject: JSONObject = item3Holder.getJSONObject(i)
                    val id = jsonobject.getJSONArray("genre_ids")
                    genres_list.text = "Genres: ${id}"
                }

                Log.d("STR", "$item3Holder")
                //genres_list.text = myStringBundle

            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Log.e(javaClass.simpleName, "Error fetching movies ${t.message}", t)
            }
        })
    }
}