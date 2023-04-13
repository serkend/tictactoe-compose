package com.entertainment.unique_tictactoe.features;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/entertainment/unique_tictactoe/features/UserAction;", "", "()V", "BoardTapped", "PlayAgainButtonClicked", "Lcom/entertainment/unique_tictactoe/features/UserAction$BoardTapped;", "Lcom/entertainment/unique_tictactoe/features/UserAction$PlayAgainButtonClicked;", "app_debug"})
public abstract class UserAction {
    
    private UserAction() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/entertainment/unique_tictactoe/features/UserAction$PlayAgainButtonClicked;", "Lcom/entertainment/unique_tictactoe/features/UserAction;", "()V", "app_debug"})
    public static final class PlayAgainButtonClicked extends com.entertainment.unique_tictactoe.features.UserAction {
        @org.jetbrains.annotations.NotNull()
        public static final com.entertainment.unique_tictactoe.features.UserAction.PlayAgainButtonClicked INSTANCE = null;
        
        private PlayAgainButtonClicked() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u000e\u001a\u00020\u000fH\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/entertainment/unique_tictactoe/features/UserAction$BoardTapped;", "Lcom/entertainment/unique_tictactoe/features/UserAction;", "cellNo", "", "(I)V", "getCellNo", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "app_debug"})
    public static final class BoardTapped extends com.entertainment.unique_tictactoe.features.UserAction {
        private final int cellNo = 0;
        
        @org.jetbrains.annotations.NotNull()
        public final com.entertainment.unique_tictactoe.features.UserAction.BoardTapped copy(int cellNo) {
            return null;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public java.lang.String toString() {
            return null;
        }
        
        public BoardTapped(int cellNo) {
            super();
        }
        
        public final int component1() {
            return 0;
        }
        
        public final int getCellNo() {
            return 0;
        }
    }
}