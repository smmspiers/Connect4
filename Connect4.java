package assignment2017;

import assignment2017.codeprovided.Connect4GameState;
import assignment2017.codeprovided.Connect4Player;

class Connect4 {

    //instances
    private Connect4GameState gameState;
    private Connect4Player player1;
    private Connect4Player player2;
    private Connect4ConsoleDisplay console;

    Connect4(Connect4GameState gameState, Connect4Player player1, Connect4Player player2, Connect4ConsoleDisplay console) {
        this.gameState = gameState;
        this.player1 = player1;
        this.player2 = player2;
        this.console = console;
    }

    void play() {

        gameState.startGame();

        while (!gameState.gameOver()) {
            player1.makeMove(gameState);
            console.displayBoard();
            player2.makeMove(gameState);
        }
        console.displayBoard();

        if (gameState.getWinner() == Connect4GameState.RED) {
            System.out.println("Red wins.");
        } else if (gameState.getWinner() == Connect4GameState.YELLOW) {
            System.out.println("Yellow wins.");
        } else {
            System.out.println("Board full. Game restarted.");
            play();
        }
    }
}
