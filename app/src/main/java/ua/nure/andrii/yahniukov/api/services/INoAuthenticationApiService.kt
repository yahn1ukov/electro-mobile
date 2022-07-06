package ua.nure.andrii.yahniukov.api.services

import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST
import ua.nure.andrii.yahniukov.api.models.requests.LoginRequest
import ua.nure.andrii.yahniukov.api.models.requests.RegistrationRequest
import ua.nure.andrii.yahniukov.api.models.responses.LoginResponse
import ua.nure.andrii.yahniukov.api.models.responses.MessageResponse

interface INoAuthenticationApiService {
    @POST("api/v1/authentication/login")
    fun login(@Body login: LoginRequest): Single<LoginResponse>

    @POST("api/v1/authentication/registration/users")
    fun registration(@Body register: RegistrationRequest): Single<MessageResponse>
}