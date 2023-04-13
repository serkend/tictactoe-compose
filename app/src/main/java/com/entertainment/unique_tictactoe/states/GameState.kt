package com.entertainment.unique_tictactoe.states

data class GameState(
    val playerCircleCount: Int = 0,
    val playerCrossCount: Int = 0,
    val drawCount: Int = 0,
    val playerState: PlayerState = PlayerState.PlayerCircleTurn
)

enum class BoardCellValue {
    Circle,
    Cross,
    None
}

enum class PlayerState {
    PlayerCircleWon,
    PlayerCrossWon,
    PlayerCircleTurn,
    PlayerCrossTurn,
    Draw
}