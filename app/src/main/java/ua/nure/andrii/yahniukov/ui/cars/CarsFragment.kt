package ua.nure.andrii.yahniukov.ui.cars

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ua.nure.andrii.yahniukov.databinding.FragmentCarsBinding

class CarsFragment : Fragment(), CarsAdapterListener {

    private var _binding: FragmentCarsBinding? = null

    private val binding get() = _binding!!

    private lateinit var viewModel: CarsViewModel
    private lateinit var adapter: CarsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this)[CarsViewModel::class.java]
        _binding = FragmentCarsBinding.inflate(inflater, container, false)
        adapter = CarsAdapter(this)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rcvCars.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        binding.rcvCars.adapter = adapter

        viewModel.getCars()
        viewModel.carsLiveData.observe(viewLifecycleOwner) { chargers ->
            adapter.updateItems(chargers)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCarTap(id: Long) {

    }
}