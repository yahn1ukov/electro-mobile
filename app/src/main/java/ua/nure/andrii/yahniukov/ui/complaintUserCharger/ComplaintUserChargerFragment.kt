package ua.nure.andrii.yahniukov.ui.complaintUserCharger

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import ua.nure.andrii.yahniukov.R
import ua.nure.andrii.yahniukov.databinding.FragmentComplaintUserChargerBinding
import ua.nure.andrii.yahniukov.extension.showToast

class ComplaintUserChargerFragment : Fragment() {
    private var _binding: FragmentComplaintUserChargerBinding? =
        null

    private val binding get() = _binding!!

    private val args: ComplaintUserChargerFragmentArgs by navArgs()

    private lateinit var viewModel: ComplaintUserChargerViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentComplaintUserChargerBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[ComplaintUserChargerViewModel::class.java]

        binding.formComplaintChargerBtn.setOnClickListener {
            viewModel.createComplaintUserCharger(
                args.chargerId,
                binding.formComplaintChargerDescription.text.toString()
            )
            binding.root.showToast(requireContext().getString(R.string.message_complaint))
        }

        return binding.root
    }
}