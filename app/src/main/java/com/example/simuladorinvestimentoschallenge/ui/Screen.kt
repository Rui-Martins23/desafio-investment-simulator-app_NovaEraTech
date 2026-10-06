package com.example.simuladorinvestimentoschallenge.ui

sealed class Screen(val route: String) {
    object Splash: Screen("splash_screen")
    object Simulation: Screen("simulation_screen")
    object Results: Screen("results_screen/{valorInicial}/{aporteMensal}/{taxasDeJuro}/{tempoDeInvestimento}") {
        // Função para construir a rota passando o parâmetro
        fun createRoute(valorInicial: String, aporteMensal: String, taxasDeJuro: String, tempoDeInvestimento: String): String {
            return "results_screen/$valorInicial/$aporteMensal/$taxasDeJuro/$tempoDeInvestimento"
        }
    }
}