package ua.nure.andrii.yahniukov.activities.navigation

import android.content.Intent
import android.content.res.Resources
import android.util.DisplayMetrics
import android.view.MenuItem
import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.navigation.NavigationView
import ua.nure.andrii.yahniukov.R
import ua.nure.andrii.yahniukov.activities.screens.AddCarActivity
import ua.nure.andrii.yahniukov.activities.screens.ChargerActivity
import ua.nure.andrii.yahniukov.activities.screens.ServiceActivity
import ua.nure.andrii.yahniukov.activities.screens.UserActivity
import java.util.*

open class DrawerBaseActivity : AppCompatActivity(),
    NavigationView.OnNavigationItemSelectedListener {

    companion object {
        var checkedItem = 0
        val listOfLanguages = arrayOf("English", "Українська")
    }

    override fun setContentView(view: View?) {
        val navigationDrawerLayout =
            layoutInflater.inflate(R.layout.activity_drawer_base, null) as DrawerLayout
        val frameLayoutContainer =
            navigationDrawerLayout.findViewById<FrameLayout>(R.id.activityConstraint)
        frameLayoutContainer.addView(view)
        super.setContentView(navigationDrawerLayout)

        val navigationToolbar: Toolbar =
            navigationDrawerLayout.findViewById(R.id.navigation_toolbar)
        setSupportActionBar(navigationToolbar)

        val navigationView: NavigationView =
            navigationDrawerLayout.findViewById(R.id.navigation_view)
        navigationView.setNavigationItemSelectedListener(this@DrawerBaseActivity)

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
        when (item.itemId) {
            R.id.screen_chargers -> {
                finish()
                startActivity(Intent(this@DrawerBaseActivity, ChargerActivity::class.java))
                overridePendingTransition(0, 0)
            }
            R.id.screen_services -> {
                finish()
                startActivity(Intent(this@DrawerBaseActivity, ServiceActivity::class.java))
                overridePendingTransition(0, 0)
            }
            R.id.screen_add_car -> {
                finish()
                startActivity(Intent(this@DrawerBaseActivity, AddCarActivity::class.java))
                overridePendingTransition(0, 0)
            }
            R.id.screen_you -> {
                finish()
                startActivity(Intent(this@DrawerBaseActivity, UserActivity::class.java))
                overridePendingTransition(0, 0)
            }
            R.id.dialog_language -> MaterialAlertDialogBuilder(this)
                .setTitle(R.string.dialog_language)
                .setSingleChoiceItems(listOfLanguages, checkedItem) { _, which ->
                    checkedItem = which
                }
                .setNeutralButton(R.string.dialog_cancel) { dialog, _ ->
                    dialog.cancel()
                }
                .setPositiveButton(R.string.dialog_accept) { _, _ ->
                    when (checkedItem) {
                        0 -> {
                            setLocal("en", item.itemId)
                            recreate()
                        }
                        1 -> {
                            setLocal("uk", item.itemId)
                            recreate()
                        }
                        else -> {
                            setLocal("en", item.itemId)
                            recreate()
                        }

                    }
                }
                .show()
            R.id.action_logout -> MaterialAlertDialogBuilder(this)
                .setTitle(R.string.nav_menu_logout)
                .setMessage(R.string.exit_msg)
                .setNeutralButton(R.string.dialog_cancel) { dialog, _ ->
                    dialog.cancel()
                }
                .setPositiveButton(R.string.dialog_accept) { _, _ ->
                    finish()
                }
                .show()
        }
        return false
    }

    protected fun allocatedActivityTitle(titleString: String) {
        supportActionBar?.title = titleString
    }

    private fun setLocal(language: String, screenId: Int) {
        val locale = Locale(language)
        Locale.setDefault(locale)
        val res: Resources = resources
        val metrics: DisplayMetrics = res.displayMetrics
        val config = res.configuration
        config.setLocale(Locale(language))
        res.updateConfiguration(config, metrics)
        onConfigurationChanged(config)
        when (screenId) {
            0 -> {
                val refresh = Intent(this@DrawerBaseActivity, ChargerActivity::class.java)
                finish()
                startActivity(refresh)
            }
            1 -> {
                val refresh = Intent(this@DrawerBaseActivity, ServiceActivity::class.java)
                finish()
                startActivity(refresh)
            }
            2 -> {
                val refresh = Intent(this@DrawerBaseActivity, AddCarActivity::class.java)
                finish()
                startActivity(refresh)
            }
            3 -> {
                val refresh = Intent(this@DrawerBaseActivity, UserActivity::class.java)
                finish()
                startActivity(refresh)
            }
        }
    }
}