package com.example.gumtreetechtest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.gumtreetechtest.navigation.Screen
import com.example.gumtreetechtest.ui.screens.ResultsScreen
import com.example.gumtreetechtest.ui.screens.SearchScreen
import com.example.gumtreetechtest.ui.themes.GumTreeAppTheme
import com.example.gumtreetechtest.ui.viewmodels.SearchScreenViewModel


class MainActivity : ComponentActivity() {

    private val navItems = listOf(
        Screen.SearchScreen,
        Screen.ResultsScreen
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel: SearchScreenViewModel by viewModels()

        setContent {
            val navController = rememberNavController()
            GumTreeAppTheme {
                Scaffold(
                    bottomBar = {
                        BottomNavigation {
                            val navBackStackEntry by navController.currentBackStackEntryAsState()
                            val currentDestination = navBackStackEntry?.destination
                            navItems.forEach { screen ->
                                BottomNavigationItem(
                                    icon = {
                                        Icon(
                                            screen.icon,
                                            contentDescription = ""//stringResource(id = screen.contentDescription)
                                        )
                                    },
                                    label = { Text(stringResource(screen.resourceId)) },
                                    selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                                    onClick = {
                                        navController.navigate(screen.route) {
                                            popUpTo(navController.graph.findStartDestination().id) {
                                                saveState = true
                                            }
                                            launchSingleTop = true
                                            restoreState = true
                                        }
                                    }
                                )
                            }
                        }
                    }
                ) { innerPadding ->
                    NavHost(
                        navController,
                        startDestination = Screen.SearchScreen.route,
                        Modifier.padding(innerPadding)
                    ) {
                        composable(Screen.SearchScreen.route) { backStackEntry-> SearchScreen(navController, viewModel) }
                        composable(Screen.ResultsScreen.route) { ResultsScreen(navController) }
                    }

                }
            }
        }
    }
}

