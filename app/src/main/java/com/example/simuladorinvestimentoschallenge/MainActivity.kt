package com.example.simuladorinvestimentoschallenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.simuladorinvestimentoschallenge.presentation.ResultsScreen
import com.example.simuladorinvestimentoschallenge.presentation.SimulationScreen
import com.example.simuladorinvestimentoschallenge.presentation.SplashScreen
import com.example.simuladorinvestimentoschallenge.presentation.ResultsViewModel
import com.example.simuladorinvestimentoschallenge.ui.Screen
import com.example.simuladorinvestimentoschallenge.ui.theme.SimuladorInvestimentosChallengeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SimuladorInvestimentosChallengeTheme {
                AppNavigation()
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        // Tela 1 - Boas Vindas
        composable(Screen.Splash.route) {
            SplashScreen(
                onComecarClick = { navController.navigate(Screen.Simulation.route) }
            )
        }

        // Tela 2 - Cálculo da Simulação
        composable(Screen.Simulation.route) {
            SimulationScreen(
                onCalcularClick = { valorInicial, aporteMensal, taxasDeJuro, tempoDeInvestimento ->
                    navController.navigate(Screen.Results.createRoute(valorInicial, aporteMensal, taxasDeJuro, tempoDeInvestimento))
                }
            )
        }

        // Tela 3 - Resultados da Simulação
        composable(
            route = Screen.Results.route,
            arguments = listOf(
                navArgument("valorInicial") { type = NavType.StringType },
                navArgument("aporteMensal") { type = NavType.StringType },
                navArgument("taxasDeJuro") { type = NavType.StringType },
                navArgument("tempoDeInvestimento") { type = NavType.StringType }
            )
        ) {
            val viewModel: ResultsViewModel = viewModel()

            ResultsScreen(
                viewModel = viewModel,
                onBackClick = { navController.popBackStack()}
            )
        }
    }
}