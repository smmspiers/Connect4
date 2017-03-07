package assignment2017;

import assignment2017.codeprovided.ColumnFullException;
import assignment2017.codeprovided.Connect4GameState;
import assignment2017.codeprovided.Connect4Player;
import assignment2017.codeprovided.IllegalColumnException;

public class RandomPlayer extends Connect4Player {

    public void makeMove(Connect4GameState gameState) {
        int randomCol;
        while (true) {
            try {
                randomCol = (int) (Math.random() * Connect4GameState.NUM_COLS + 1);
                gameState.move(randomCol);
            } catch (ColumnFullException e) {

            } catch (IllegalColumnException e) {

            }
        }
    }
}
