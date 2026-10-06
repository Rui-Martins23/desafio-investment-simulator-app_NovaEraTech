package com.example.simuladorinvestimentoschallenge.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.simuladorinvestimentoschallenge.R
import com.example.simuladorinvestimentoschallenge.ui.theme.SimuladorInvestimentosChallengeTheme
import com.example.simuladorinvestimentoschallenge.ui.theme.White
import com.example.simuladorinvestimentoschallenge.ui.theme.diagonalGreenGradient

@Composable
fun CustomButton(
    modifier: Modifier = Modifier,
    text: String = "Example text",
    icon: Int = 0,
    contentDescription: String = "icon image",
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(
                brush = diagonalGreenGradient,
                shape = RoundedCornerShape(12.dp)
            ),
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            contentColor = White
        )
    ) {
        Icon(
            painter = painterResource(icon),
            contentDescription = contentDescription,
            modifier = Modifier
                .size(18.dp),
            tint = White
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = text,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CustomButtonPreview() {
    SimuladorInvestimentosChallengeTheme {
        CustomButton(
            icon = R.drawable.icon_calculator_24,
            onClick = {}
        )
    }
}