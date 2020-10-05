package com.software.noelvillaman.edisonproject.viewmodel

import android.provider.Settings.Global.getString
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.software.noelvillaman.edisonproject.model.MovieModel
import com.software.noelvillaman.edisonproject.model.Results
import com.software.noelvillaman.edisonproject.networking.MovieApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ResultsMovieViewmodel : ViewModel() {
    val resultsMovies = MutableLiveData<List<Results>>()
    val loading = MutableLiveData<Boolean>()
    val resultsError = MutableLiveData<Boolean>()

    private var resultCall2 : Call<MovieModel>? = null

    internal val error  : LiveData<Boolean>
        get() = resultsError

    internal fun getMovieResults() : LiveData<List<Results>>{
        return resultsMovies
    }

    internal fun getLoaindResults() : LiveData<Boolean>{
        return loading
    }

    init {
        fetchResults()
    }

    private fun fetchResults(){
        loading.value = true
        resultCall2 = MovieApi.instance.getMovieList("1ba8650f51425ddd9c39de29db214b6a")
        resultCall2?.enqueue(object : Callback<MovieModel>{
            override fun onResponse(call: Call<MovieModel>, response: Response<MovieModel>) {
                resultsError.value = false
                resultsMovies.value = response.body()?.results
                loading.value = false
                resultCall2 = null
            }

            override fun onFailure(call: Call<MovieModel>, t: Throwable) {
                Log.e("RESULTSERROR", "Error fetching results ${t.message}")
                resultsError.value = true
                loading.value = true
                resultCall2 = null
            }

        })
    }

    override fun onCleared() {
        if (resultCall2 != null){
            resultCall2!!.cancel()
            resultCall2 = null
        }
    }
}