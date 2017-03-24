package assignment2017;

import assignment2017.codeprovided.Connect4GameState;
import assignment2017.codeprovided.Connect4Player;

class Connect4 {

    //instances
    private Connect4GameState gameState;
    private Connect4Player red;
    private Connect4Player yellow;
    private Connect4ConsoleDisplay console;

    Connect4(Connect4GameState gameState, Connect4Player red, Connect4Player yellow, Connect4ConsoleDisplay console) {
        this.gameState = gameState;
        this.red = red;
        this.yellow = yellow;
        this.console = console;
    }

    void play() {

        gameState.startGame();

        while (!gameState.gameOver()) {
            if (gameState.whoseTurn() == Connect4GameState.YELLOW) {
                yellow.makeMove(gameState);
            } else {
                red.makeMove(gameState);
            }
            console.displayBoard();
        }

        if (gameState.getWinner() == Connect4GameState.RED) {
            System.out.println("Red wins.");
        } else if (gameState.getWinner() == Connect4GameState.YELLOW) {
            System.out.println("Yellow wins.");
        } else {
            System.out.println("Board full. Game tied.");
        }
    }
}
