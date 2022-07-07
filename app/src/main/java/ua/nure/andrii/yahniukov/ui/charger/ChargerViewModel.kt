package ua.nure.andrii.yahniukov.ui.charger

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import ua.nure.andrii.yahniukov.api.getAuthenticationApiService
import ua.nure.andrii.yahniukov.api.models.requests.ComplaintRequest
import ua.nure.andrii.yahniukov.api.models.responses.ChargerResponse
import ua.nure.andrii.yahniukov.api.models.responses.MessageResponse

class ChargerViewModel : ViewModel() {
    private val compositeDisposable = CompositeDisposable()
    private val apiService = getAuthenticationApiService()
    val chargerLiveData = MutableLiveData<ChargerResponse>()
    val complaintLiveData = MutableLiveData<MessageResponse>()

    fun getCharger(chargerId: Long) {
        apiService.getCharger(chargerId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ charger ->
                chargerLiveData.value = charger
            }, {

            })
            .addTo(compositeDisposable)
    }

    fun createComplaintUserCharger(chargerId: Long, description: String) {
        val request = ComplaintRequest(description)
        apiService.createComplaintUserCharger(chargerId, request)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                complaintLiveData.value = response
            }, {

            })
            .addTo(compositeDisposable)
    }

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }
}