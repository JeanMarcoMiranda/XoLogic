package com.jacket.xologic.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun TurnIndicator(currentPlayer: String) {
    AnimatedVisibility(
        visible = true,
        enter = slideInVertically(initialOffsetY = { -50 }) + fadeIn(),
        exit = fadeOut()
    ) {
        Text(
            text = "Turno de: $currentPlayer",
            style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold),
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(16.dp)
        )
    }
}