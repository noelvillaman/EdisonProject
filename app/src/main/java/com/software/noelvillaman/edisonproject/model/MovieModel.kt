package com.software.noelvillaman.edisonproject.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

class MovieModel() : Parcelable {
    @SerializedName("iso_639_1")
    var iso_639_1 : String? = null
    @SerializedName("iso_3166_1")
    var iso_3166_1 : String? = null
    @SerializedName("name")
    var name : String? = null
    @SerializedName("public")
    var public : String? = null
    @SerializedName("backdrop_path")
    var backdrop_path : String? = null
    @SerializedName("average_rating")
    var average_rating : String? = null
    @SerializedName("runtime")
    var budget : Int? = null
    @SerializedName("results")
    var results : ArrayList<Results>? = null

    @SerializedName("homepage")
    var homepage : String? = null
    @SerializedName("original_title")
    var original_title : String? = null
    @SerializedName("popularity")
    var popularity : Double? = null
    @SerializedName("poster_path")
    var poster_path : String? = null
    @SerializedName("origin_country")
    var origin_country : String? = null

    @SerializedName("release_date")
    var release_date : String? = null
    @SerializedName("revenue")
    var revenue : String? = null

    constructor(parcel: Parcel) : this() {
        iso_639_1 = parcel.readString()
        iso_3166_1 = parcel.readString()
        name = parcel.readString()
        public = parcel.readString()
        backdrop_path = parcel.readString()
        average_rating = parcel.readString()
        budget = parcel.readValue(Int::class.java.classLoader) as? Int
        homepage = parcel.readString()
        original_title = parcel.readString()
        popularity = parcel.readValue(Double::class.java.classLoader) as? Double
        poster_path = parcel.readString()
        origin_country = parcel.readString()
        release_date = parcel.readString()
        revenue = parcel.readString()
    }

    override fun toString(): String {
        return "MovieModel(iso_639_1=$iso_639_1, iso_3166_1=$iso_3166_1, name=$name, public=$public, backdrop_path=$backdrop_path, average_rating=$average_rating, budget=$budget, results=$results, homepage=$homepage, original_title=$original_title, popularity=$popularity, poster_path=$poster_path, origin_country=$origin_country, release_date=$release_date, revenue=$revenue)"
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(iso_639_1)
        parcel.writeString(iso_3166_1)
        parcel.writeString(name)
        parcel.writeString(public)
        parcel.writeString(backdrop_path)
        parcel.writeString(average_rating)
        parcel.writeValue(budget)
        parcel.writeString(homepage)
        parcel.writeString(original_title)
        parcel.writeValue(popularity)
        parcel.writeString(poster_path)
        parcel.writeString(origin_country)
        parcel.writeString(release_date)
        parcel.writeString(revenue)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MovieModel> {
        override fun createFromParcel(parcel: Parcel): MovieModel {
            return MovieModel(parcel)
        }

        override fun newArray(size: Int): Array<MovieModel?> {
            return arrayOfNulls(size)
        }
    }


}