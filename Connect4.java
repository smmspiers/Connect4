package assignment2017;

import assignment2017.codeprovided.*;

/**
 * A class that controls the flow of game play.
 * @author Sammy Spiers (aca16sms)
 * @version 1.0
 */
public class Connect4 {

    private Connect4GameState gameState;
    private Connect4Player red;
    private Connect4Player yellow;
    private Connect4Displayable display;

    /**
     * Class constructor that passes instances of the game state, the two players
     * and the display to the instance variables of Connect4.
     * @param gameState the current game state.
     * @param red player who will be the red counter.
     * @param yellow player who will be the yellow counter.
     * @param display way in which game will be displayed to user.
     */
    public Connect4(Connect4GameState gameState, Connect4Player red, Connect4Player yellow, Connect4Displayable display) {
        this.gameState = gameState;
        this.red = red;
        this.yellow = yellow;
        this.display = display;
    }

    /**
     * Starts game and initialises game play.
     */
    public void play() {

        gameState.startGame();

        while (!gameState.gameOver()) {
            if (gameState.whoseTurn() == Connect4GameState.YELLOW) {
                yellow.makeMove(gameState);
            } else {
                red.makeMove(gameState);
            }
            display.displayBoard();
        }

        if (gameState.getWinner() == Connect4GameState.RED) {
            System.out.println("Red wins.");
        } else if (gameState.getWinner() == Connect4GameState.YELLOW) {
            System.out.println("Yellow wins.");
        } else {
            // Only other possibility is if the board is full
            System.out.println("Board full. Game tied.");
        }
    }
}
