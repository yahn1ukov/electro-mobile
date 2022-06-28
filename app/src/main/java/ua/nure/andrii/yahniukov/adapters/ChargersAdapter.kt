package ua.nure.andrii.yahniukov.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ua.nure.andrii.yahniukov.R
import ua.nure.andrii.yahniukov.models.ChargersViewModel

class ChargersAdapter(private val chargersList : List<ChargersViewModel>) :
    RecyclerView.Adapter<ChargersAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.charger_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val chargersViewModel = chargersList[position]
        holder.idView.text = chargersViewModel.id.toString()
        holder.codeView.text = chargersViewModel.code
        holder.countryView.text = chargersViewModel.country
        holder.cityView.text = chargersViewModel.city
        holder.streetView.text = chargersViewModel.street
    }

    override fun getItemCount(): Int {
        return chargersList.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val idView: TextView = itemView.findViewById(R.id.list_charger_item_id)
        val codeView: TextView = itemView.findViewById(R.id.list_charger_item_code)
        val countryView: TextView = itemView.findViewById(R.id.list_charger_item_country)
        val cityView: TextView = itemView.findViewById(R.id.list_charger_item_city)
        val streetView: TextView = itemView.findViewById(R.id.list_charger_item_street)
    }
}