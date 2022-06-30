package ua.nure.andrii.yahniukov.activities.authentication

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.text.TextUtils
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ua.nure.andrii.yahniukov.R
import ua.nure.andrii.yahniukov.activities.screens.ChargerActivity
import ua.nure.andrii.yahniukov.api.models.LoginRequest
import ua.nure.andrii.yahniukov.api.models.LoginResponse
import ua.nure.andrii.yahniukov.api.services.LoginService


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val registerLinkBtn = findViewById<TextView>(R.id.form_register_link)

        registerLinkBtn.setOnClickListener { finish() }

        val loginEmail = findViewById<TextInputEditText>(R.id.form_login_email)
        val loginPassword = findViewById<TextInputEditText>(R.id.form_login_password)
        val loginBtn = findViewById<Button>(R.id.form_login_btn)

        loginBtn.setOnClickListener {
            if (TextUtils.isEmpty(loginEmail.text.toString()) || TextUtils.isEmpty(loginPassword.text.toString())) {
                Toast.makeText(
                    this@LoginActivity,
                    R.string.form_login_message_required,
                    Toast.LENGTH_LONG
                ).show()
            } else {
                login(loginEmail.text.toString(), loginPassword.text.toString())
            }
        }

    }

    private fun login(loginEmail: String, loginPassword: String) {
        val loginRequest = LoginRequest(loginEmail, loginPassword)

        val loginResponse: Call<LoginResponse> = getLoginService().login(loginRequest)

        loginResponse.enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.isSuccessful) {
                    Toast.makeText(
                        this@LoginActivity,
                        R.string.form_login_message_success,
                        Toast.LENGTH_LONG
                    ).show()
                    Handler().postDelayed({
                        startActivity(
                            Intent(this@LoginActivity, ChargerActivity::class.java)
                                .putExtra("id", response.body()?.id)
                                .putExtra("email", response.body()?.email)
                                .putExtra("token", response.body()?.token)
                                .putExtra("role", response.body()?.role)
                        )
                    }, 500)
                } else {
                    Toast.makeText(
                        this@LoginActivity,
                        R.string.form_login_message_error,
                        Toast.LENGTH_LONG
                    ).show()
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Toast.makeText(
                    this@LoginActivity,
                    R.string.form_login_message_error,
                    Toast.LENGTH_LONG
                ).show()
            }

        })
    }

    private fun getRetrofit(): Retrofit {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        val okHttpClient: OkHttpClient =
            OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build()

        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://localhost:8080")
            .client(okHttpClient)
            .build()
    }

    private fun getLoginService(): LoginService {
        return getRetrofit().create(LoginService::class.java)
    }
}