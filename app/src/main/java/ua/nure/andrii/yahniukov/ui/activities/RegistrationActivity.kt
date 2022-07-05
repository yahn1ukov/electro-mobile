package ua.nure.andrii.yahniukov.ui.activities

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import ua.nure.andrii.yahniukov.R
import ua.nure.andrii.yahniukov.databinding.ActivityRegistrationBinding

class RegistrationActivity : BaseActivity() {
    private lateinit var binding: ActivityRegistrationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)

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