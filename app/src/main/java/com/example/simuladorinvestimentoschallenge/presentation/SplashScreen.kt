package com.example.simuladorinvestimentoschallenge.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.simuladorinvestimentoschallenge.R
import com.example.simuladorinvestimentoschallenge.ui.components.CustomButton
import com.example.simuladorinvestimentoschallenge.ui.theme.Black
import com.example.simuladorinvestimentoschallenge.ui.theme.PrimaryGreen
import com.example.simuladorinvestimentoschallenge.ui.theme.PrimaryGreenLight
import com.example.simuladorinvestimentoschallenge.ui.theme.SimuladorInvestimentosChallengeTheme
import com.example.simuladorinvestimentoschallenge.ui.theme.TextSecondary
import com.example.simuladorinvestimentoschallenge.ui.theme.White
import com.example.simuladorinvestimentoschallenge.ui.theme.diagonalGreenGradient

@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    onComecarClick: () -> Unit = {}
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = PrimaryGreenLight)
            .padding(
                top = 48.dp,
                bottom = 64.dp,
                start = 16.dp,
                end = 16.dp
            ),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .background(
                    brush = diagonalGreenGradient,
                    shape = RoundedCornerShape(24.dp)
                )
                .size(96.dp),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(R.drawable.baseline_savings_24),
                contentDescription = "imagem de porquinho mealheiro",
                modifier = Modifier.size(36.dp),
                tint = White
            )
        }
        Text(
            text = "Simulador de\nInvestimentos",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            lineHeight = 32.sp
        )
        Text(
            text = "Descubra quanto seus investimentos podem render com aportes mensais e juros compostos",
            fontSize = 18.sp,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(12.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = White,
                    shape = RoundedCornerShape(14.dp)
                )
                .padding(20.dp)
        ) {
            Row(
                modifier = Modifier
                    .background(color = White)
            ) {
                Box(
                    modifier = Modifier
                        .background(
                            color = PrimaryGreenLight,
                            shape = RoundedCornerShape(10.dp)
                        )
                        .size(48.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(R.drawable.icon_calculator_24),
                        contentDescription = "imagem de calculadora",
                        modifier = Modifier.size(24.dp),
                        tint = PrimaryGreen
                    )
                }
                Spacer(modifier = Modifier.width(16.dp))
                Column(
                    modifier = Modifier
                ) {
                    Text(
                        text = "Simulação Inteligente",
                        color = Black,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = "Calcule projeções precisas com juros compostos",
                        color = TextSecondary,
                        fontSize = 16.sp
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        Card(
            modifier = Modifier
                .height(210.dp)
                .background(
                    color = White,
                    shape = RoundedCornerShape(14.dp)
                )
                .padding(
                    top = 24.dp,
                    bottom = 20.dp,
                    start = 20.dp,
                    end = 20.dp
                )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .background(color = White),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Pronto para começar?",
                    color = Black,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Configure a sua simulação e descubra o potencial dos seus investimentos",
                    color = TextSecondary,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center
                )
                CustomButton(
                    onClick = { onComecarClick() },
                    text = "Começar Simulação",
                    contentDescription = "imagem de foguetão",
                    icon = R.drawable.icon_rocket,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    SimuladorInvestimentosChallengeTheme {
        SplashScreen ()
    }
}