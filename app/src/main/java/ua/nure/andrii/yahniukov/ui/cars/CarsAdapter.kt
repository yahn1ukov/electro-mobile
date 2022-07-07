package ua.nure.andrii.yahniukov.ui.cars

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ua.nure.andrii.yahniukov.R
import ua.nure.andrii.yahniukov.api.models.responses.CarResponse
import ua.nure.andrii.yahniukov.databinding.ListItemCarBinding

class CarsAdapter(
    private val listener: CarsAdapterListener
) : RecyclerView.Adapter<CarsAdapter.CarsViewHolder>() {
    private val items: MutableList<CarResponse> = mutableListOf()

    fun updateItems(newItems: List<CarResponse>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarsViewHolder {
        val binding = ListItemCarBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CarsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CarsViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    inner class CarsViewHolder(
        private val binding: ListItemCarBinding
    ) :
        RecyclerView.ViewHolder(binding.root) {

        private val context: Context get() = binding.root.context

        fun bind(item: CarResponse) {
            binding.listCarItemId.text = context.getString(
                R.string.car_adapter_id_placeholder,
                item.id.toString()
            )
            binding.listCarItemName.text = context.getString(
                R.string.car_adapter_name_placeholder,
                item.name
            )
            binding.listCarItemModel.text = context.getString(
                R.string.car_adapter_model_placeholder,
                item.model
            )
            binding.listCarItemVinCode.text = context.getString(
                R.string.car_adapter_vin_code_placeholder,
                item.vinCode
            )

            binding.root.setOnClickListener {
                listener.onCarTap(item.id)
            }
        }
    }

}

interface CarsAdapterListener {
    fun onCarTap(carId: Long)
}