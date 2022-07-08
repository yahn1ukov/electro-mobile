package ua.nure.andrii.yahniukov.ui.charger

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import ua.nure.andrii.yahniukov.R
import ua.nure.andrii.yahniukov.databinding.FragmentChargerBinding

class ChargerFragment : Fragment(), ChargerListener {

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

        binding.chargerComplaintBtn.setOnClickListener {
            onChargerTap(args.chargerId)
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
            if (charger.isFast) {
                binding.chargerIsFast.text =
                    resources.getText(R.string.maintenance_power_fast_placeholder)
            } else {
                binding.chargerIsFast.text =
                    resources.getText(R.string.maintenance_power_low_placeholder)
            }
            if (charger.isPay) {
                binding.chargerIsPay.text = resources.getText(R.string.maintenance_yes_placeholder)
            } else {
                binding.chargerIsPay.text = resources.getText(R.string.maintenance_no_placeholder)
            }
            binding.chargerPriceOfPerHour.text =
                charger.priceOfPerHour.toString() + resources.getString(
                    R.string.maintenance_per_hour_placeholder
                )
            binding.chargerTypeConnector.text = charger.typeConnector
            binding.chargerCompany.text = charger.company
            binding.chargerTimeFrom.text = charger.timeFrom
            binding.chargerTimeTo.text = charger.timeTo
        }
    }

    override fun onChargerTap(chargerId: Long) {
        val action = ChargerFragmentDirections.toNavigationChargerComplaint(chargerId)
        findNavController().navigate(action)
    }
}