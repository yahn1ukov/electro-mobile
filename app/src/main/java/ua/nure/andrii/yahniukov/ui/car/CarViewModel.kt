package ua.nure.andrii.yahniukov.ui.car

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import ua.nure.andrii.yahniukov.api.getAuthenticationApiService
import ua.nure.andrii.yahniukov.api.models.responses.CarResponse

class CarViewModel : ViewModel() {
    private val compositeDisposable = CompositeDisposable()
    private val apiService = getAuthenticationApiService()
    val getCarLiveData = MutableLiveData<CarResponse>()
    val deleteCarLiveData = MutableLiveData<Boolean>()

    fun getCar(carId: Long) {
        apiService.getCar(carId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ car ->
                getCarLiveData.value = car
            }, {

            })
            .addTo(compositeDisposable)

    }

    fun deleteCar(carId: Long) {
        apiService.deleteCarFromUser(carId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                deleteCarLiveData.value = true
            }, {
                deleteCarLiveData.value = false
            })
            .addTo(compositeDisposable)
    }
}