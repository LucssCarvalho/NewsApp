package newsappstarter.io.carvalho.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import newsappstarter.R
import newsappstarter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navHostFragment: NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews(binding)
    }

    private fun initViews(binding: ActivityMainBinding) {
        navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        var navController = navHostFragment.navController

        navController.addOnDestinationChangedListener { _ , destination, _ ->
            title = destination.label
        }
         binding.bottomNavigation.apply {
             setupWithNavController(navController = navController)
             setOnItemReselectedListener {}
         }
    }

}