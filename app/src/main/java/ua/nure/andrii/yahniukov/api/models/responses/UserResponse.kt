package ua.nure.andrii.yahniukov.api.models.responses

import com.google.gson.annotations.Expose
import java.util.*

data class UserResponse(
    @Expose
    val id: Long,
    @Expose
    val email: String,
    @Expose
    val fullName: String,
    @Expose
    val role: String,
    @Expose
    val isNotBlock: Boolean,
    @Expose
    val createdAt: Date
)