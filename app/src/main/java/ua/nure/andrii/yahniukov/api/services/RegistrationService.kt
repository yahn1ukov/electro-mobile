package ua.nure.andrii.yahniukov.api.services

import retrofit2.http.Body
import retrofit2.http.POST
import ua.nure.andrii.yahniukov.api.models.RegistrationRequest

interface RegistrationService {
    @POST("/api/v1/auth/register/user")
    fun register(@Body register: RegistrationRequest)
}