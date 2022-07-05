package ua.nure.andrii.yahniukov.api

import android.content.Context
import ua.nure.andrii.yahniukov.ElectroApp
import java.util.*

class AppPrefs {
    private val prefs = ElectroApp.instance.getSharedPreferences(
        "ElectroPrefs",
        Context.MODE_PRIVATE
    )

    fun saveToken(token: String) {
        prefs.edit()
            .putString("TOKEN", token)
            .apply()
    }

    fun getToken(): String {
        return prefs.getString("TOKEN", "") ?: ""
    }

    fun saveLanguageCode(code: String) {
        prefs.edit()
            .putString("LANGUAGE_CODE", code)
            .apply()
    }

    private fun getLanguageCode(): String? {
        return prefs.getString("LANGUAGE_CODE", null)
    }

    fun getSavedLocale(): Locale {
        val languageCode = getLanguageCode()

        return languageCode?.let { Locale(it) } ?: Locale("en")
    }
}