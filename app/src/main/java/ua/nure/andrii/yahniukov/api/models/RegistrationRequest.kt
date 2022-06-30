package ua.nure.andrii.yahniukov.api.models

data class RegistrationRequest(
    val email: String,
    val firstName: String,
    val lastName: String,
    val password: String
)