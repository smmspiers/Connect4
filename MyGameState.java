package assignment2017;

import assignment2017.codeprovided.*;

public class MyGameState extends Connect4GameState {

    public int[][] board = new int[NUM_ROWS][NUM_COLS];
    private int turn;

    private void setBoard(int[][] board) {
        this.board = board;
    }

    private void setTurn(int turn) {
        this.turn = turn;
    }

    private int[][] getBoard() {
        return board;
    }

    private int getTurn() {
        return turn;
    }

    public void startGame() {
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
            return YELLOW; //keyboard player
        } else {
            return RED; //random player
        }
    }

    public boolean gameOver() {
        return (getWinner() == RED || getWinner() == YELLOW || isBoardFull());
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
                } else {
                    fullOrNot = false;
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
            } else {
                fullOrNot = false;
            }
        }
        return fullOrNot;
    }

    public Connect4GameState copy() {
        MyGameState copy = new MyGameState();

        int[][] boardCopy;
        boardCopy = this.getBoard();
        copy.setBoard(boardCopy);

        int turnCopy;
        turnCopy = this.getTurn();
        copy.setTurn(turnCopy);

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
