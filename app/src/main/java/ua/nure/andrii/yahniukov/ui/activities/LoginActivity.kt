package ua.nure.andrii.yahniukov.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import ua.nure.andrii.yahniukov.databinding.ActivityLoginBinding
import ua.nure.andrii.yahniukov.ui.viewModels.LoginViewModel


class LoginActivity : BaseActivity() {
    private lateinit var binding: ActivityLoginBinding

    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[LoginViewModel::class.java]

        viewModel.loginLiveData.observe(this) { success ->
            if (success) {
                val intent = Intent(this, MainActivity::class.java).apply {
                    flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                }
                startActivity(intent)
            }
        }

        binding.formLoginBtn.setOnClickListener {
            viewModel.login(
                binding.formLoginEmail.text.toString(),
                binding.formLoginPassword.text.toString()
            )
        }

        binding.formRegistrationLink.setOnClickListener { finish() }
    }
}