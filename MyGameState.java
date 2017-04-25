package assignment2017;

import assignment2017.codeprovided.*;

/**
 * Extension of Connect4GameState which has all methods implemented including
 * configuration of the board and a counter to determine whose turn it is.
 * @author Sammy Spiers (aca16sms)
 * @version 1.0
 */
public class MyGameState extends Connect4GameState {

    private int turn;

    /**
     * Boolean which determines whether game is played on GUI or console.
     */
    public boolean gUI;

    /**
     * 2D array which contains all the values and locations of each counter.
     */
    public int[][] board = new int[NUM_ROWS][NUM_COLS];

    public void startGame() {
        // Iterates through board the set all the values to empty
        for (int row = 0; row < NUM_ROWS; row++) {
            for (int col = 0; col < NUM_COLS; col++) {
                board[row][col] = EMPTY;
            }
        }
        turn = 1;
    }

    public int getCounterAt(int col, int row) throws IllegalColumnException, IllegalRowException  {

        if (col < 0 || col >= NUM_COLS) {
            throw new IllegalColumnException(col);
        }

        if (row < 0 || row >= NUM_ROWS) {
            throw new IllegalRowException(row);
        }

        return board[row][col];
    }

    public int whoseTurn() {
        if (turn % 2 == 0) {
            return YELLOW;
        } else {
            return RED;
        }
    }

    public boolean gameOver() {
        return (!(getWinner() == EMPTY) || isBoardFull());
    }

    public boolean isBoardFull() {
        boolean fullOrNot = false;
        int counterCount = 0;
        for (int row = 0; row < NUM_ROWS; row++) {
            for (int col = 0; col < NUM_COLS; col++) {

                if (board[row][col] == YELLOW || board[row][col] == RED) {
                    counterCount++;
                }

                if (counterCount == NUM_COLS * NUM_ROWS) {
                    fullOrNot = true;
                }
            }
        }
        return fullOrNot;
    }

    public int getWinner() {
        if (are4Connected(RED)) {
            return RED;
        } else if (are4Connected(YELLOW)) {
            return YELLOW;
        } else {
            return EMPTY;
        }
    }

    public void move(int col) throws ColumnFullException, IllegalColumnException {

        if (col < 0 || col >= NUM_COLS) {
            throw new IllegalColumnException(col);
        }

        if (isColumnFull(col)) {
            throw new ColumnFullException(col);
        }

        for (int row = 0; row < NUM_ROWS; row++) {
            if (board[row][col] == EMPTY) {
                if (whoseTurn() == YELLOW) {
                    board[row][col] = YELLOW;
                } else if (whoseTurn() == RED) {
                    board[row][col] = RED;
                }
                turn++;
                return;
            }
        }
    }

    public boolean isColumnFull(int col) throws IllegalColumnException {

        if (col < 0 || col >= NUM_COLS) {
            throw new IllegalColumnException(col);
        }

        boolean fullOrNot = false;
        int counterCount = 0;
        for (int row = 0; row < NUM_ROWS; row++) {

            if (board[row][col] == YELLOW || board[row][col] == RED) {
                counterCount++;
            }

            if (counterCount == NUM_ROWS) {
                fullOrNot = true;
            }
        }
        return fullOrNot;
    }

    public Connect4GameState copy() {
        MyGameState copy = new MyGameState();

        /* A deep copy is better here so I have created a new board in memory
        and assigned all the board values of the current game state to the copy */
        int[][] boardCopy = new int[NUM_ROWS][NUM_COLS];
        for (int row = 0; row < NUM_ROWS; row++) {
            for (int col = 0; col < NUM_COLS; col++) {
                boardCopy[row][col] = board[row][col];
            }
        }
        copy.board = boardCopy;

        copy.turn = this.turn;
        copy.gUI = this.gUI;

        return copy;
    }

    private boolean are4Connected(int player) {

        // 4 in a row
        for (int row = 0; row < NUM_ROWS; row++) {
            for (int col = 0; col < NUM_COLS - 3; col++) {
                if ((board[row][col] == player)
                        && (board[row][col + 1] == player)
                        && (board[row][col + 2] == player)
                        && (board[row][col + 3] == player)) {
                    return true;
                }
            }
        }

        // 4 in a column
        for (int row = 0; row < NUM_ROWS - 3; row++) {
            for (int col = 0; col < NUM_COLS; col++) {
                if ((board[row][col] == player)
                        && (board[row + 1][col] == player)
                        && (board[row + 2][col] == player)
                        && (board[row + 3][col] == player)) {
                    return true;
                }
            }
        }

        // 4 in a diagonal towards top right
        for (int row = 0; row < NUM_ROWS - 3; row++) {
            for (int col = 0; col < NUM_COLS - 3; col++) {
                if ((board[row][col] == player)
                        && (board[row + 1][col + 1] == player)
                        && (board[row + 2][col + 2] == player)
                        && (board[row + 3][col + 3] == player)) {
                    return true;
                }
            }
        }

        // 4 in a diagonal towards top left
        for (int row = 0; row < NUM_ROWS - 3; row++) {
            for (int col = 3; col < NUM_COLS ; col++) {
                if ((board[row][col] == player)
                        && (board[row + 1][col - 1] == player)
                        && (board[row + 2][col - 2] == player)
                        && (board[row + 3][col - 3] == player)) {
                    return true;
                }
            }
        }
        return false;
    }
}
