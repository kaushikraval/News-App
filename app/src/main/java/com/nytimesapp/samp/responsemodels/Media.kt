package com.nytimesapp.samp.responsemodels


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Media(
    @SerializedName("approved_for_syndication")
    val approvedForSyndication: Int?,
    @SerializedName("caption")
    val caption: String?,
    @SerializedName("copyright")
    val copyright: String?,
    @SerializedName("media-metadata")
    val mediaMetadata: ArrayList<MediaMetadata>?,
    @SerializedName("subtype")
    val subtype: String?,
    @SerializedName("type")
    val type: String?
): Parcelable