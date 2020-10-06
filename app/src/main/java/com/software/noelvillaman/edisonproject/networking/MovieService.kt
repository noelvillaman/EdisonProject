package com.software.noelvillaman.edisonproject.networking

import com.software.noelvillaman.edisonproject.model.MovieModel
import com.software.noelvillaman.edisonproject.model.Results
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {

    @get:GET("4/list/5?api_key=1ba8650f51425ddd9c39de29db214b6a")
    val listOfMovie : Call<ResponseBody>
    /*4/list/5?page=1&api_key=1ba8650f51425ddd9c39de29db214b6a*/
    @GET("4/list/5")
    fun getMovieList(@Query("api_key") api_key: String?) : Call<MovieModel>?

    //images formats: https://image.tmdb.org/t/p/original/7PzJdsLGlR7oW4J0J5Xcd0pHGRg.png
    //backdrop_path for images

    //https://api.themoviedb.org/4/list/1?api_key=1ba8650f51425ddd9c39de29db214b6a

    //https://api.themoviedb.org/4/list/1?api_key=1ba8650f51425ddd9c39de29db214b6a
}