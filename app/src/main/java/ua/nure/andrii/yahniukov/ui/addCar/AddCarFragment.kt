package ua.nure.andrii.yahniukov.ui.addCar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ua.nure.andrii.yahniukov.R
import ua.nure.andrii.yahniukov.databinding.FragmentAddCarBinding
import ua.nure.andrii.yahniukov.extension.showToast

class AddCarFragment : Fragment() {
    private var _binding: FragmentAddCarBinding? = null

    private val binding get() = _binding!!

    private lateinit var viewModel: AddCarViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this)[AddCarViewModel::class.java]
        _binding = FragmentAddCarBinding.inflate(inflater, container, false)

        binding.formAddCarBtn.setOnClickListener {
            viewModel.addCarToUser(
                binding.formAddCarVinCode.text.toString()
            )
            binding.root.showToast(requireContext().getString(R.string.message_add_car))
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}