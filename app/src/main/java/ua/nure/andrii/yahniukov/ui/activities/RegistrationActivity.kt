package ua.nure.andrii.yahniukov.ui.activities

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import ua.nure.andrii.yahniukov.R

class RegistrationActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        val loginLinkBtn = findViewById<TextView>(R.id.form_login_link)

        loginLinkBtn.setOnClickListener {
            startActivity(
                Intent(
                    this@RegistrationActivity,
                    LoginActivity::class.java
                )
            )
        }
    }
}