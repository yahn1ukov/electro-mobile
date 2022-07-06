package ua.nure.andrii.yahniukov.ui.user

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ua.nure.andrii.yahniukov.R
import ua.nure.andrii.yahniukov.databinding.FragmentUserBinding
import ua.nure.andrii.yahniukov.extension.forceSetLocale
import ua.nure.andrii.yahniukov.extension.isCurrentLocaleSet
import ua.nure.andrii.yahniukov.ui.ElectroApp
import ua.nure.andrii.yahniukov.ui.activities.LoginActivity
import ua.nure.andrii.yahniukov.ui.activities.SplashActivity
import java.text.SimpleDateFormat
import java.util.*

class UserFragment : Fragment() {
    private var _binding: FragmentUserBinding? = null

    private val binding get() = _binding!!

    private lateinit var viewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this)[UserViewModel::class.java]

        _binding = FragmentUserBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getCurrentUser()
        viewModel.userLiveData.observe(viewLifecycleOwner) { user ->
            binding.userFullName.text = " " + user.fullName
            binding.userEmail.text = " " + user.email
            binding.userCreated.text =
                " " + SimpleDateFormat("dd-MM-yyyy").format(user.createdAt).toString()
        }
        viewModel.logoutLiveData.observe(viewLifecycleOwner) { success ->
            if (success) {
                val intent = Intent(requireContext(), LoginActivity::class.java).apply {
                    flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                }
                startActivity(intent)
            }
        }
        binding.btnLogout.setOnClickListener {
            viewModel.logout()
        }
        val languageMap = mapOf(
            "en" to requireContext().getString(R.string.language_english_name),
            "uk" to requireContext().getString(R.string.language_ukrainian_name),
        )
        val spinnerAdapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_dropdown_item,
            languageMap.values.toList()
        )
        binding.spnLanguage.adapter = spinnerAdapter
        val selectedLocaleIndex = languageMap.toList().indexOfFirst { pair ->
            pair.first == ElectroApp.currentLocale.language
        }
        binding.spnLanguage.setSelection(selectedLocaleIndex)
        binding.spnLanguage.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val selectedLanguageCode = languageMap.keys.toList()[position]
                val selectedLocale = Locale(selectedLanguageCode)
                if (ElectroApp.instance.isCurrentLocaleSet(selectedLocale).not()) {
                    ElectroApp.instance.baseContext.forceSetLocale(selectedLocale)
                    ElectroApp.instance.applicationContext.forceSetLocale(selectedLocale)
                    viewModel.updateLanguage(selectedLanguageCode)
                    val intent = Intent(requireContext(), SplashActivity::class.java).apply {
                        flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    }
                    startActivity(intent)
                }
            }

            override fun onNothingSelected(v: AdapterView<*>?) {}
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}