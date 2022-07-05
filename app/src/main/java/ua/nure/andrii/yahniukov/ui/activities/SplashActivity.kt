package ua.nure.andrii.yahniukov.ui.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import ua.nure.andrii.yahniukov.R
import ua.nure.andrii.yahniukov.api.AppPrefs
import ua.nure.andrii.yahniukov.databinding.ActivitySplashBinding

class SplashActivity : BaseActivity() {
    private lateinit var binding: ActivitySplashBinding

    private val prefs = AppPrefs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_splash)

        Handler(Looper.getMainLooper()).postDelayed(
            {
                val token = prefs.getToken()
                val intent = if (token.isEmpty()) {
                    Intent(this, RegistrationActivity::class.java)
                } else {
                    Intent(this, MainActivity::class.java)
                }.apply {
                    flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                }
                startActivity(intent)
            },
            2000
        )
    }
}