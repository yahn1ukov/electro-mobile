package ua.nure.andrii.yahniukov.ui.stations

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ua.nure.andrii.yahniukov.databinding.FragmentStationsBinding

class StationsFragment : Fragment(), StationsAdapterListener {

    private var _binding: FragmentStationsBinding? = null

    private val binding get() = _binding!!

    private lateinit var viewModel: StationsViewModel
    private lateinit var adapter: StationsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this)[StationsViewModel::class.java]
        _binding = FragmentStationsBinding.inflate(inflater, container, false)
        adapter = StationsAdapter(this)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rcvStations.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        binding.rcvStations.adapter = adapter

        viewModel.getStations()
        viewModel.stationsLiveData.observe(viewLifecycleOwner) { stations ->
            adapter.updateItems(stations)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onStationTap(id: Long) {

    }
}