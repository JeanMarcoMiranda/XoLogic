package com.jacket.xologic.ui.game

data class GameState(
    val board: List<String?> = List(9) { null }, // Tablero de 3x3 resprensetando en una lista lineal por la posicion
    val currentPlayer: String = "X",  // Turno del jugador actual
    val winner: String? = null  // Ganador del juego (si lo hay)
)