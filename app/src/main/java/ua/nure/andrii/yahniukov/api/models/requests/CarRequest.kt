package ua.nure.andrii.yahniukov.api.models.requests

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CarRequest(
    @Expose
    @SerializedName("vinCode")
    val vinCode: String
)
