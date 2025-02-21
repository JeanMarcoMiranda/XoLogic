package com.jacket.xologic.ui.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.animation.with
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun BoardCell(
    symbol: String = "", // Valor por defecto vacío
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .size(100.dp)
            .background(MaterialTheme.colorScheme.surfaceVariant, RoundedCornerShape(8.dp))
            .clickable(enabled = symbol.isEmpty()) { onClick() } // Solo permite clics en celdas vacías
    ) {
        AnimatedContent(
            targetState = symbol,
            transitionSpec = {
                fadeIn(animationSpec = tween(300)) togetherWith  fadeOut(animationSpec = tween(300))
            }
        ) { targetSymbol ->
            if (targetSymbol.isNotEmpty()) { // Evita mostrar "nada" cuando está vacío
                Text(
                    text = targetSymbol,
                    style = MaterialTheme.typography.displayMedium.copy(fontWeight = FontWeight.Bold),
                    color = if (targetSymbol == "X") Color.Red else Color.Blue,
                    modifier = Modifier.scale(1.2f) // Pequeño efecto de escala al aparecer
                )
            }
        }
    }
}