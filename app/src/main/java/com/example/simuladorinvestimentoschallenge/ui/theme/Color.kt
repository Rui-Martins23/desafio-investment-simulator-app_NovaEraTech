package com.example.simuladorinvestimentoschallenge.ui.theme

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

// Color Palette

// Primary Colors
val PrimaryGreen = Color(0xFF389A4C)
val PrimaryGreenDark = Color(0xFF276D35)
val PrimaryGreenLight = Color(0xFFE8F5E9)

val diagonalGreenGradient = Brush.linearGradient(
    colors = listOf(PrimaryGreen, PrimaryGreenDark),
    start = Offset.Zero, // Canto superior esquerdo (também daria Offset.Zero)
    end = Offset.Infinite           // Canto inferior direito (infinito dimensiona-se ao tamanho do componente)
)

// Background and Outline Colors
val BackgroundLight = Color(0xFFF8F9FA)
val SurfaceLight = Color(0xFFFFFFFF)
val OutlineLight = Color(0xFFE5E7EB)

// Typography / Texts
val TextPrimary = Color(0xFF111827)
val TextSecondary = Color(0xFF6B7280)

// Accent Colors
val AccentBlue = Color(0xFF3B82F6)
val AccentBlueContainer = Color(0xFFEFF6FF)
val AccentOrange = Color(0xFFF59E0B)
val AccentPurple = Color(0xFF833AB4)

val AccentGreen = Color(0xFF16A34A)
val AccentGreenContainer = Color(0xFFF0FDF4)

// Neutral Colors
val White = Color(0xFFFFFFFF)
val Black = Color(0xFF121212)
val DarkGray = Color(0xFF1E1E1E)
val LightGray = Color(0xFF9B9999)

// Error Color
val ErrorRed = Color(0xFFF87171)