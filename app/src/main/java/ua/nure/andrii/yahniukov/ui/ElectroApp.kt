package ua.nure.andrii.yahniukov.ui

import android.app.Application
import android.content.Context
import ua.nure.andrii.yahniukov.api.AppPrefs
import ua.nure.andrii.yahniukov.extension.forceSetLocale

class ElectroApp : Application() {
    private lateinit var prefs: AppPrefs

    companion object {
        lateinit var instance: ElectroApp private set
        val currentLocale get() = instance.prefs.getSavedLocale()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        forceSetLocale(currentLocale)
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        instance = this
        if (this::prefs.isInitialized.not()) {
            prefs = AppPrefs()
        }
        base?.forceSetLocale(prefs.getSavedLocale())
    }
}