package assignment2017;

import assignment2017.codeprovided.*;

/**
 * A class that is simply just to start and initialise the game,
 * containing only a main method.
 * @author Sammy Spiers (aca16sms)
 * @version 1.0
 */
public class PlayConnect4 {

    /**
     * Main method. Where the game is started.
     * @param args Determines whether game is played on GUI.
     */
    public static void main(String args[]) {
        MyGameState gameState = new MyGameState();

        Connect4Player player1 = new KeyboardPlayer();
        Connect4Player player2 = new KeyboardPlayer();
        Connect4Displayable display;

        //GameSettings settings = new GameSettings();
        if (args[0].equals("gui")) {
            display = new Connect4GraphicalDisplay(gameState);
        } else {
            display = new Connect4ConsoleDisplay(gameState);
        }

        Connect4 game = new Connect4(gameState, player2, player1, display);
        game.play();
    }
}