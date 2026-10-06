package com.example.simuladorinvestimentoschallenge.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.simuladorinvestimentoschallenge.R
import com.example.simuladorinvestimentoschallenge.ui.theme.DarkGray
import com.example.simuladorinvestimentoschallenge.ui.theme.ErrorRed
import com.example.simuladorinvestimentoschallenge.ui.theme.LightGray
import com.example.simuladorinvestimentoschallenge.ui.theme.PrimaryGreen
import com.example.simuladorinvestimentoschallenge.ui.theme.SimuladorInvestimentosChallengeTheme
import com.example.simuladorinvestimentoschallenge.ui.theme.TextSecondary
import com.example.simuladorinvestimentoschallenge.ui.theme.White

@Composable
fun CustomTextField(
    valorInicial: String = "",
    title: String = "",
    icon: Int = 0,
    tint: Color = PrimaryGreen,
    placeholder: @Composable () -> Unit = { Text("R$ 0.00") },
    leadingIcon: (@Composable () -> Unit)? = null,
    trailingIcon: (@Composable () -> Unit)? = null,
    supportingText: String = "",
    contentDescription: String = "imagem de icone",
    isError: Boolean = false,
    onValueChange: (String) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.Start
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(icon),
                contentDescription = contentDescription,
                modifier = Modifier.size(18.dp),
                tint = tint
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = title,
                color = DarkGray,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        OutlinedTextField(
            value = valorInicial,
            onValueChange = { onValueChange(it) },
            // Define o tipo de teclado apenas para números decimais
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
            // Exibe a mensagem de erro por baixo do TextField
            supportingText = {
                Text(
                    text = supportingText,
                    color = if (isError) ErrorRed else TextSecondary
                )
            },
            modifier = Modifier
                .fillMaxWidth(),
            placeholder = placeholder,
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon,
            singleLine = true,
            shape = RoundedCornerShape(12.dp),
            isError = isError,
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = White,
                unfocusedContainerColor = White.copy(alpha = 0.7f),
                focusedBorderColor = LightGray.copy(alpha = 0.4f),
                unfocusedBorderColor = LightGray,
                disabledBorderColor = Color.Transparent,
                focusedLabelColor = DarkGray,
                unfocusedLabelColor = DarkGray,
                focusedPlaceholderColor = DarkGray.copy(alpha = 0.2f),
                unfocusedPlaceholderColor = DarkGray.copy(alpha = 0.5f),

                // Personalização das cores de erro
                errorContainerColor = ErrorRed.copy(alpha = 0.3f),
                errorBorderColor = ErrorRed,
                errorLabelColor = ErrorRed
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CustomTextFieldPreview() {
    SimuladorInvestimentosChallengeTheme {
        CustomTextField(
            title = "Valor inicial",
            icon = R.drawable.icon_dolar_24,
            supportingText = "Valor que já possui para investir",
            onValueChange = {}
        )
    }
}