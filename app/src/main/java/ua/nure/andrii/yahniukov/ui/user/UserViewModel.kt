package ua.nure.andrii.yahniukov.ui.user

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import ua.nure.andrii.yahniukov.api.AppPrefs
import ua.nure.andrii.yahniukov.api.getAuthenticationApiService
import ua.nure.andrii.yahniukov.api.models.responses.UserResponse

class UserViewModel : ViewModel() {
    private val prefs = AppPrefs()
    private val compositeDisposable = CompositeDisposable()
    val logoutLiveData = MutableLiveData<Boolean>()
    val userLiveData = MutableLiveData<UserResponse>()
    private val apiService = getAuthenticationApiService()

    fun getCurrentUser() {
        apiService.getCurrentUser()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ user ->
                userLiveData.value = user
            }, {
            })
            .addTo(compositeDisposable)
    }

    fun logout() {
        prefs.saveToken("")
        logoutLiveData.value = true
    }

    fun updateLanguage(languageCode: String) {
        prefs.saveLanguageCode(languageCode)
    }

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }
}