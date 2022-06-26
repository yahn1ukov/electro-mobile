package ua.nure.andrii.yahniukov

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loginLinkBtn = findViewById<TextView>(R.id.form_login_link)

        loginLinkBtn.setOnClickListener {
            val intentToLoginActivity = Intent(this, LoginActivity::class.java)
            startActivity(intentToLoginActivity)
        }
    }
}