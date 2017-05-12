package assignment2017;

import java.util.Scanner;
import java.util.InputMismatchException;

import assignment2017.codeprovided.*;

/**
 * A class that represents the keyboard player.
 * @author Sammy Spiers (aca16sms)
 * @version 1.0
 */
public class KeyboardPlayer extends Connect4Player {

    /*private void gUIMove(Connect4GameState gameState) {

    }*/

    /*private void consoleMove(Connect4GameState gameState) {
        int input = 0;
        boolean moveMade = false;
        while (!moveMade) {
            try {
                Scanner keyboard = new Scanner(System.in);
                System.out.println("Please enter a column number, 0 to 6 followed by return.");
                input = keyboard.nextInt();
                gameState.move(input);
            } catch (InputMismatchException e) {
                System.out.println("INCORRECT INPUT");
            } catch (ColumnFullException e) {
                System.out.println("COLUMN FULL");
            } catch (IllegalColumnException e) {
                System.out.println("NOT A VALID COLUMN");
            }
            if (input >= 0 && input < Connect4GameState.NUM_COLS) {
                moveMade = true;
            }
        }
    }*/

    public void makeMove(Connect4GameState gameState) {
        /*MyGameState currentGameState = (MyGameState) gameState.copy();

        if (currentGameState.gUI) {
            gUIMove(gameState);
        }
        if (!currentGameState.gUI) {
            consoleMove(gameState);
        }*/

        int input = 0;
        boolean moveMade = false;
        while (!moveMade) {
            try {
                Scanner keyboard = new Scanner(System.in);
                System.out.println("Please enter a column number, 0 to 6 followed by return.");
                input = keyboard.nextInt();
                gameState.move(input);
            } catch (InputMismatchException e) {
                System.out.println("INCORRECT INPUT");
            } catch (ColumnFullException e) {
                System.out.println("COLUMN FULL");
            } catch (IllegalColumnException e) {
                System.out.println("NOT A VALID COLUMN");
            }
            if (input >= 0 && input < Connect4GameState.NUM_COLS) {
                moveMade = true;
            }
        }
    }
}