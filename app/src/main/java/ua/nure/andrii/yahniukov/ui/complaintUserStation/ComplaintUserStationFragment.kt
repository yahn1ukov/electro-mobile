package ua.nure.andrii.yahniukov.ui.complaintUserStation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import ua.nure.andrii.yahniukov.R
import ua.nure.andrii.yahniukov.databinding.FragmentComplaintUserStationBinding
import ua.nure.andrii.yahniukov.extension.showToast

class ComplaintUserStationFragment : Fragment() {
    private var _binding: FragmentComplaintUserStationBinding? = null

    private val binding get() = _binding!!

    private val args: ComplaintUserStationFragmentArgs by navArgs()

    private lateinit var viewModel: ComplaintUserStationViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentComplaintUserStationBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[ComplaintUserStationViewModel::class.java]

        binding.formComplaintStationBtn.setOnClickListener {
            viewModel.createComplaintUserStation(
                args.stationId,
                binding.formComplaintStationDescription.text.toString()
            )
            binding.root.showToast(requireContext().getString(R.string.message_complaint))
        }

        return binding.root
    }
}