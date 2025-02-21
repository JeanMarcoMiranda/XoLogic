package com.jacket.xologic.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jacket.xologic.domain.usecases.checkWinner
import com.jacket.xologic.domain.usecases.isDraw
import com.jacket.xologic.ui.game.GameState

@Composable
fun Board() {
    var gameState by remember { mutableStateOf(GameState()) }
    var winner by remember { mutableStateOf<String?>(null) }
    var showDialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Show whos player is the turn if there is not a winner yet
        if (winner == null) {
            TurnIndicator(
                currentPlayer = gameState.currentPlayer
            )
        }


        // Display a 3x3 grid
        for (row in 0 until 3) {
            Row {
                for (col in 0 until 3) {
                    val index = row * 3 + col
                    val cellSymbol = gameState.board[index]

                    BoardCell(symbol = cellSymbol.orEmpty(), onClick = {
                        if (gameState.board[index] == null && winner == null) { // Should not allow to play if there is a winner
                            gameState = gameState.copy(
                                board = gameState.board.toMutableList().apply {
                                    set(index, gameState.currentPlayer)
                                },
                                currentPlayer = if (gameState.currentPlayer == "X") "O" else "X"
                            )

                            // Check if there is a winner
                            checkWinner(gameState.board)?.let {
                                winner = it
                                showDialog = true
                            } ?: run {
                                if (isDraw(gameState.board)) {
                                    winner = "Empate"
                                    showDialog = true
                                }
                            }
                        }
                    })
                }
            }
        }

        // Show dialog with the result of the game if there is a winner or it is draw
        if (showDialog) {
            ResultDialog(
                winner = winner,
                onDismiss = {
                    gameState = GameState()
                    winner = null
                    showDialog = false
                }
            )
        }
    }
}

@Preview(
    name = "Tablero en Modo Claro",
    showBackground = true,
    backgroundColor = 0xFFFFFFFF,
    widthDp = 400,
    heightDp = 400,
    showSystemUi = false
)
@Composable
fun PreviewTicTacToeBoard() {
    Board()
}
