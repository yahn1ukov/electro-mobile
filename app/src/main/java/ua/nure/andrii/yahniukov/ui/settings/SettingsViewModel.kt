package ua.nure.andrii.yahniukov.ui.settings

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import ua.nure.andrii.yahniukov.api.AppPrefs

class SettingsViewModel : ViewModel() {
    private val prefs = AppPrefs()
    private val compositeDisposable = CompositeDisposable()
    val logoutLiveData = MutableLiveData<Boolean>()

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