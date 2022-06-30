package ua.nure.andrii.yahniukov.activities.screens

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ua.nure.andrii.yahniukov.R
import ua.nure.andrii.yahniukov.activities.navigation.DrawerBaseActivity
import ua.nure.andrii.yahniukov.adapters.ServicesAdapter
import ua.nure.andrii.yahniukov.databinding.ActivityServiceBinding
import ua.nure.andrii.yahniukov.models.ServicesViewModel

class ServiceActivity : DrawerBaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityServiceBinding: ActivityServiceBinding =
            ActivityServiceBinding.inflate(layoutInflater)
        setContentView(activityServiceBinding.root)
        allocatedActivityTitle(resources.getString(R.string.nav_menu_services))

        val servicesRecyclerView = findViewById<RecyclerView>(R.id.servicesRecyclerView)
        servicesRecyclerView.layoutManager = LinearLayoutManager(this@ServiceActivity)

        val data = ArrayList<ServicesViewModel>()

        data.add(ServicesViewModel(1L, "Electro B-1", "Ukraine", "Kharkiv", "St. Podeda 59a"))

        val adapter = ServicesAdapter(data)

        servicesRecyclerView.adapter = adapter
    }
}