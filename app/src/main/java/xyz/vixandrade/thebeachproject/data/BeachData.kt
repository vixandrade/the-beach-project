package xyz.vixandrade.thebeachproject.data

import com.google.gson.annotations.SerializedName

data class BeachData (
        @SerializedName("macro") val macro: String,
        @SerializedName("micro") val micro: String,
        @SerializedName("beach") val beach: String,
        @SerializedName("local") val local: String,
        @SerializedName("quality") val quality: String
)