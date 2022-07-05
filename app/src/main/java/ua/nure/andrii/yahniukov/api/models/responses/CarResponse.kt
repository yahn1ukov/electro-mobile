package ua.nure.andrii.yahniukov.api.models.responses

import com.google.gson.annotations.Expose
import java.util.*

data class CarResponse(
    @Expose
    val id: Long,
    @Expose
    val name: String,
    @Expose
    val model: String,
    @Expose
    val vinCode: String,
    @Expose
    val latitude: Double,
    @Expose
    val longitude: Double,
    @Expose
    val mileage: Int,
    @Expose
    val typeConnector: String,
    @Expose
    val percentageOfCharge: Int,
    @Expose
    val createdAt: Date
)