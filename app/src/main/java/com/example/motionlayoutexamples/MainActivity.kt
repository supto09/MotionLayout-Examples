package com.example.motionlayoutexamples

import android.graphics.Color
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.Navigation
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navController = Navigation.findNavController(this, R.id.nav_host_fragment)


        // region remove the toolbar title and set as actionbar
        toolBar.title = ""
        setSupportActionBar(toolBar)
        // endregion

        // region handle navigation from drawer layout
        navigationView.setNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.parallaxFragment -> navController.navigate(R.id.parallaxFragment)
                else -> navController.navigate(R.id.circularStepFragment)

            }

            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }
        // endregion

        // region customize the drawer layout for synced hamburger icon
        // and listen the drawer slide value for motion animation
        drawerLayout.setScrimColor(Color.TRANSPARENT)
        drawerLayout.addDrawerListener(
            object : DrawerLayout.DrawerListener {
                override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
                    motionLayout.progress = slideOffset
                }

                override fun onDrawerOpened(drawerView: View) {
                    //Called when a drawer has settled in a completely open state.
                    //The drawer is interactive at this point.
                    // If you have 2 drawers (left and right) you can distinguish
                    // them by using id of the drawerView. int id = drawerView.getId();
                    // id will be your layout's id: for example R.id.left_drawer
                }

                override fun onDrawerClosed(drawerView: View) {
                    // Called when a drawer has settled in a completely closed state.
                }

                override fun onDrawerStateChanged(newState: Int) {
                    // Called when the drawer motion state changes. The new state will be one of STATE_IDLE, STATE_DRAGGING or STATE_SETTLING.
                }
            })

        var toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolBar,
            R.string.drawer_open,
            R.string.drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        // endregion


    }
}
