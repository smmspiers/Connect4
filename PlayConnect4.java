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

        Connect4Displayable display = null;
        Connect4Player player1 = null;
        Connect4Player player2 = null;

        if (args[0].equals("-gui")) {
            display = new Connect4GraphicalDisplay(gameState);
            player1 = new KeyListenerPlayer(gameState);
            gameState.gUI = true;

            do {
                switch (gameState.opponent) {
                    case MyGameState.HUMAN:
                        if (args[0].equals("gui")) {
                            player2 = new KeyListenerPlayer(gameState);
                        } else {
                            player2 = new KeyboardPlayer();
                        }
                        break;
                    case MyGameState.RANDOM:
                        player2 = new RandomPlayer();
                        break;
                }
            } while (player2 == null);
            // Program won't continue until user enters opponent
        }

        if (args[0].equals("-nogui")) {
            display = new Connect4ConsoleDisplay(gameState);
            player1 = new KeyboardPlayer();
            player2 = new RandomPlayer();
            gameState.gUI = false;
        }

        Connect4 game = new Connect4(gameState, player2, player1, display);
        game.play();
    }
}