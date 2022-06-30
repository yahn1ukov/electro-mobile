package ua.nure.andrii.yahniukov.api.services

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import ua.nure.andrii.yahniukov.api.models.LoginRequest
import ua.nure.andrii.yahniukov.api.models.LoginResponse

interface LoginService {
    @POST("/api/v1/auth/login")
    fun login(@Body login: LoginRequest): Call<LoginResponse>
}