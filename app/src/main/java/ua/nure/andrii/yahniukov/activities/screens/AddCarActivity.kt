package ua.nure.andrii.yahniukov.activities.screens

import android.os.Bundle
import ua.nure.andrii.yahniukov.activities.navigation.DrawerBaseActivity
import ua.nure.andrii.yahniukov.databinding.ActivityAddCarBinding

class AddCarActivity : DrawerBaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityAddCarBinding : ActivityAddCarBinding = ActivityAddCarBinding.inflate(layoutInflater)
        setContentView(activityAddCarBinding.root)
        allocatedActivityTitle("Add car")
    }
}