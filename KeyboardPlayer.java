package assignment2017;

import java.util.Scanner;

import java.util.InputMismatchException;
import assignment2017.codeprovided.ColumnFullException;
import assignment2017.codeprovided.IllegalColumnException;

import assignment2017.codeprovided.Connect4Player;
import assignment2017.codeprovided.Connect4GameState;

public class KeyboardPlayer extends Connect4Player {

    public void makeMove(Connect4GameState gameState) {

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
//                continue;
            } catch (ColumnFullException e) {
                System.out.println("COLUMN FULL");
//                continue;
            } catch (IllegalColumnException e) {
                System.out.println("NOT A VALID COLUMN");
//                continue;
            }
            if (input >= 0 && input < Connect4GameState.NUM_COLS) {
                moveMade = true;
            }
        }
    }
}