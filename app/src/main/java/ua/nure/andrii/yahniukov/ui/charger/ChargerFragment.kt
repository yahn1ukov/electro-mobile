package ua.nure.andrii.yahniukov.ui.charger

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import ua.nure.andrii.yahniukov.R
import ua.nure.andrii.yahniukov.databinding.FragmentChargerBinding
import ua.nure.andrii.yahniukov.extension.showToast

class ChargerFragment : Fragment() {

    private var _binding: FragmentChargerBinding? = null

    private val binding get() = _binding!!

    private val args: ChargerFragmentArgs by navArgs()

    private lateinit var viewModel: ChargerViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChargerBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[ChargerViewModel::class.java]
        viewModel.getCharger(args.chargerId)

        binding.formComplaintChargerBtn.setOnClickListener {
            viewModel.createComplaintUserCharger(
                args.chargerId,
                binding.formComplaintChargerDescription.text.toString()
            )
            binding.root.showToast(requireContext().getString(R.string.message_complaint))
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.chargerLiveData.observe(viewLifecycleOwner) { charger ->
            binding.chargerCode.text = charger.code
            binding.chargerCountry.text = charger.country
            binding.chargerCity.text = charger.city
            binding.chargerStreet.text = charger.street
            binding.chargerZipCode.text = charger.zipCode.toString()
            binding.chargerIsFast.text = charger.isFast.toString()
            binding.chargerIsPay.text = charger.isPay.toString()
            binding.chargerPriceOfPerHour.text = charger.priceOfPerHour.toString()
            binding.chargerTypeConnector.text = charger.typeConnector
            binding.chargerCompany.text = charger.company
        }
    }
}