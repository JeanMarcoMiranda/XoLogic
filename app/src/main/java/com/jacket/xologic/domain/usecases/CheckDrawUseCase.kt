package com.jacket.xologic.domain.usecases

fun checkWinner(board: List<String?>): String? {
    val winningCombinations = listOf(
        listOf(0, 1, 2), listOf(3, 4, 5), listOf(6, 7, 8), // Filas
        listOf(0, 3, 6), listOf(1, 4, 7), listOf(2, 5, 8), // Columnas
        listOf(0, 4, 8), listOf(2, 4, 6)  // Diagonales
    )

    for (combination in winningCombinations) {
        val (a, b, c) = combination

        if (board[a] != null && board[a] == board[b] && board[a] == board[c]) {
            return board[a]
        }
    }

    return null
}