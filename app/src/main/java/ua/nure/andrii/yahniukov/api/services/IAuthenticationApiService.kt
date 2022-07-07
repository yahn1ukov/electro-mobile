package ua.nure.andrii.yahniukov.api.services

import io.reactivex.Single
import retrofit2.http.*
import ua.nure.andrii.yahniukov.api.models.requests.CarRequest
import ua.nure.andrii.yahniukov.api.models.requests.ComplaintRequest
import ua.nure.andrii.yahniukov.api.models.responses.*

interface IAuthenticationApiService {
    @POST("api/v1/complaints/users/current/chargers/{chargerId}")
    fun createComplaintUserCharger(
        @Path("chargerId") chargerId: Long,
        @Body description: ComplaintRequest
    ): Single<MessageResponse>

    @POST("api/v1/complaints/users/current/stations/{stationId}")
    fun createComplaintUserStation(
        @Path("stationId") stationId: Long,
        @Body description: ComplaintRequest
    ): Single<MessageResponse>

    @GET("api/v1/users/current")
    fun getCurrentUser(): Single<UserResponse>

    @GET("api/v1/chargers")
    fun getAllChargers(): Single<List<ChargerResponse>>

    @GET("api/v1/chargers/{chargerId}")
    fun getCharger(@Path("chargerId") chargerId: Long): Single<ChargerResponse>

    @GET("api/v1/stations")
    fun getAllStations(): Single<List<StationResponse>>

    @GET("api/v1/stations/{stationId}")
    fun getStation(@Path("stationId") stationId: Long): Single<StationResponse>

    @GET("api/v1/users/current/cars")
    fun getAllCars(): Single<List<CarResponse>>

    @GET("api/v1/cars/{carId}")
    fun getCar(@Path("carId") carId: Long): Single<CarResponse>

    @PATCH("api/v1/users/current/car/add")
    fun addCarToUser(@Body vinCode: CarRequest): Single<MessageResponse>

    @DELETE("api/v1/users/current/cars/{carId}/delete")
    fun deleteCarFromUser(@Path("carId") carId: Long): Single<Boolean>
}