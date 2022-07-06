package ua.nure.andrii.yahniukov.ui.stations

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import ua.nure.andrii.yahniukov.api.getAuthenticationApiService
import ua.nure.andrii.yahniukov.api.models.responses.StationResponse

class StationsViewModel : ViewModel() {
    private val compositeDisposable = CompositeDisposable()
    private val apiService = getAuthenticationApiService()

    val stationsLiveData = MutableLiveData<List<StationResponse>>()

    fun getStations() {
        apiService.getAllStations()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ stations ->
                stationsLiveData.value = stations
            }, {
            })
            .addTo(compositeDisposable)
    }

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }
}