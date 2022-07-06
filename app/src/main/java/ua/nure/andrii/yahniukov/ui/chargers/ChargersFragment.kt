package ua.nure.andrii.yahniukov.ui.chargers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ua.nure.andrii.yahniukov.databinding.FragmentChargersBinding

class ChargersFragment : Fragment(), ChargersAdapterListener {

    private var _binding: FragmentChargersBinding? = null

    private val binding get() = _binding!!

    private lateinit var viewModel: ChargersViewModel
    private lateinit var adapter: ChargersAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this)[ChargersViewModel::class.java]
        _binding = FragmentChargersBinding.inflate(inflater, container, false)
        adapter = ChargersAdapter(this)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rcvChargers.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        binding.rcvChargers.adapter = adapter

        viewModel.getChargers()
        viewModel.chargersLiveData.observe(viewLifecycleOwner) { chargers ->
            adapter.updateItems(chargers)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onChargerTap(chargerId: Long) {
        val action = ChargersFragmentDirections.toNavigationCharger(chargerId)
        findNavController().navigate(action)
    }
}