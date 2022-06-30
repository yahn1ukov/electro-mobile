package ua.nure.andrii.yahniukov.api.models

data class LoginResponse(val id: Long, val email: String, val role: String, val token: String)