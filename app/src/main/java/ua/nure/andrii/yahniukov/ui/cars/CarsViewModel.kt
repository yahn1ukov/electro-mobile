package ua.nure.andrii.yahniukov.ui.cars

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import ua.nure.andrii.yahniukov.api.getAuthenticationApiService
import ua.nure.andrii.yahniukov.api.models.responses.CarResponse

class CarsViewModel : ViewModel() {
    private val compositeDisposable = CompositeDisposable()
    private val apiService = getAuthenticationApiService()

    val carsLiveData = MutableLiveData<List<CarResponse>>()

    fun getCars() {
        apiService.getAllCars()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ cars ->
                carsLiveData.value = cars
            }, {
            })
            .addTo(compositeDisposable)
    }

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }
}