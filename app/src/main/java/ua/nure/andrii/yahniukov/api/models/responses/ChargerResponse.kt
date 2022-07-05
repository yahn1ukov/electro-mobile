package ua.nure.andrii.yahniukov.api.models.responses

import com.google.gson.annotations.Expose
import java.util.*

data class ChargerResponse(
    @Expose
    val id: Long,
    @Expose
    val code: String,
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
    val isFast: Boolean,
    @Expose
    val isPay: Boolean,
    @Expose
    val company: String,
    @Expose
    val priceOfPerHour: Float,
    @Expose
    val typeConnector: String,
    @Expose
    val timeFrom: String,
    @Expose
    val timeTo: String,
    @Expose
    val createdAt: Date
)