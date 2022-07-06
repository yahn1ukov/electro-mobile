package ua.nure.andrii.yahniukov.extension

import android.view.View
import com.google.android.material.snackbar.Snackbar

fun View.showToast(text: String) {
    Snackbar.make(this, text, Snackbar.LENGTH_LONG).show()
}