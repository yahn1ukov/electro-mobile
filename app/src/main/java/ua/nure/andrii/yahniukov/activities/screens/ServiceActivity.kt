package ua.nure.andrii.yahniukov.activities.screens

import android.os.Bundle
import ua.nure.andrii.yahniukov.activities.navigation.DrawerBaseActivity
import ua.nure.andrii.yahniukov.databinding.ActivityServiceBinding

class ServiceActivity : DrawerBaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityServiceBinding : ActivityServiceBinding = ActivityServiceBinding.inflate(layoutInflater)
        setContentView(activityServiceBinding.root)
        allocatedActivityTitle("Services")
    }
}