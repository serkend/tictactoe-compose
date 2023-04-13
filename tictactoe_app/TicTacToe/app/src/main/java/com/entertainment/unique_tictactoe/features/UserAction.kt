package com.entertainment.unique_tictactoe.features

sealed class UserAction {
    object PlayAgainButtonClicked : UserAction()
    data class BoardTapped(val cellNo : Int) : UserAction()
}