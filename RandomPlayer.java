package assignment2017;

import assignment2017.codeprovided.*;

/**
 * A class that represents the random player.
 * @author Sammy Spiers (aca16sms)
 * @version 1.0
 */
public class RandomPlayer extends Connect4Player {

    public void makeMove(Connect4GameState gameState) {

        int randomCol = 0;
        boolean moveMade = false;
        while (!moveMade) {
            try {
                // Random method returns value between 0 and 1 so need to cast to integer
                randomCol = (int) (Math.random() * Connect4GameState.NUM_COLS);
                gameState.move(randomCol);
            } catch (ColumnFullException e) {
                System.out.println("COLUMN FULL");
            } catch (IllegalColumnException e) {
                System.out.println("NOT A VALID COLUMN");
            }
            if (randomCol >= 0 && randomCol < Connect4GameState.NUM_COLS) {
                moveMade = true;
            }
        }
    }
}
