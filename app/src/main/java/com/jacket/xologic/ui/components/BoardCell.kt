package com.jacket.xologic.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun BoardCell(
    symbol: String?,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .size(100.dp)
            .border(2.dp, Color.Black)
            .clickable(
                enabled = symbol == null,
                onClick = onClick
            ),
        contentAlignment = Alignment.Center
    ) {
        symbol?.let {
            Text(
                text = it,
                style = MaterialTheme.typography.headlineLarge,
                color = if (it == "X") Color.Red else Color.Blue
            )
        }
    }
}