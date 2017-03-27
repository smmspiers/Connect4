package assignment2017;

import assignment2017.codeprovided.*;

/**
 * A class that is simply just to start and initialise the
 * game, containing only the main method.
 * @author Sammy Spiers (aca16sms)
 * @version 1.0
 */
public class PlayConnect4 {

    /**
     * Main method. Where the game is started.
     * @param args not used.
     */
    public static void main(String[] args) {
        MyGameState gameState = new MyGameState();

        Connect4Displayable console = new Connect4ConsoleDisplay(gameState);
        Connect4Player keyboard = new KeyboardPlayer();
        Connect4Player computer = new RandomPlayer();

        Connect4 game = new Connect4(gameState, computer, keyboard, console);
        game.play();
    }
}