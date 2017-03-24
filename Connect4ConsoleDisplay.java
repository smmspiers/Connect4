package assignment2017;

import assignment2017.codeprovided.Connect4Displayable;
import assignment2017.codeprovided.Connect4GameState;

public class Connect4ConsoleDisplay implements Connect4Displayable {

    private MyGameState gameState;

    // Overrides default constructor to access board instance from game state
    public Connect4ConsoleDisplay(MyGameState gameState) {
        this.gameState = gameState;
    }

    public void displayBoard() {

        // iterating backwards since board in displayed downwards
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
