package com.example.simuladorinvestimentoschallenge.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.simuladorinvestimentoschallenge.R
import com.example.simuladorinvestimentoschallenge.ui.theme.AccentBlue
import com.example.simuladorinvestimentoschallenge.ui.theme.Black
import com.example.simuladorinvestimentoschallenge.ui.theme.OutlineLight
import com.example.simuladorinvestimentoschallenge.ui.theme.PrimaryGreen
import com.example.simuladorinvestimentoschallenge.ui.theme.PrimaryGreenDark
import com.example.simuladorinvestimentoschallenge.ui.theme.PrimaryGreenLight
import com.example.simuladorinvestimentoschallenge.ui.theme.SimuladorInvestimentosChallengeTheme
import com.example.simuladorinvestimentoschallenge.ui.theme.TextSecondary
import com.example.simuladorinvestimentoschallenge.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResultsScreen(
    viewModel: ResultsViewModel,
    onBackClick: () -> Unit = {}
) {
    val valorFinalAcumulado = viewModel.valorFinalAcumulado.collectAsStateWithLifecycle()
    val totalInvestido = viewModel.totalInvestido.collectAsStateWithLifecycle()
    val lucroObtido = viewModel.lucroObtido.collectAsStateWithLifecycle()
    val anosDeInvestimento = viewModel.anosDeInvestimento.collectAsStateWithLifecycle()
    val resumoAnual = viewModel.resumoPorAno.collectAsStateWithLifecycle()

    Scaffold(
        containerColor = PrimaryGreenLight,
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Icon em Box de background verde
                        Box(
                            modifier = Modifier
                                .size(32.dp)
                                .background(
                                    color = PrimaryGreen,
                                    shape = RoundedCornerShape(8.dp)
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.icon_percent_24),
                                contentDescription = "Ícone de resultado",
                                modifier = Modifier.size(18.dp),
                                tint = White
                            )
                        }

                        Spacer(modifier = Modifier.width(12.dp))

                        // Título da Barra Superior
                        Text(
                            text = "Resultado da Simulação",
                            color = Black,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                },
                navigationIcon = {
                    IconButton(
                        onClick = onBackClick,
                        modifier = Modifier.padding(horizontal = 4.dp)
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.icon_arrow_back_24),
                            contentDescription = "Voltar",
                            tint = Black
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = White
                )
            )
        }
    ) { innerPadding ->
        // Conteúdo principal da tela
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .padding(16.dp, 24.dp)
        ) {
            // Card Principal
            Card(
                modifier = Modifier
                    .fillMaxWidth(),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 6.dp,
                    hoveredElevation = 4.dp,
                    pressedElevation = 2.dp
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(White)
                        .height(190.dp)
                        .padding(20.dp),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        painter = painterResource(R.drawable.icon_trophy_24),
                        contentDescription = "imagem de troféu",
                        modifier = Modifier.size(40.dp),
                        tint = PrimaryGreenDark
                    )
                    Text(
                        text = "Valor final acumulado",
                        color = TextSecondary,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "R$ ${valorFinalAcumulado.value}",
                        color = Black,
                        fontSize = 36.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "após ${anosDeInvestimento.value} anos de investimento",
                        color = TextSecondary,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // Primeiro Card Secundário
                Card(
                    modifier = Modifier
                        .weight(1f),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 6.dp,
                        hoveredElevation = 4.dp,
                        pressedElevation = 2.dp
                    )
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(White)
                            .height(140.dp)
                            .padding(18.dp),
                        verticalArrangement = Arrangement.SpaceBetween,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Box(
                            modifier = Modifier
                                .background(
                                    color = AccentBlue.copy(alpha = 0.3f),
                                    shape = RoundedCornerShape(10.dp)
                                )
                                .size(42.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.baseline_savings_24),
                                contentDescription = "imagem de troféu",
                                modifier = Modifier.size(20.dp),
                                tint = AccentBlue
                            )
                        }
                        Text(
                            text = "Total investido",
                            color = TextSecondary,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "R$ ${totalInvestido.value}",
                            color = Black,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                Spacer(modifier = Modifier.width(16.dp))

                // Segundo Card Secundário
                Card(
                    modifier = Modifier
                        .weight(1f),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 6.dp,
                        hoveredElevation = 4.dp,
                        pressedElevation = 2.dp
                    )
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(White)
                            .height(140.dp)
                            .padding(18.dp),
                        verticalArrangement = Arrangement.SpaceBetween,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Box(
                            modifier = Modifier
                                .background(
                                    color = PrimaryGreenLight,
                                    shape = RoundedCornerShape(10.dp)
                                )
                                .size(42.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.icon_chart_line_24),
                                contentDescription = "imagem de troféu",
                                modifier = Modifier.size(20.dp),
                                tint = PrimaryGreen
                            )
                        }
                        Text(
                            text = "Lucro obtido",
                            color = TextSecondary,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "R$ ${lucroObtido.value}",
                            color = PrimaryGreen,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Card de Resumo por Ano
            Card(modifier = Modifier.fillMaxWidth()) {
                Column(
                    modifier = Modifier
                        .background(White)
                        .padding(16.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(White),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.icon_format_list_bulleted_24),
                            contentDescription = "imagem de bullets poins",
                            modifier = Modifier.size(18.dp),
                            tint = PrimaryGreen
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "Resumo por Ano",
                            color = Black,
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp
                        )
                    }
                    Spacer(modifier = Modifier.height(12.dp))

                    // forEach loop para renderizar resultados a cada ano de investimento
                    resumoAnual.value.forEach { item ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 12.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Ano ${item.ano}",
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = item.valorAcumuladoFormatado,
                                color = Black,
                                fontWeight = FontWeight.Bold
                            )
                        }
                        HorizontalDivider(thickness = 1.dp, color = OutlineLight)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ResultsScreenPreview() {
    SimuladorInvestimentosChallengeTheme {
        ResultsScreen(
            viewModel = viewModel(),
            onBackClick = {}
        )
    }
}