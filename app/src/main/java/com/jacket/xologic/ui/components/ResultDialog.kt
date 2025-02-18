package com.jacket.xologic.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ResultDialog(winner: String?, onDismiss: () -> Unit) {
    AlertDialog(
        onDismissRequest = { onDismiss() },
        title = {
            Text(
                text = if (winner == "Empate") "!Es un empate!" else "!Ganador: $winner!",
                style = MaterialTheme.typography.headlineMedium
            )
        },
        confirmButton = {
            Button(onClick = { onDismiss() }) {
                Text("Reiniciar")
            }
        },
        modifier = Modifier.padding(16.dp)
    )
}