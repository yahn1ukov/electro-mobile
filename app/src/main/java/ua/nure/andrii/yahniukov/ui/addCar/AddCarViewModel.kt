package ua.nure.andrii.yahniukov.ui.addCar

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import ua.nure.andrii.yahniukov.api.getAuthenticationApiService
import ua.nure.andrii.yahniukov.api.models.requests.CarRequest
import ua.nure.andrii.yahniukov.api.models.responses.MessageResponse

class AddCarViewModel : ViewModel() {
    private val apiService = getAuthenticationApiService()
    val addCarLiveData = MutableLiveData<MessageResponse>()
    private val compositeDisposable = CompositeDisposable()

    fun addCarToUser(vinCode: String) {
        val request = CarRequest(vinCode)
        apiService.addCarToUser(request)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({ response ->
                addCarLiveData.value = response
            }, {

            })
            .addTo(compositeDisposable)
    }

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }
}