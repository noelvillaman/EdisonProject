package com.software.noelvillaman.edisonproject.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

class Results() : Parcelable{
    @SerializedName("poster_path")
    var poster_path : String? = null
    @SerializedName("popularity")
    var popularity : String? = null
    @SerializedName("vote_count")
    var vote_count : String? = null
    @SerializedName("video")
    var video : String? = null
    @SerializedName("media_type")
    var media_type : String? = null
    @SerializedName("id")
    var id : String? = null
    @SerializedName("adult")
    var adult : String? = null
    @SerializedName("backdrop_path")
    var backdrop_path : String? = null
    @SerializedName("original_language")
    var original_language : String? = null
    @SerializedName("original_title")
    var original_title : String? = null
    @SerializedName("title")
    var title : String? = null
    @SerializedName("overview")
    var overview : String? = null
    @SerializedName("release_date")
    var release_date : String? = null
    @SerializedName("genre_ids")
    var genre_ids : ArrayList<Int>? = null

    constructor(parcel: Parcel) : this() {
        poster_path = parcel.readString()
        popularity = parcel.readString()
        vote_count = parcel.readString()
        video = parcel.readString()
        media_type = parcel.readString()
        id = parcel.readString()
        adult = parcel.readString()
        backdrop_path = parcel.readString()
        original_language = parcel.readString()
        original_title = parcel.readString()
        title = parcel.readString()
        overview = parcel.readString()
        release_date = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(poster_path)
        parcel.writeString(popularity)
        parcel.writeString(vote_count)
        parcel.writeString(video)
        parcel.writeString(media_type)
        parcel.writeString(id)
        parcel.writeString(adult)
        parcel.writeString(backdrop_path)
        parcel.writeString(original_language)
        parcel.writeString(original_title)
        parcel.writeString(title)
        parcel.writeString(overview)
        parcel.writeString(release_date)
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun toString(): String {
        return "Results(poster_path=$poster_path, \npopularity=$popularity, \nvote_count=$vote_count, \nvideo=$video, \nmedia_type=$media_type, \nid=$id, \nadult=$adult, \nbackdrop_path=$backdrop_path, \noriginal_language=$original_language, \noriginal_title=$original_title, \ntitle=$title, \noverview=$overview, \nrelease_date=$release_date, \ngenre_ids=$genre_ids)"
    }

    companion object CREATOR : Parcelable.Creator<Results> {
        override fun createFromParcel(parcel: Parcel): Results {
            return Results(parcel)
        }

        override fun newArray(size: Int): Array<Results?> {
            return arrayOfNulls(size)
        }
    }


}