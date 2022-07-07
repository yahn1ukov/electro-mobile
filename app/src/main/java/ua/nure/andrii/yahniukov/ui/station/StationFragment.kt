package ua.nure.andrii.yahniukov.ui.station

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import ua.nure.andrii.yahniukov.R
import ua.nure.andrii.yahniukov.databinding.FragmentStationBinding
import ua.nure.andrii.yahniukov.extension.showToast

class StationFragment : Fragment() {
    private var _binding: FragmentStationBinding? = null

    private val binding get() = _binding!!

    private val args: StationFragmentArgs by navArgs()

    private lateinit var viewModel: StationViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStationBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[StationViewModel::class.java]
        viewModel.getStation(args.stationId)

        binding.formComplaintStationBtn.setOnClickListener {
            viewModel.createComplaintUserStation(
                args.stationId,
                binding.formComplaintStationDescription.text.toString()
            )
            binding.root.showToast(requireContext().getString(R.string.message_complaint))
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.stationLiveData.observe(viewLifecycleOwner) { station ->
            binding.stationName.text = station.name
            binding.stationCountry.text =
                station.country
            binding.stationCity.text = station.city
            binding.stationStreet.text = station.street
            binding.stationZipCode.text = station.zipCode.toString()
            binding.stationCarName.text = station.carName
            binding.stationCarModel.text = station.carModel
            binding.stationAllPlace.text = station.allPlace.toString()
            binding.stationFreePlace.text = station.freePlace.toString()
            binding.stationTimeFrom.text = station.timeFrom
            binding.stationTimeTo.text = station.timeTo
            binding.stationCompany.text = station.company
            binding.stationMiddlePriceForPerHour.text = station.middlePriceForPerHour.toString()
        }
    }
}