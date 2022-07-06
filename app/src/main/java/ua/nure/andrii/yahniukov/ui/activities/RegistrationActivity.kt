package ua.nure.andrii.yahniukov.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import ua.nure.andrii.yahniukov.R
import ua.nure.andrii.yahniukov.databinding.ActivityRegistrationBinding
import ua.nure.andrii.yahniukov.extension.showToast
import ua.nure.andrii.yahniukov.ui.viewModels.RegistrationViewModel

class RegistrationActivity : BaseActivity() {
    private lateinit var binding: ActivityRegistrationBinding

    private lateinit var viewModel: RegistrationViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[RegistrationViewModel::class.java]

        viewModel.registrationLiveData.observe(this) {
            binding.root.showToast(resources.getString(R.string.message_registration))
            val intent = Intent(this, LoginActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            }
            startActivity(intent)
        }

        binding.formRegistrationBtn.setOnClickListener {
            viewModel.registration(
                binding.formRegistrationEmail.text.toString(),
                binding.formRegistrationFirstName.text.toString(),
                binding.formRegistrationLastName.text.toString(),
                binding.formRegistrationPassword.text.toString()
            )
        }

        binding.formLoginLink.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    LoginActivity::class.java
                )
            )
        }
    }
}