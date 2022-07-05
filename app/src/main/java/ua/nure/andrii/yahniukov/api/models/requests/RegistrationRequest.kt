package ua.nure.andrii.yahniukov.api.models.requests

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RegistrationRequest(
    @Expose
    @SerializedName("email")
    val email: String,
    @Expose
    @SerializedName("firstName")
    val firstName: String,
    @Expose
    @SerializedName("lastName")
    val lastName: String,
    @Expose
    @SerializedName("password")
    val password: String
)