package ua.nure.andrii.yahniukov.api.models.responses

import com.google.gson.annotations.Expose

data class LoginResponse(
    @Expose
    val token: String,
    @Expose
    val role: String
)