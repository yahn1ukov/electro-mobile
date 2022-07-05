package ua.nure.andrii.yahniukov.extension

import android.annotation.TargetApi
import android.content.Context
import android.content.res.Configuration
import android.os.Build
import androidx.core.os.ConfigurationCompat
import java.util.*

fun Context.forceSetLocale(targetLocale: Locale): Boolean {
    if (this.isCurrentLocaleSet(targetLocale)) {
        return false
    }

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        this.updateResources(targetLocale)
    }
    this.updateResourcesLegacy(targetLocale)

    return true
}

fun Context.isCurrentLocaleSet(targetLocale: Locale): Boolean {
    val actualLocale = ConfigurationCompat.getLocales(this.resources.configuration).get(0)

    return actualLocale?.toLanguageTag() == targetLocale.toLanguageTag()
}

@TargetApi(Build.VERSION_CODES.N)
private fun Context.updateResources(locale: Locale): Context {
    val configuration = this.resources.configuration
    Locale.setDefault(locale)
    configuration.setLocale(locale)
    configuration.setLayoutDirection(locale)

    return this.createConfigurationContext(configuration)
}

@Suppress("DEPRECATION")
private fun Context.updateResourcesLegacy(locale: Locale): Context {
    Locale.setDefault(locale)
    val resources = this.resources
    val configuration: Configuration = resources.configuration
    configuration.locale = locale

    configuration.setLayoutDirection(locale)

    resources.updateConfiguration(configuration, resources.displayMetrics)
    return this
}