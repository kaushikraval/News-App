package com.nytimesapp.samp.ui.activity

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.*
import com.nytimesapp.samp.R
import com.nytimesapp.samp.databinding.ActivityMainBinding
import com.nytimesapp.samp.ui.fragment.LatestArticleDetailsArgs
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // setup nav controller
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.findNavController()

        // setup app bar
        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.latestArticles, R.id.latestArticleDetails),
            binding.drawerLayout
        )
        setSupportActionBar(binding.toolbar)
        setupActionBarWithNavController(navController, appBarConfiguration)

        // setup nav controller to nav view
        binding.navView.setupWithNavController(navController)

    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    // show the options menu in app bar
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.home_menu, menu)
        return true
    }

    // menu item click listener
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (item.itemId == R.id.search) {
            // TODO: perform search operation
            true
        } else {
            item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
        }
    }

}