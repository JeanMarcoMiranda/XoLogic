package com.jacket.xologic.domain.usecases

fun isDraw(board: List<String?>): Boolean {
    return board.all { it != null }
}