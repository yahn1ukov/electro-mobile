package ua.nure.andrii.yahniukov.api.models.requests

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ComplaintRequest(
    @Expose
    @SerializedName("description")
    var description: String
)