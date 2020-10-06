package com.software.noelvillaman.edisonproject.home

import android.os.Bundle
import android.widget.Toast
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.software.noelvillaman.edisonproject.R
import com.software.noelvillaman.edisonproject.model.Results
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_movie_details.*
import kotlinx.android.synthetic.main.content_scrolling.*

class MovieDetails : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)
        setSupportActionBar(findViewById(R.id.toolbar))

        val movieObject = intent.getParcelableExtra<Results>("movie")!!
        findViewById<CollapsingToolbarLayout>(R.id.toolbar_layout).title = movieObject.title

        getObjecInfo(movieObject)
    }

    private fun getObjecInfo(result : Results){
        Picasso.get().load("https://image.tmdb.org/t/p/original/${result.backdrop_path}").into(details_movie_image)
        details_movie_title.text = "Title: ${result.title}"
        details_movie_overview.text = "${result.overview} \n\n ${result.genre_ids?.get(0)} \n\n Release date: ${result.release_date?.let {
            arrageDate(
                it
            )
        }}"
        result.genre_ids?.get(0)
    }

    private fun arrageDate(string : String) : String{
        val year = string.substring(0, 4)
        val month = string.substring(5, 7)
        val day = string.substring(8, 10)
        return "$month/$day/$year"
    }
}