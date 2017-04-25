package assignment2017;

import assignment2017.codeprovided.*;

/**
 * A class that implements Connect4Displayable to display the game
 * in the console.
 * @author Sammy Spiers (aca16sms)
 * @version 1.0
 */
public class Connect4ConsoleDisplay implements Connect4Displayable {

    private MyGameState gameState;

    /**
     * Class constructor to access current game state so that the
     * board can be accessed to display the board in the console.
     * @param gameState the current game state.
     */
    public Connect4ConsoleDisplay(MyGameState gameState) {
        this.gameState = gameState;
    }

    /**
     * Displays the board in the console.
     */
    public void displayBoard() {

        /* Iterating backwards since board is displayed downwards in console, so
        that the bottom left space is indexed by the 0th row and column */
        for (int row = Connect4GameState.NUM_ROWS - 1; row >= 0; row--) {
            System.out.print("|");
            for (int col = 0; col < Connect4GameState.NUM_COLS; col++) {
                if (gameState.board[row][col] == Connect4GameState.RED) {
                    System.out.print(" R ");
                } else if (gameState.board[row][col] == Connect4GameState.YELLOW) {
                    System.out.print(" Y ");
                } else if (gameState.board[row][col] == Connect4GameState.EMPTY) {
                    System.out.print("   ");
                }
            }
            System.out.println("|");
        }

        System.out.println(" --------------------- ");
        System.out.println("  0  1  2  3  4  5  6  ");
    }
}
