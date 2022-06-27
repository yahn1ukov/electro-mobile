package ua.nure.andrii.yahniukov.activities.authentication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import ua.nure.andrii.yahniukov.R
import ua.nure.andrii.yahniukov.activities.screens.ChargerActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val registerLinkBtn = findViewById<TextView>(R.id.form_register_link)

        registerLinkBtn.setOnClickListener { finish() }

        val loginBtn = findViewById<Button>(R.id.form_login_btn)

        loginBtn.setOnClickListener { startActivity(Intent(this, ChargerActivity::class.java)) }
    }
}