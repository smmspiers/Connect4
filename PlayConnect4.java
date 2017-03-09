package assignment2017;

import assignment2017.codeprovided.ColumnFullException;
import assignment2017.codeprovided.Connect4GameState;
import assignment2017.codeprovided.Connect4Player;

import java.util.Arrays;

public class PlayConnect4 {

    public static void main(String[] args) {
        MyGameState game = new MyGameState();

        Connect4ConsoleDisplay console = new Connect4ConsoleDisplay();

        Connect4Player keyboard = new KeyboardPlayer();

        Connect4Player computer = new RandomPlayer();

        game.startGame();

        /*for (int i = 0; i < 6; i++) {
            game.board[i][0] = 0;
        }*/

        while (true) {
            console.displayBoard();
            computer.makeMove(game);
            console.displayBoard();
            keyboard.makeMove(game);
        }
    }
}