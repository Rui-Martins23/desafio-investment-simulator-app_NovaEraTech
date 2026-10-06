package com.example.simuladorinvestimentoschallenge.presentation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.simuladorinvestimentoschallenge.presentation.model.AnoResumo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.Locale
import kotlin.math.pow

class ResultsViewModel(
    savedStateHandle: SavedStateHandle // para acessar navArguments
): ViewModel() {

    private val _valorFinalAcumulado = MutableStateFlow("")
    var valorFinalAcumulado = _valorFinalAcumulado.asStateFlow()

    private val _totalInvestido = MutableStateFlow("")
    var totalInvestido = _totalInvestido.asStateFlow()

    private val _lucroObtido = MutableStateFlow("")
    var lucroObtido = _lucroObtido.asStateFlow()

    private val _anosDeInvestimento = MutableStateFlow("")
    var anosDeInvestimento = _anosDeInvestimento.asStateFlow()

    private val _resumoPorAno = MutableStateFlow<List<AnoResumo>>(emptyList())
    val resumoPorAno = _resumoPorAno.asStateFlow()


    // VALORES passados da tela 2 para a 3, através do savedStateHandle
    private val valorInicialStr: String = checkNotNull(savedStateHandle["valorInicial"])
    private val aportePorMesStr: String = checkNotNull(savedStateHandle["aporteMensal"])
    private val taxasJuroStr: String = checkNotNull(savedStateHandle["taxasDeJuro"])
    private val tempoInvestimentoStr: String = checkNotNull(savedStateHandle["tempoDeInvestimento"])


    // CONVERSÃO para Double para efetuar os cálculos
    private val valorInicial = valorInicialStr.toDoubleOrNull() ?: 0.0
    private val aportePorMes = aportePorMesStr.toDoubleOrNull() ?: 0.0
    private val taxasJuro = (taxasJuroStr.toDoubleOrNull() ?: 0.0) / 100.0
    private val tempoInvestimentoEmAnos = tempoInvestimentoStr.toDoubleOrNull() ?: 0.0

    // Auxiliares de cálculo
    private val totalMeses = (tempoInvestimentoEmAnos * 12).toInt()
    private val totalAnos = tempoInvestimentoEmAnos.toInt()

    // Para formatação de resultados a apresentar
    val symbols = DecimalFormatSymbols(Locale("pt", "BR")).apply {
        decimalSeparator = ','
        groupingSeparator = '.'
    }

    val decimalFormat = DecimalFormat("#,##0.00", symbols)

    init {
        calcularValorFinalAcumulado()
        setAnosDeInvestimento()
        calcularTotalInvestido()
        calcularLucroObtido()
        gerarResumoPorAno()
    }

    fun calcularValorFinalAcumulado() {
        var montante = valorInicial

        for (ano in 1..totalAnos) {
            montante = (montante + aportePorMes * 12) * (1.0 + taxasJuro)
        }

        _valorFinalAcumulado.value = decimalFormat.format(montante)
    }

    private fun setAnosDeInvestimento() {
        _anosDeInvestimento.value = tempoInvestimentoStr
    }

    fun calcularTotalInvestido() {
        val totalInvestido = valorInicial + (aportePorMes * totalMeses)

        _totalInvestido.value = decimalFormat.format(totalInvestido)
    }

    fun calcularLucroObtido() {
        var montante = valorInicial
        for (ano in 1..totalAnos) {
            montante = (montante + aportePorMes * 12) * (1.0 + taxasJuro)
        }

        val totalInvestido = valorInicial + (aportePorMes * totalMeses)

        val lucro = montante - totalInvestido

        _lucroObtido.value = decimalFormat.format(lucro)
    }

    private fun gerarResumoPorAno() {
        val listaResumo = mutableListOf<AnoResumo>()

        var montante = valorInicial

        for (ano in 1..totalAnos){
            montante = (montante + aportePorMes * 12) * (1.0 + taxasJuro)

            listaResumo.add(
                AnoResumo(
                    ano = ano,
                    valorAcumuladoFormatado = "R$ ${decimalFormat.format(montante)}"
                )
            )
        }

        _resumoPorAno.value = listaResumo
    }
}