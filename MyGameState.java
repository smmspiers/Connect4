package assignment2017;

import assignment2017.codeprovided.ColumnFullException;
import assignment2017.codeprovided.Connect4GameState;
import assignment2017.codeprovided.IllegalColumnException;

public class MyGameState extends Connect4GameState {

    public static int board[][] = new int[NUM_ROWS][NUM_COLS];
    private static int turn;

    public void startGame() {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = EMPTY;
            }
        }
        turn = 1;
    }

    public int getCounterAt(int col, int row) {
        return board[row][col];
    }

    public int whoseTurn() {
        if (turn % 2 == 0) {
            return YELLOW; //keyboard player
        } else {
            return RED; //random player
        }
    }

    public boolean gameOver() {
        return false;
    }

    public boolean isBoardFull() {
        boolean fullOrNot = false;
        int counterCount = 0;
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == YELLOW || board[row][col] == RED) {
                    counterCount++;
                }

                if (counterCount == NUM_COLS * NUM_ROWS) {
                    fullOrNot = true;
                } else {
                    fullOrNot = false;
                }
            }
        }
        return fullOrNot;
    }

    public int getWinner() {
        return 0;
    }

    public void move(int col) throws ColumnFullException, IllegalColumnException {

        if (col < 0 || col >= NUM_COLS) {
            throw new IllegalColumnException(col);
        }

        if (isColumnFull(col)) {
            throw new ColumnFullException(col);
        }

        for (int row = 0; row < board.length; row++) {
            if (board[row][col] == EMPTY) {
                if (whoseTurn() == YELLOW) {
                    board[row][col] = YELLOW;
                    return;
                } else if (whoseTurn() == RED) {
                    board[row][col] = RED;
                    return;
                }
            }
        }
        turn++;
    }

    public boolean isColumnFull(int col) {
        boolean fullOrNot = false;
        int counterCount = 0;
        for (int row = 0; row < board.length; row++) {

            if (board[row][col] == YELLOW || board[row][col] == RED) {
                counterCount++;
            }

            if (counterCount == NUM_ROWS) {
                fullOrNot = true;
            } else {
                fullOrNot = false;
            }
        }
        return fullOrNot;
    }

    public Connect4GameState copy() {
        return this;
    }
}
