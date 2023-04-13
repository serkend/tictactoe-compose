package com.entertainment.unique_tictactoe.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.entertainment.unique_tictactoe.states.BoardCellValue
import com.entertainment.unique_tictactoe.states.GameState
import com.entertainment.unique_tictactoe.states.PlayerState
import com.entertainment.unique_tictactoe.features.UserAction
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class GameViewModel : ViewModel() {

    var gameState by mutableStateOf(GameState())
        private set

    private var _boardMap: MutableMap<Int, BoardCellValue> = createBoardMap()

    val boardMap: Map<Int, BoardCellValue>
        get() = _boardMap

    private val _showDialog = MutableStateFlow(true)
    val showDialog = _showDialog.asStateFlow()

    fun onDialogDismiss() {
        _showDialog.value = false
    }

    fun onAction(action: UserAction) {
        when (action) {
            UserAction.PlayAgainButtonClicked -> {
                resetState()
            }
            is UserAction.BoardTapped -> {
                addValueToBoard(action.cellNo)
            }
        }
    }

    private fun addValueToBoard(cellNo: Int) {
        if (_boardMap[cellNo] != BoardCellValue.None) {
            return
        }
        if (gameState.playerState == PlayerState.PlayerCircleTurn) {
            _boardMap[cellNo] = BoardCellValue.Circle

            _boardMap[cellNo]?.let {
                gameState = if (checkForVictory(it)) {
                    gameState.copy(
                        playerState = PlayerState.PlayerCircleWon,
                        playerCircleCount = gameState.playerCircleCount + 1
                    )
                } else if (isBoardFull()) {
                    gameState.copy(
                        playerState = PlayerState.Draw,
                        drawCount = gameState.drawCount + 1
                    )
                } else {
                    gameState.copy(
                        playerState = PlayerState.PlayerCrossTurn,
                    )
                }
            }

        } else if (gameState.playerState == PlayerState.PlayerCrossTurn) {
            _boardMap[cellNo] = BoardCellValue.Cross

            _boardMap[cellNo]?.let {
                if (checkForVictory(it)) {
                    gameState = gameState.copy(
                        playerState = PlayerState.PlayerCrossWon,
                        playerCrossCount = gameState.playerCrossCount + 1
                    )
                } else if (isBoardFull()) {
                    gameState = gameState.copy(
                        playerState = PlayerState.Draw,
                        drawCount = gameState.drawCount + 1
                    )
                } else {
                    gameState = gameState.copy(
                        playerState = PlayerState.PlayerCircleTurn,
                    )
                }
            }
        }
    }

    private fun createBoardMap(): MutableMap<Int, BoardCellValue> {
        return mutableMapOf(
            1 to BoardCellValue.None,
            2 to BoardCellValue.None,
            3 to BoardCellValue.None,
            4 to BoardCellValue.None,
            5 to BoardCellValue.None,
            6 to BoardCellValue.None,
            7 to BoardCellValue.None,
            8 to BoardCellValue.None,
            9 to BoardCellValue.None,
        )
    }

    private fun checkForVictory(cellValue: BoardCellValue): Boolean {
        when {
            _boardMap[1] == cellValue && _boardMap[2] == cellValue && _boardMap[3] == cellValue -> {
                return true
            }
            _boardMap[4] == cellValue && _boardMap[5] == cellValue && _boardMap[6] == cellValue -> {
                return true
            }
            _boardMap[7] == cellValue && _boardMap[8] == cellValue && _boardMap[9] == cellValue -> {
                return true
            }
            _boardMap[1] == cellValue && _boardMap[4] == cellValue && _boardMap[7] == cellValue -> {
                return true
            }
            _boardMap[2] == cellValue && _boardMap[5] == cellValue && _boardMap[8] == cellValue -> {
                return true
            }
            _boardMap[3] == cellValue && _boardMap[6] == cellValue && _boardMap[9] == cellValue -> {
                return true
            }
            _boardMap[1] == cellValue && _boardMap[5] == cellValue && _boardMap[9] == cellValue -> {
                return true
            }
            _boardMap[3] == cellValue && _boardMap[5] == cellValue && _boardMap[7] == cellValue -> {
                return true
            }
            else -> return false
        }
    }

    private fun isBoardFull(): Boolean {
        if (_boardMap.containsValue(BoardCellValue.None)) {
            return false
        }
        return true
    }

    private fun resetState() {
        gameState = gameState.copy(
            playerState = if (gameState.playerState == PlayerState.PlayerCircleTurn) {
                PlayerState.PlayerCrossTurn
            } else {
                PlayerState.PlayerCircleTurn
            }
        )
        _boardMap = createBoardMap()
        _showDialog.value = true
    }
}