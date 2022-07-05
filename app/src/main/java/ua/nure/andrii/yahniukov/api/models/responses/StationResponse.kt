package ua.nure.andrii.yahniukov.api.models.responses

import com.google.gson.annotations.Expose
import java.util.*

data class StationResponse(
    @Expose
    val id: Long,
    @Expose
    val name: String,
    @Expose
    val country: String,
    @Expose
    val city: String,
    @Expose
    val street: String,
    @Expose
    val zipCode: Int,
    @Expose
    val latitude: Double,
    @Expose
    val longitude: Double,
    @Expose
    val carName: String,
    @Expose
    val carModel: String,
    @Expose
    val company: String,
    @Expose
    val middlePriceForPerHour: Float,
    @Expose
    val allPlace: Int,
    @Expose
    val freePlace: Int,
    @Expose
    val timeFrom: String,
    @Expose
    val timeTo: String,
    @Expose
    val createdAt: Date
)
