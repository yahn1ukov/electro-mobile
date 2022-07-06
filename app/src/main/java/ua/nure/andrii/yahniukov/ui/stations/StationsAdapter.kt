package ua.nure.andrii.yahniukov.ui.stations

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ua.nure.andrii.yahniukov.R
import ua.nure.andrii.yahniukov.api.models.responses.StationResponse
import ua.nure.andrii.yahniukov.databinding.ListItemStationBinding

class StationsAdapter(
    private val listener: StationsAdapterListener
) : RecyclerView.Adapter<StationsAdapter.StationsViewHolder>() {
    private val items: MutableList<StationResponse> = mutableListOf()

    fun updateItems(newItems: List<StationResponse>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StationsViewHolder {
        val binding = ListItemStationBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return StationsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StationsViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    inner class StationsViewHolder(
        private val binding: ListItemStationBinding
    ) :
        RecyclerView.ViewHolder(binding.root) {

        private val context: Context get() = binding.root.context

        fun bind(item: StationResponse) {
            binding.listStationItemId.text = context.getString(
                R.string.service_adapter_id_placeholder,
                item.id.toString()
            )
            binding.listStationItemName.text = context.getString(
                R.string.service_adapter_name_placeholder,
                item.name
            )
            binding.listStationItemCountry.text = context.getString(
                R.string.service_adapter_country_placeholder,
                item.country
            )
            binding.listStationItemCity.text = context.getString(
                R.string.service_adapter_city_placeholder,
                item.city
            )
            binding.listStationItemStreet.text = context.getString(
                R.string.service_adapter_street_placeholder,
                item.street
            )

            binding.root.setOnClickListener {
                listener.onStationTap(item.id)
            }
        }
    }
}

interface StationsAdapterListener {
    fun onStationTap(id: Long)
}