package br.com.dio.model;

import java.util.Stack;

public class MoveHistory {

        private Stack<Move> moves = new Stack<>();

        public static class Move {
            private final int col, row;
            private final Integer previousValue;
            private final Integer newValue;

            public Move(int col, int row, Integer previousValue, Integer newValue) {
                this.col = col;
                this.row = row;
                this.previousValue = previousValue;
                this.newValue = newValue;
            }

            // getters...
            public int getCol() { return col; }
            public int getRow() { return row; }
            public Integer getPreviousValue() { return previousValue; }
            public Integer getNewValue() { return newValue; }
        }

        public void addMove(Move move) {
            moves.push(move);
        }

        public Move undo() {
            return moves.isEmpty() ? null : moves.pop();
        }

        public boolean canUndo() {
            return !moves.isEmpty();
        }
    }

