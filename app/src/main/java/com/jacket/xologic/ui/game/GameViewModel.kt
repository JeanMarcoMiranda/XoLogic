package com.jacket.xologic.ui.game

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class GameViewModel: ViewModel() {
    // Representa el estado del tablero de 3x3 con valores nulos al inicio
    private val _uiState = MutableStateFlow(GameState())
    val uiState: StateFlow<GameState> = _uiState

    fun onCellClicked(row: Int, col: Int) {
        // TODO: Implementar lógica de juego
    }
}