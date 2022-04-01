package ru.diazzerss.basearchitectureexample.presentation

import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import ru.diazzerss.basearchitectureexample.R
import ru.diazzerss.example1.presentation.view.NavActions
import ru.diazzerss.presentation.base.BaseActivity
import ru.diazzerss.presentation.navigation.UiAction

class MainActivity : BaseActivity() {
    override val layoutId: Int = R.layout.activity_main
    override fun getNavController() = findNavController(R.id.navHostFragment)

    override fun onActivityCreated() {
        val bottomNavigation: BottomNavigationView = findViewById(R.id.navigationView)
        NavigationUI.setupWithNavController(bottomNavigation, navigator)
    }

    override fun navigateTo(action: UiAction) {
        when(action.id) {
            NavActions.OPEN_EXAMPLE_2 -> { navigator.navigate(R.id.example2) }
        }
    }
}
