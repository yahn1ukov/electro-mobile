package ua.nure.andrii.yahniukov.activities.authentication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import ua.nure.andrii.yahniukov.R

class RegistrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        val loginLinkBtn = findViewById<TextView>(R.id.form_login_link)

        loginLinkBtn.setOnClickListener { startActivity(Intent(this, LoginActivity::class.java)) }
    }
}