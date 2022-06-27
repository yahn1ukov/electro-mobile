package ua.nure.andrii.yahniukov.activities.screens

import android.os.Bundle
import ua.nure.andrii.yahniukov.R
import ua.nure.andrii.yahniukov.activities.navigation.DrawerBaseActivity
import ua.nure.andrii.yahniukov.databinding.ActivityChargerBinding

class ChargerActivity : DrawerBaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityChargerBinding : ActivityChargerBinding = ActivityChargerBinding.inflate(layoutInflater)
        setContentView(activityChargerBinding.root)
        allocatedActivityTitle(resources.getString(R.string.nav_menu_chargers))
    }
}