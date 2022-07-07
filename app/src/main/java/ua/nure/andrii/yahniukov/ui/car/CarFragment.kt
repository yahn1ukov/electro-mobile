package ua.nure.andrii.yahniukov.ui.car

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import ua.nure.andrii.yahniukov.R
import ua.nure.andrii.yahniukov.databinding.FragmentCarBinding
import ua.nure.andrii.yahniukov.extension.showToast

class CarFragment : Fragment() {
    private var _binding: FragmentCarBinding? = null

    private val binding get() = _binding!!

    private val args: CarFragmentArgs by navArgs()

    private lateinit var viewModel: CarViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCarBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[CarViewModel::class.java]
        viewModel.getCar(args.carId)

        binding.carBtnDelete.setOnClickListener {
            viewModel.deleteCar(args.carId)
            binding.root.showToast(requireContext().getString(R.string.message_delete_car))
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getCarLiveData.observe(viewLifecycleOwner) { car ->
            binding.carItemFullName.text = car.name + " " + car.model
            binding.carItemVinCode.text = car.vinCode
            binding.carItemMileage.text = car.mileage.toString()
            binding.carItemTypeConnector.text = car.typeConnector
            binding.carItemBattery.text = car.percentageOfCharge.toString() + "%"
        }
    }
}