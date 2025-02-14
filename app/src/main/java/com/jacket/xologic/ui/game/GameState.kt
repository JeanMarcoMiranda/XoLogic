package com.jacket.xologic.ui.game

data class GameState(
    val board: List<List<String?>> = List(3) { List(3) { null } },  // Tablero vacío
    val currentPlayer: String = "X",  // Turno del jugador actual
    val winner: String? = null  // Ganador del juego (si lo hay)
)