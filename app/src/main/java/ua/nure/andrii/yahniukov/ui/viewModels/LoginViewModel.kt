package ua.nure.andrii.yahniukov.ui.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import ua.nure.andrii.yahniukov.api.AppPrefs
import ua.nure.andrii.yahniukov.api.getNoAuthenticationApiService
import ua.nure.andrii.yahniukov.api.models.requests.LoginRequest
import ua.nure.andrii.yahniukov.api.models.responses.LoginResponse

class LoginViewModel : ViewModel() {
    private val apiService = getNoAuthenticationApiService()
    private val prefs = AppPrefs()
    val loginLiveData = MutableLiveData<Boolean>()
    private val compositeDisposable = CompositeDisposable()

    fun login(email: String, password: String) {
        val request = LoginRequest(email, password)
        apiService.login(request)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response: LoginResponse ->
                prefs.saveToken(response.token)
                loginLiveData.value = true
            }, {
                loginLiveData.value = false
            })
            .addTo(compositeDisposable)
    }

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }
}