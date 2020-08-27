package com.mustahsan.play.model

import com.google.gson.annotations.SerializedName

data class Thumbnails(
    @SerializedName("thumb-324x576") val thumb1: Thumb?,
    @SerializedName("thumb-613x1536") val thumb2: Thumb?,
    @SerializedName("thumb-614x1536") val thumb3: Thumb?,
    @SerializedName("thumb-615x1536") val thumb4: Thumb?,
    @SerializedName("thumb-677x474") val thumb5: Thumb?
)