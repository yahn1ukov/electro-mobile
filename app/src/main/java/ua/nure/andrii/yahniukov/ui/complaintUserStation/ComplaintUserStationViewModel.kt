package ua.nure.andrii.yahniukov.ui.complaintUserStation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import ua.nure.andrii.yahniukov.api.getAuthenticationApiService
import ua.nure.andrii.yahniukov.api.models.requests.ComplaintRequest
import ua.nure.andrii.yahniukov.api.models.responses.MessageResponse

class ComplaintUserStationViewModel : ViewModel() {
    private val compositeDisposable = CompositeDisposable()
    private val apiService = getAuthenticationApiService()
    val complaintLiveData = MutableLiveData<MessageResponse>()

    fun createComplaintUserStation(stationId: Long, description: String) {
        val request = ComplaintRequest(description)
        apiService.createComplaintUserStation(stationId, request)
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