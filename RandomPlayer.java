package assignment2017;

import assignment2017.codeprovided.ColumnFullException;
import assignment2017.codeprovided.Connect4GameState;
import assignment2017.codeprovided.Connect4Player;
import assignment2017.codeprovided.IllegalColumnException;

public class RandomPlayer extends Connect4Player {

    public void makeMove(Connect4GameState gameState) {

        int randomCol;
        boolean moveMade = false;
        while (!moveMade) {
            try {
                randomCol = (int) (Math.random() * Connect4GameState.NUM_COLS);
                gameState.move(randomCol);
            } catch (ColumnFullException e) {
                continue;
            } catch (IllegalColumnException e) {
                continue;
            }
            if (randomCol >= 0 && randomCol < Connect4GameState.NUM_COLS) {
                MyGameState.turn++;
                moveMade = true;
            }
        }
    }
}
