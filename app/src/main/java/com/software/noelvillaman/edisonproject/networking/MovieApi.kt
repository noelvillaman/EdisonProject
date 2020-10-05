package com.software.noelvillaman.edisonproject.networking

import okhttp3.MediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object MovieApi {
    private val BASE_URL = "https://api.themoviedb.org/"

    private var retrofit: Retrofit? = null
    private var movieService: MovieService? = null

    val instance: MovieService
        get() {
            if (movieService != null) {
                return movieService!!
            }
            if (retrofit == null) {
                initializeRetrofit()
            }
            movieService = retrofit?.create(MovieService::class.java)
            return movieService!!
        }

    private fun initializeRetrofit() {
        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}