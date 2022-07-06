package ua.nure.andrii.yahniukov.ui.chargers

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import ua.nure.andrii.yahniukov.api.getAuthenticationApiService
import ua.nure.andrii.yahniukov.api.models.responses.ChargerResponse

class ChargersViewModel : ViewModel() {
    private val compositeDisposable = CompositeDisposable()
    private val apiService = getAuthenticationApiService()
    val chargersLiveData = MutableLiveData<List<ChargerResponse>>()

    fun getChargers() {
        apiService.getAllChargers()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ chargers ->
                chargersLiveData.value = chargers
            }, {
            })
            .addTo(compositeDisposable)
    }

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }
}