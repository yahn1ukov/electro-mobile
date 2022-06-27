package ua.nure.andrii.yahniukov.activities.navigation

import android.content.Intent
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.navigation.NavigationView
import ua.nure.andrii.yahniukov.R
import ua.nure.andrii.yahniukov.activities.screens.AddCarActivity
import ua.nure.andrii.yahniukov.activities.screens.ChargerActivity
import ua.nure.andrii.yahniukov.activities.screens.ServiceActivity
import ua.nure.andrii.yahniukov.activities.screens.UserActivity

open class DrawerBaseActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun setContentView(view: View?) {
        val navigationDrawerLayout = layoutInflater.inflate(R.layout.activity_drawer_base, null) as DrawerLayout
        val frameLayoutContainer = navigationDrawerLayout.findViewById<FrameLayout>(R.id.activityConstraint)
        frameLayoutContainer.addView(view)
        super.setContentView(navigationDrawerLayout)

        val navigationToolbar : Toolbar = navigationDrawerLayout.findViewById(R.id.navigation_toolbar)
        setSupportActionBar(navigationToolbar)

        val navigationView : NavigationView = navigationDrawerLayout.findViewById(R.id.navigation_view)
        navigationView.setNavigationItemSelectedListener(this)

        val actionBarDrawerToggle = ActionBarDrawerToggle(
            this,
            navigationDrawerLayout,
            navigationToolbar,
            R.string.nav_menu_open,
            R.string.nav_menu_close
        )

        actionBarDrawerToggle.syncState()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.screen_chargers -> {
                startActivity(Intent(this, ChargerActivity::class.java))
                overridePendingTransition(0, 0)
            }
            R.id.screen_services -> {
                finish()
                startActivity(Intent(this, ServiceActivity::class.java))
                overridePendingTransition(0, 0)
            }
            R.id.screen_add_car -> {
                finish()
                startActivity(Intent(this, AddCarActivity::class.java))
                overridePendingTransition(0, 0)
            }
            R.id.screen_you -> {
                finish()
                startActivity(Intent(this, UserActivity::class.java))
                overridePendingTransition(0, 0)
            }
            R.id.action_logout -> MaterialAlertDialogBuilder(this)
                .setTitle(R.string.nav_menu_logout)
                .setMessage(R.string.exit_msg)
                .setNeutralButton(resources.getString(R.string.dialog_cancel)) { dialog, _ ->
                    dialog.cancel()
                }
                .setNegativeButton(resources.getString(R.string.dialog_decline)) { dialog, _ ->
                    dialog.dismiss()
                }
                .setPositiveButton(resources.getString(R.string.dialog_accept)) { _, _ ->
                    finish()
                }
                .show()
        }
        return false
    }

    protected fun allocatedActivityTitle(titleString : String) {
        supportActionBar?.title = titleString
    }
}