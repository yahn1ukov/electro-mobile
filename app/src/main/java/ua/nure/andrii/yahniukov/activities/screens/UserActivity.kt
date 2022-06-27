package ua.nure.andrii.yahniukov.activities.screens

import android.os.Bundle
import ua.nure.andrii.yahniukov.activities.navigation.DrawerBaseActivity
import ua.nure.andrii.yahniukov.databinding.ActivityUserBinding
import ua.nure.andrii.yahniukov.R

class UserActivity : DrawerBaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityUserBinding : ActivityUserBinding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(activityUserBinding.root)
        allocatedActivityTitle(resources.getString(R.string.nav_menu_you))
    }
}