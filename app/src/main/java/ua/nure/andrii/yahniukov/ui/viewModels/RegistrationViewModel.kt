package ua.nure.andrii.yahniukov.ui.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import ua.nure.andrii.yahniukov.api.getNoAuthenticationApiService
import ua.nure.andrii.yahniukov.api.models.requests.RegistrationRequest
import ua.nure.andrii.yahniukov.api.models.responses.MessageResponse

class RegistrationViewModel : ViewModel() {
    private val apiService = getNoAuthenticationApiService()
    val registrationLiveData = MutableLiveData<MessageResponse>()
    private val compositeDisposable = CompositeDisposable()

    fun registration(email: String, firstName: String, lastName: String, password: String) {
        val request = RegistrationRequest(email, firstName, lastName, password)
        apiService.registration(request)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({ response ->
                registrationLiveData.value = response
            }, {

            })
            .addTo(compositeDisposable)
    }

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }
}