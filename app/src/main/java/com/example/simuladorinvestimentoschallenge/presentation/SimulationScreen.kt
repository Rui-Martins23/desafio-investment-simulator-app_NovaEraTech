package com.example.simuladorinvestimentoschallenge.presentation

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.simuladorinvestimentoschallenge.R
import com.example.simuladorinvestimentoschallenge.ui.components.CustomButton
import com.example.simuladorinvestimentoschallenge.ui.components.CustomTextField
import com.example.simuladorinvestimentoschallenge.ui.theme.AccentBlue
import com.example.simuladorinvestimentoschallenge.ui.theme.AccentOrange
import com.example.simuladorinvestimentoschallenge.ui.theme.AccentPurple
import com.example.simuladorinvestimentoschallenge.ui.theme.Black
import com.example.simuladorinvestimentoschallenge.ui.theme.DarkGray
import com.example.simuladorinvestimentoschallenge.ui.theme.PrimaryGreen
import com.example.simuladorinvestimentoschallenge.ui.theme.PrimaryGreenLight
import com.example.simuladorinvestimentoschallenge.ui.theme.SimuladorInvestimentosChallengeTheme
import com.example.simuladorinvestimentoschallenge.ui.theme.TextSecondary

@Composable
fun SimulationScreen(
    modifier: Modifier = Modifier,
    onCalcularClick: (String, String, String, String) -> Unit
) {
    val context = LocalContext.current

    var valorInicial by remember { mutableStateOf("") }
    var aporteMensal by remember { mutableStateOf("") }
    var taxasDeJuro by remember { mutableStateOf("") }
    var tempoDeInvestimento by remember { mutableStateOf("") }

    // Estados de erro para controle de text fields vazios
    var isValorInicialError by remember { mutableStateOf(false) }
    var isAporteMensalError by remember { mutableStateOf(false) }
    var isTaxasDeJuroError by remember { mutableStateOf(false) }
    var isTempoError by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(PrimaryGreenLight)
            .padding(
                horizontal = 16.dp,
                vertical = 32.dp
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Configure a sua Simulação",
            color = Black,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Preencha os dados para calcular a sua projeção",
            color = TextSecondary,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(28.dp))

        Column(
            modifier = Modifier
                .height(475.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            CustomTextField(
                valorInicial = valorInicial,
                title = "Valor Inicial",
                icon = R.drawable.icon_dolar_24,
                tint = PrimaryGreen,
                leadingIcon = { Text(
                    text = "R$",
                    color = DarkGray.copy(alpha = 0.7f),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )},
                supportingText = "Valor que já possui para investir",
                isError = isValorInicialError,
                onValueChange = { userInput ->
                    // Valida a entrada: aceita apenas números e até um ponto decimal
                    if (userInput.isEmpty() || userInput.matches(Regex("^\\d*\\.?\\d{0,2}$"))) {
                        valorInicial = userInput
                        isValorInicialError = false // Limpa o estado de erro ao escrever
                    }
                }
            )
            CustomTextField(
                valorInicial = aporteMensal,
                title = "Aporte Mensal",
                icon = R.drawable.icon_calendar_24,
                tint = AccentBlue,
                leadingIcon = { Text(
                    text = "R$",
                    color = DarkGray.copy(alpha = 0.7f),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )},
                supportingText = "Valor que você investirá todo o mês",
                isError = isAporteMensalError,
                onValueChange = { userInput ->
                    // Valida a entrada: aceita apenas números e até um ponto decimal
                    if (userInput.isEmpty() || userInput.matches(Regex("^\\d*\\.?\\d{0,2}$"))) {
                        aporteMensal = userInput
                        isAporteMensalError = false
                    }
                }
            )
            CustomTextField(
                valorInicial = taxasDeJuro,
                title = "Taxas de juro (% ao ano)",
                icon = R.drawable.icon_percent_24,
                tint = AccentOrange,
                placeholder = { Text("12.00")},
                trailingIcon = { Text("%")},
                supportingText = "Taxa anual esperada (ex: CDI, Tesouro Direto)",
                isError = isTaxasDeJuroError,
                onValueChange = { userInput ->
                    // Valida a entrada: aceita apenas números e até um ponto decimal
                    if (userInput.isEmpty() || userInput.matches(Regex("^\\d*\\.?\\d{0,2}$"))) {
                        taxasDeJuro = userInput
                        isTaxasDeJuroError = false
                    }
                }
            )
            CustomTextField(
                valorInicial = tempoDeInvestimento,
                title = "Tempo (anos)",
                icon = R.drawable.icon_clock_analog_24,
                tint = AccentPurple,
                placeholder = { Text("5")},
                trailingIcon = { Text(
                    text = "anos",
                    modifier = Modifier.padding(end = 12.dp)
                )},
                supportingText = "Por quanto tempo você quer investir",
                isError = isTempoError,
                onValueChange = { userInput ->
                    // Valida a entrada: aceita apenas números e até um ponto decimal
                    if (userInput.isEmpty() || userInput.matches(Regex("^\\d*$"))) {
                        tempoDeInvestimento = userInput
                        isTempoError = false
                    }
                }
            )
        }

        Spacer(modifier = Modifier.height(56.dp))
        CustomButton(
            onClick = {
                isValorInicialError = valorInicial.isBlank()
                isAporteMensalError = aporteMensal.isBlank()
                isTaxasDeJuroError = taxasDeJuro.isBlank()
                isTempoError = tempoDeInvestimento.isBlank()

                val temCamposEmFalta = isValorInicialError || isAporteMensalError || isTaxasDeJuroError || isTempoError

                if (temCamposEmFalta) {
                    // Mostra o Toast e não avança com a navegação
                    Toast.makeText(context, "Obrigatório preencher todos os campos", Toast.LENGTH_SHORT).show()
                } else {
                    // Se estiver tudo preenchido, avança para a tela de resultados
                    onCalcularClick(valorInicial, aporteMensal, taxasDeJuro, tempoDeInvestimento)
                }
            },
            text = "Calcular Investimento",
            contentDescription = "imagem de calculadora",
            icon = R.drawable.icon_calculator_24,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SimulationScreenPreview() {
    SimuladorInvestimentosChallengeTheme {
        SimulationScreen(
            onCalcularClick = { valor, aporte, taxa, tempo -> }
        )
    }
}