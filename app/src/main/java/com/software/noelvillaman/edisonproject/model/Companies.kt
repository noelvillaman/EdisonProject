package com.software.noelvillaman.edisonproject.model

import com.google.gson.annotations.SerializedName

class Companies {
    @SerializedName("id")
    var id : Int? = null
    @SerializedName("logo_path")
    var logo_path : String? = null
    @SerializedName("name")
    var name : String? = null
    @SerializedName("origin_country")
    var origin_country : String? = null
}
