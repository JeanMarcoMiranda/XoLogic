package com.jacket.xologic.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Board(
    board: List<List<String>>,
    onCellClick: (row: Int, col: Int) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f)
            .padding(16.dp)
    ) {
        board.forEachIndexed { rowIndex, row ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                row.forEachIndexed { colIndex, cell ->
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .size(100.dp)
                            .border(2.dp, Color.Gray, RectangleShape)
                            .clickable { onCellClick(rowIndex, colIndex) }
                            .background(MaterialTheme.colorScheme.surface)
                    ) {
                        Text(
                            text = cell,
                            style = MaterialTheme.typography.headlineLarge,
                            color = if (cell == "X") Color.Red else if (cell == "O") Color.Blue else Color.Black
                        )
                    }
                }
            }
        }
    }
}

//@Preview(
//    name = "Tablero en Modo Claro",
//    showBackground = true,
//    backgroundColor = 0xFFFFFFFF,
//    widthDp = 300,
//    heightDp = 300,
//    showSystemUi = false
//)
@Preview(device = Devices.PIXEL_2)
@Composable
fun PreviewTicTacToeBoard() {
    val sampleBoard = listOf(
        listOf("X", "O", ""),
        listOf("", "X", "O"),
        listOf("O", "", "X")
    )

    Board(
        board = sampleBoard,
        onCellClick = { _, _ -> }
    )
}
