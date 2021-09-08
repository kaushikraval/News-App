package com.nytimesapp.samp.responsemodels

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class LatestArticlesResponseModel(
    @SerializedName("copyright")
    val copyright: String?,
    @SerializedName("num_results")
    val numResults: Int?,
    @SerializedName("results")
    val results: ArrayList<Result>?,
    @SerializedName("status")
    val status: String?
): Parcelable