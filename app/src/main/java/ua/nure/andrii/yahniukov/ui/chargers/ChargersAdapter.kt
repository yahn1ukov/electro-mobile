package ua.nure.andrii.yahniukov.ui.chargers

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ua.nure.andrii.yahniukov.R
import ua.nure.andrii.yahniukov.api.models.responses.ChargerResponse
import ua.nure.andrii.yahniukov.databinding.ListItemChargerBinding

class ChargersAdapter(
    private val listener: ChargersAdapterListener
) : RecyclerView.Adapter<ChargersAdapter.ChargersViewHolder>() {
    private val items: MutableList<ChargerResponse> = mutableListOf()

    fun updateItems(newItems: List<ChargerResponse>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChargersViewHolder {
        val binding = ListItemChargerBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ChargersViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ChargersViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    inner class ChargersViewHolder(
        private val binding: ListItemChargerBinding
    ) :
        RecyclerView.ViewHolder(binding.root) {

        private val context: Context get() = binding.root.context

        fun bind(item: ChargerResponse) {
            binding.listChargerItemId.text = context.getString(
                R.string.charger_adapter_id_placeholder,
                item.id.toString()
            )
            binding.listChargerItemCode.text = context.getString(
                R.string.charger_adapter_code_placeholder,
                item.code
            )
            binding.listChargerItemCountry.text = context.getString(
                R.string.charger_adapter_country_placeholder,
                item.country
            )
            binding.listChargerItemCity.text = context.getString(
                R.string.charger_adapter_city_placeholder,
                item.city
            )
            binding.listChargerItemStreet.text = context.getString(
                R.string.charger_adapter_street_placeholder,
                item.street
            )

            binding.root.setOnClickListener {
                listener.onChargerTap(item.id)
            }
        }
    }

}

interface ChargersAdapterListener {
    fun onChargerTap(id: Long)
}