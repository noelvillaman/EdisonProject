package com.software.noelvillaman.edisonproject.utils

import com.software.noelvillaman.edisonproject.model.MovieModel
import com.software.noelvillaman.edisonproject.model.Results

interface MovieSelectedListener {
    fun onMovieSelected(movie : MovieModel)

    fun onResultSelected(result : Results)
}
