package assignment2017;

import java.util.InputMismatchException;
import java.util.Scanner;

import assignment2017.codeprovided.Connect4GameState;
import assignment2017.codeprovided.Connect4Player;

public class KeyboardPlayer extends Connect4Player {

    private static Scanner keyboard = new Scanner(System.in);

    public void makeMove(Connect4GameState gameState) {
        int input;
        do {
            try {
                input = keyboard.nextInt();
            } catch (InputMismatchException e) {

            }
        } while (input <= 6);
    }
}
