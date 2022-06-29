package ua.nure.andrii.yahniukov.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ua.nure.andrii.yahniukov.R
import ua.nure.andrii.yahniukov.models.CarsViewModel

class CarsAdapter(private val carsList : List<CarsViewModel>) :
    RecyclerView.Adapter<CarsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.car_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val carsViewModel = carsList[position]
        holder.idView.text = carsViewModel.id.toString()
        holder.vinCodeView.text = carsViewModel.vinCode
        holder.nameView.text = carsViewModel.name
        holder.modelView.text = carsViewModel.model
    }

    override fun getItemCount(): Int {
        return carsList.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val idView: TextView = itemView.findViewById(R.id.list_car_item_id)
        val vinCodeView: TextView = itemView.findViewById(R.id.list_car_item_vin_code)
        val nameView: TextView = itemView.findViewById(R.id.list_car_item_name)
        val modelView: TextView = itemView.findViewById(R.id.list_car_item_model)
    }
}