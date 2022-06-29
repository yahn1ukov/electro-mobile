package ua.nure.andrii.yahniukov.activities.screens

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ua.nure.andrii.yahniukov.activities.navigation.DrawerBaseActivity
import ua.nure.andrii.yahniukov.databinding.ActivityUserBinding
import ua.nure.andrii.yahniukov.R
import ua.nure.andrii.yahniukov.adapters.CarsAdapter
import ua.nure.andrii.yahniukov.models.CarsViewModel

class UserActivity : DrawerBaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityUserBinding : ActivityUserBinding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(activityUserBinding.root)
        allocatedActivityTitle(resources.getString(R.string.nav_menu_you))

        val carsRecyclerView = findViewById<RecyclerView>(R.id.carsRecyclerView)
        carsRecyclerView.layoutManager = LinearLayoutManager(this)

        val data = ArrayList<CarsViewModel>()

        data.add(CarsViewModel(1L, "ASDF7AS98F7S9D7F", "Nissan", "Leaf"))

        val adapter = CarsAdapter(data)

        carsRecyclerView.adapter = adapter
    }
}