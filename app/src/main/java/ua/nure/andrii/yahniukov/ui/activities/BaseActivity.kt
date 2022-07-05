package ua.nure.andrii.yahniukov.ui.activities

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ua.nure.andrii.yahniukov.extension.forceSetLocale
import ua.nure.andrii.yahniukov.ui.ElectroApp

abstract class BaseActivity : AppCompatActivity() {
    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(newBase)
        newBase?.forceSetLocale(ElectroApp.currentLocale)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        ElectroApp.instance.baseContext.forceSetLocale(ElectroApp.currentLocale)
        ElectroApp.instance.applicationContext.forceSetLocale(ElectroApp.currentLocale)
    }

    override fun applyOverrideConfiguration(overrideConfiguration: Configuration?) {
        super.applyOverrideConfiguration(overrideConfiguration?.apply {
            setLocale(ElectroApp.currentLocale)
            setLayoutDirection(ElectroApp.currentLocale)
        })
    }
}