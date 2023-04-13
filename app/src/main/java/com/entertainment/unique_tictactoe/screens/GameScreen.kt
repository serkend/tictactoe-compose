package com.entertainment.unique_tictactoe.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.entertainment.unique_tictactoe.states.BoardCellValue
import com.entertainment.unique_tictactoe.states.PlayerState
import com.entertainment.unique_tictactoe.components.BoardBase
import com.entertainment.unique_tictactoe.components.Circle
import com.entertainment.unique_tictactoe.components.Cross
import com.entertainment.unique_tictactoe.features.UserAction
import com.entertainment.unique_tictactoe.viewmodels.GameViewModel
import com.entertainment.unique_tictactoe.R

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun GameScreen(modifier: Modifier = Modifier, viewModel: GameViewModel) {
    val state = viewModel.gameState
    val showDialog by viewModel.showDialog.collectAsState()
    Column(
        modifier = modifier
            .fillMaxSize()
            //    .background(GrayBackground)
            .padding(horizontal = 20.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = CenterHorizontally
    ) {
        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = stringResource(id = R.string.player_0_score, state.playerCircleCount),
                fontSize = 20.sp
            )
            Text(text = stringResource(id = R.string.draw_count, state.drawCount), fontSize = 20.sp)
            Text(
                text = stringResource(id = R.string.player_X_score, state.playerCrossCount),
                fontSize = 20.sp
            )

        }
        Text(
            text = stringResource(R.string.tic_tac_toe),
            fontSize = 50.sp,
            fontFamily = FontFamily.Cursive
        )
        Box(
            modifier = modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .shadow(elevation = 10.dp, shape = RoundedCornerShape(20.dp))
                .clip(RoundedCornerShape(20.dp)),
            contentAlignment = Alignment.Center
        ) {
            BoardBase()
            LazyVerticalGrid(
                modifier = modifier
                    .size(300.dp)
                    .aspectRatio(1f),
                columns = GridCells.Fixed(3),

                ) {
                viewModel.boardMap.forEach { (cellNo, boardCellValue) ->
                    item {
                        Column(
                            modifier = modifier
                                .fillMaxSize()
                                .aspectRatio(1f)
                                .clickable(
                                    interactionSource = MutableInteractionSource(),
                                    indication = null
                                ) {
                                    viewModel.onAction(UserAction.BoardTapped(cellNo))
                                },
                            horizontalAlignment = CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            AnimatedVisibility(
                                visible = boardCellValue != BoardCellValue.None, enter = scaleIn(
                                    tween(1000)
                                )
                            ) {
                                if (boardCellValue == BoardCellValue.Circle) {
                                    Circle()
                                } else if (boardCellValue == BoardCellValue.Cross) {
                                    Cross()
                                }
                            }

                        }
                    }
                }
            }
        }
        Row(
            modifier = modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = when (state.playerState) {
                    PlayerState.PlayerCircleTurn -> {
                        stringResource(id = R.string.player_O_turn)
                    }
                    PlayerState.PlayerCrossTurn -> {
                        stringResource(id = R.string.player_X_turn)
                    }
                    PlayerState.PlayerCircleWon -> {
                        SimpleAlertDialog(
                            showDialog = showDialog,
                            onDismissDialog = { viewModel.onDialogDismiss() },
                            stringResource(id = R.string.player_0_won)
                        )
                        stringResource(id = R.string.player_0_won)
                    }
                    PlayerState.PlayerCrossWon -> {
                        SimpleAlertDialog(
                            showDialog = showDialog,
                            onDismissDialog = { viewModel.onDialogDismiss() },
                            stringResource(id = R.string.player_X_won)
                        )
                        stringResource(id = R.string.player_X_won)
                    }
                    PlayerState.Draw -> {
                        SimpleAlertDialog(
                            showDialog = showDialog,
                            onDismissDialog = { viewModel.onDialogDismiss() },
                            stringResource(id = R.string.draw)
                        )
                        stringResource(id = R.string.draw)
                    }
                }, fontSize = 20.sp
            )

            val cornerRadius = 16.dp
            val gradientColors = listOf(Color(0xFF7b4397), Color(0xFFdc2430))

            Button(
                onClick = {
                    viewModel.onAction(UserAction.PlayAgainButtonClicked)
                },
                contentPadding = PaddingValues(),
                shape = RoundedCornerShape(cornerRadius),
            ) {

                Text(
                    modifier = Modifier.padding(12.dp),
                    text = stringResource(id = R.string.play_again),
                    fontSize = 20.sp,
                    color = Color.White
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SimpleAlertDialog(
    showDialog: Boolean = true,
    onDismissDialog: () -> Unit = {},
    dialogText: String = stringResource(R.string.player)
) {
    if (showDialog) {
        AlertDialog(
            backgroundColor = MaterialTheme.colors.surface,
            modifier = Modifier.clip(shape = RoundedCornerShape(20.dp)),
            onDismissRequest = { onDismissDialog() },
            buttons = {
                Row(
                    modifier = Modifier
                        .padding(bottom = 30.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Button(
                        modifier = Modifier
                            .fillMaxWidth(0.5f),
                        shape = RoundedCornerShape(20.dp),
                        onClick = { onDismissDialog() },
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = MaterialTheme.colors.secondary,
                            contentColor = MaterialTheme.colors.onSurface
                        )
                    ) {
                        Text(
                            modifier = Modifier.padding(12.dp),
                            text = stringResource(R.string.ok),
                            fontSize = 20.sp
                        )
                    }
                }
            },
            title = { Text(text = stringResource(id = R.string.empty)) },
            text = {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Center
                ) {
                    Text(text = dialogText, fontSize = 24.sp, color = MaterialTheme.colors.onSurface,)
                }
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Prev() {
    GameScreen(viewModel = GameViewModel())
}
