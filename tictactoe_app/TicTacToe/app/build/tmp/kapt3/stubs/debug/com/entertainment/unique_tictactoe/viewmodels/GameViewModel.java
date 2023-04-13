package com.entertainment.unique_tictactoe.viewmodels;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0005H\u0002J\u0010\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u0006H\u0002J\u0014\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0002J\b\u0010!\u001a\u00020\tH\u0002J\u000e\u0010\"\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020$J\u0006\u0010%\u001a\u00020\u001cJ\b\u0010&\u001a\u00020\u001cH\u0002R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u000b8F\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR+\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f8F@BX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006\'"}, d2 = {"Lcom/entertainment/unique_tictactoe/viewmodels/GameViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_boardMap", "", "", "Lcom/entertainment/unique_tictactoe/states/BoardCellValue;", "_showDialog", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "boardMap", "", "getBoardMap", "()Ljava/util/Map;", "<set-?>", "Lcom/entertainment/unique_tictactoe/states/GameState;", "gameState", "getGameState", "()Lcom/entertainment/unique_tictactoe/states/GameState;", "setGameState", "(Lcom/entertainment/unique_tictactoe/states/GameState;)V", "gameState$delegate", "Landroidx/compose/runtime/MutableState;", "showDialog", "Lkotlinx/coroutines/flow/StateFlow;", "getShowDialog", "()Lkotlinx/coroutines/flow/StateFlow;", "addValueToBoard", "", "cellNo", "checkForVictory", "cellValue", "createBoardMap", "isBoardFull", "onAction", "action", "Lcom/entertainment/unique_tictactoe/features/UserAction;", "onDialogDismiss", "resetState", "app_debug"})
public final class GameViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState gameState$delegate = null;
    private java.util.Map<java.lang.Integer, com.entertainment.unique_tictactoe.states.BoardCellValue> _boardMap;
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _showDialog = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> showDialog = null;
    
    public GameViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.entertainment.unique_tictactoe.states.GameState getGameState() {
        return null;
    }
    
    private final void setGameState(com.entertainment.unique_tictactoe.states.GameState p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.Integer, com.entertainment.unique_tictactoe.states.BoardCellValue> getBoardMap() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> getShowDialog() {
        return null;
    }
    
    public final void onDialogDismiss() {
    }
    
    public final void onAction(@org.jetbrains.annotations.NotNull()
    com.entertainment.unique_tictactoe.features.UserAction action) {
    }
    
    private final void addValueToBoard(int cellNo) {
    }
    
    private final java.util.Map<java.lang.Integer, com.entertainment.unique_tictactoe.states.BoardCellValue> createBoardMap() {
        return null;
    }
    
    private final boolean checkForVictory(com.entertainment.unique_tictactoe.states.BoardCellValue cellValue) {
        return false;
    }
    
    private final boolean isBoardFull() {
        return false;
    }
    
    private final void resetState() {
    }
}