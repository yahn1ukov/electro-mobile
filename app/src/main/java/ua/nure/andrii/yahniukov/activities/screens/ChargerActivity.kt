package ua.nure.andrii.yahniukov.activities.screens

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ua.nure.andrii.yahniukov.R
import ua.nure.andrii.yahniukov.activities.navigation.DrawerBaseActivity
import ua.nure.andrii.yahniukov.adapters.ChargersAdapter
import ua.nure.andrii.yahniukov.databinding.ActivityChargerBinding
import ua.nure.andrii.yahniukov.models.ChargersViewModel

class ChargerActivity : DrawerBaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityChargerBinding : ActivityChargerBinding = ActivityChargerBinding.inflate(layoutInflater)
        setContentView(activityChargerBinding.root)
        allocatedActivityTitle(resources.getString(R.string.nav_menu_chargers))

        val chargersRecyclerView = findViewById<RecyclerView>(R.id.chargersRecyclerView)
        chargersRecyclerView.layoutManager = LinearLayoutManager(this)

        val data = ArrayList<ChargersViewModel>()

        data.add(ChargersViewModel(1L, "ASDF7AS98F7S9D7F", "Ukraine", "Kharkiv", "St. Podeda 59a"))

        val adapter = ChargersAdapter(data)

        chargersRecyclerView.adapter = adapter
    }
}