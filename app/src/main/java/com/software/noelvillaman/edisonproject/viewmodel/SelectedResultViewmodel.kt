package com.software.noelvillaman.edisonproject.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.software.noelvillaman.edisonproject.model.MovieModel
import com.software.noelvillaman.edisonproject.model.Results

class SelectedResultViewmodel : ViewModel() {
    val selectedMovie = MutableLiveData<Results>()

    init {
        showMovie()
    }

    private fun showMovie(){}

    fun getSeletedMovie() : LiveData<Results> {
        return selectedMovie
    }

    fun setSelectedMovie(movie: Results){
        selectedMovie.value = movie
    }
}