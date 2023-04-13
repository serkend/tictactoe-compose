package com.entertainment.unique_tictactoe.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.lifecycle.viewmodel.compose.viewModel
import com.entertainment.unique_tictactoe.screens.GameScreen
import com.entertainment.unique_tictactoe.ui.theme.TicTacToeTheme
import com.entertainment.unique_tictactoe.viewmodels.GameViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TicTacToeTheme() {
                Surface(color = MaterialTheme.colors.background) {
                    val viewModel = viewModel<GameViewModel>()
                    GameScreen(viewModel = viewModel)
                }
            }
        }
    }
}
