package ua.nure.andrii.yahniukov.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ua.nure.andrii.yahniukov.R
import ua.nure.andrii.yahniukov.models.ServicesViewModel

class ServicesAdapter(private val servicesList : List<ServicesViewModel>) :
    RecyclerView.Adapter<ServicesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.service_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val servicesViewModel = servicesList[position]
        holder.idView.text = servicesViewModel.id.toString()
        holder.nameView.text = servicesViewModel.name
        holder.countryView.text = servicesViewModel.country
        holder.cityView.text = servicesViewModel.city
        holder.streetView.text = servicesViewModel.street
    }

    override fun getItemCount(): Int {
        return servicesList.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val idView: TextView = itemView.findViewById(R.id.list_service_item_id)
        val nameView: TextView = itemView.findViewById(R.id.list_service_item_name)
        val countryView: TextView = itemView.findViewById(R.id.list_service_item_country)
        val cityView: TextView = itemView.findViewById(R.id.list_service_item_city)
        val streetView: TextView = itemView.findViewById(R.id.list_service_item_street)
    }
}