package com.software.noelvillaman.edisonproject.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.software.noelvillaman.edisonproject.model.MovieModel
import com.software.noelvillaman.edisonproject.networking.MovieApi
import okhttp3.internal.http2.Http2Reader.Companion.logger
import org.json.JSONArray
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.logging.Logger

class MovieViewmodel :  ViewModel() {
    val movies = MutableLiveData<MovieModel>()
    val loading = MutableLiveData<Boolean>()
    val movieLoadError = MutableLiveData<Boolean>()

    private var movieCall : Call<MovieModel>? = null

    internal val error : LiveData<Boolean>
        get() = movieLoadError

    internal fun getmovies() : LiveData<MovieModel> {
        return movies
    }

    internal fun getLoading() : LiveData<Boolean> {
        return loading
    }

    init {
            fetchMovies()
    }

    private fun fetchMovies(){
        loading.value = true
        movieCall = MovieApi.instance.getMovieList("1ba8650f51425ddd9c39de29db214b6a")
        movieCall?.enqueue(object : Callback<MovieModel> {
            override fun onResponse(call: Call<MovieModel>,
                response: Response<MovieModel>
            ) {
                movieLoadError.value = false
                movies.value = response.body()
                loading.value = false
                movieCall = null
            }

            override fun onFailure(call: Call<MovieModel>, t: Throwable) {
                Log.e(javaClass.simpleName, "Error fetching movies", t)
                movieLoadError.value = true
                loading.value = false
                movieCall = null
            }
        })
    }

    override fun onCleared() {
        if (movieCall != null){
            movieCall!!.cancel()
            movieCall = null
        }
    }

    override fun toString(): String {
        return "moviesViewmodel(movies=$movies, loading=$loading, moviewLoadError=$movieLoadError)"
    }

    private fun arrayValues(requestJSONObject: JSONObject){
        val item3Holder = requestJSONObject.getJSONObject("genres_value")
        val ids = item3Holder.getJSONArray("id");
        for (id in 0..ids.length()){
            val id = id.toString()
            Log.d("IDSNUMBER", id)
        }
    }
}