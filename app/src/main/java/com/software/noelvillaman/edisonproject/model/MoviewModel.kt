package com.software.noelvillaman.edisonproject.model

import com.google.gson.annotations.SerializedName

data class MoviewModel() {
    @SerializedName("adult")
    var adult : String? = null
    @SerializedName("backdrop_path")
    var backdrop_path : String? = null
    @SerializedName("belongs_to_collection")
    var belongs_to_collection : String? = null
    @SerializedName("budget")
    var budget : String? = null
    @SerializedName("genres")
    var genres : ArrayList<Genres>? = null

    @SerializedName("homepage")
    var homepage : String? = null
    @SerializedName("id")
    var id : Int? = null
    @SerializedName("imdb_id")
    var imdb_id : String? = null
    @SerializedName("original_language")
    var original_language : String? = null
    @SerializedName("original_title")
    var original_title : String? = null
    @SerializedName("overview")
    var overview : String? = null
    @SerializedName("popularity")
    var popularity : Double? = null
    @SerializedName("poster_path")
    var poster_path : String? = null
    @SerializedName("production_companies")
    var production_companies : ArrayList<Companies>? = null
    @SerializedName("origin_country")
    var origin_country : String? = null
    @SerializedName("production_countries")
    var production_countries : ArrayList<Countrie>? = null

    @SerializedName("release_date")
    var release_date : String? = null
    @SerializedName("revenue")
    var revenue : String? = null
    @SerializedName("runtime")
    var runtime : Int? = null
    @SerializedName("spoken_languages")
    var spoken_languages : ArrayList<Languages>? = null

    @SerializedName("status")
    var status : String? = null
    @SerializedName("tagline")
    var tagline : String? = null
    @SerializedName("title")
    var title : String? = null
    @SerializedName("video")
    var video : Boolean? = null
    @SerializedName("vote_average")
    var vote_average : Double? = null
    @SerializedName("vote_count")
    var vote_count : Int? = null
}