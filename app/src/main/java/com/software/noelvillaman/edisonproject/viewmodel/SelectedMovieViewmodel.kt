package com.software.noelvillaman.edisonproject.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.software.noelvillaman.edisonproject.model.MovieModel
import com.software.noelvillaman.edisonproject.model.Results

class SelectedMovieViewmodel : ViewModel() {
    val selectedMovie = MutableLiveData<MovieModel>()

    init {
        showMovie()
    }

    private fun showMovie(){}

    fun getSeletedMovie() : LiveData<MovieModel>{
        return selectedMovie
    }

    fun setSelectedMovie(movie: MovieModel){
        selectedMovie.value = movie
    }
}
