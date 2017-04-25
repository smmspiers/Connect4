package assignment2017;

import assignment2017.codeprovided.*;

import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * @author Sammy Spiers
 * @version 1.0
 */
class GameSettings {

    // Opponents
    private static final int HUMAN = 0;
    private static final int RANDOM = 1;
    private static final int INTELLIGENT = 2;

    // Displays
    private static final int CONSOLE = 0;
    private static final int GUI = 1;

    private Scanner keyboard = new Scanner(System.in);

    Connect4Player setOpponent() {

        int input = -1;
        boolean opponentChosen = false;
        Connect4Player opponent = null;

        while (!opponentChosen) {
            try {
                System.out.println("Human --> 0");
                System.out.println("Random --> 1");
                System.out.println("Intelligent --> 2");
                System.out.print("Enter one of the numbers to choose an opponent: ");
                input = keyboard.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("INCORRECT INPUT");
            }
            if (input >= 0 && input <= 2) {
                opponentChosen = true;
            }
        }

        switch (input) {
            case HUMAN :
                opponent = new KeyboardPlayer();
                break;
            case RANDOM :
                opponent = new RandomPlayer();
                break;
            case INTELLIGENT :
                opponent = new IntelligentPlayer();
                break;
        }

        return opponent;
    }

    Connect4Displayable setDisplay(MyGameState gameState) {

        int input = -1;
        boolean displayChosen = false;
        Connect4Displayable display = null;

        while (!displayChosen) {
            try {
                System.out.println("Console --> 3");
                System.out.println("Graphical User Interface --> 4");
                System.out.print("Enter one of the numbers to choose an display : ");
                input = keyboard.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("INCORRECT INPUT");
            }
            if (input >= 3 && input <= 4) {
                displayChosen = true;
            }
        }

        switch (input) {
            case CONSOLE :
                display = new Connect4ConsoleDisplay(gameState);
                gameState.gUI = false;
                break;
            case GUI :
                display = new Connect4GraphicalDisplay(gameState);
                gameState.gUI = true;
                break;
        }

        return display;
    }
}
