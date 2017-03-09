package assignment2017;

import assignment2017.codeprovided.ColumnFullException;
import assignment2017.codeprovided.Connect4GameState;
import assignment2017.codeprovided.Connect4Player;
import assignment2017.codeprovided.IllegalColumnException;

public class RandomPlayer extends Connect4Player {

    public void makeMove(Connect4GameState gameState) {

        int randomCol = 0;
        int exceptionCounter = 0;
        while (true) {
            try {
                randomCol = (int) (Math.random() * Connect4GameState.NUM_COLS);
                gameState.move(randomCol);
            } catch (ColumnFullException e) {
                if (exceptionCounter < 1) {
                    System.out.println("COLUMN FULL");
                }
                //exceptionsCaught[exceptionCounter] = true;
                exceptionCounter++;
            } catch (IllegalColumnException e) {
                if (exceptionCounter < 1) {
                    System.out.println("NOT A VALID COLUMN");
                }
                //exceptionsCaught[exceptionCounter] = true;
                exceptionCounter++;
            } finally {
                if (randomCol >= 0 && randomCol < Connect4GameState.NUM_COLS) {
                    break;
                }
            }
        }

        /*if (gameState.isColumnFull(randomCol)) {
            throw new ColumnFullException(randomCol);
        } else {*/
    }
}
