package assignment2017;

import assignment2017.codeprovided.Connect4Player;

public class PlayConnect4 {

    public static void main(String[] args) {
        MyGameState gameState = new MyGameState();

        Connect4ConsoleDisplay console = new Connect4ConsoleDisplay();
        Connect4Player keyboard = new KeyboardPlayer();
        Connect4Player computer = new RandomPlayer();

        Connect4 game = new Connect4(gameState, computer, keyboard, console);
        game.play();
    }
}