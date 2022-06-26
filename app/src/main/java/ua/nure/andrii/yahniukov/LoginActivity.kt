package ua.nure.andrii.yahniukov

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val registerLinkBtn = findViewById<TextView>(R.id.form_register_link)

        registerLinkBtn.setOnClickListener { finish() }
    }
}