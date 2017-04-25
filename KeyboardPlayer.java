package assignment2017;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;
import java.util.InputMismatchException;

import assignment2017.codeprovided.*;

/**
 * A class that represents the keyboard player.
 * @author Sammy Spiers (aca16sms)
 * @version 1.0
 */
public class KeyboardPlayer extends Connect4Player {

    public static class Keys implements KeyListener {

        private Connect4GameState gameState;

        Keys(Connect4GameState gameState) {
            this.gameState = gameState;
        }

        private int whichKey(KeyEvent k) {
            int key = 0;
            switch (k.getKeyCode()) {
                case KeyEvent.VK_0 :
                    key = 0;
                    System.out.println("hasdfsdf");
                    break;
                case KeyEvent.VK_1 :
                    key = 1;
                    break;
                case KeyEvent.VK_2 :
                    key = 2;
                    break;
                case KeyEvent.VK_3 :
                    key = 3;
                    break;
                case KeyEvent.VK_4 :
                    key = 4;
                    break;
                case KeyEvent.VK_5 :
                    key = 5;
                    break;
                case KeyEvent.VK_6 :
                    key = 6;
                    break;
            }
            return key;
        }

        public void keyPressed(KeyEvent k) {

            try {
                gameState.move(whichKey(k));
            } catch (ColumnFullException e) {
                System.out.println("COLUMN FULL");
            }
        }

        public void keyTyped(KeyEvent e) {

        }

        public void keyReleased(KeyEvent e) {

        }
    }

    private void gUIMove(Connect4GameState gameState) {
        Keys event = new Keys(gameState);
    }

    private void consoleMove(Connect4GameState gameState) {
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

    public void makeMove(Connect4GameState gameState) {
        MyGameState currentGameState = (MyGameState) gameState.copy();

        if (currentGameState.gUI) {
            gUIMove(gameState);
        }
        if (!currentGameState.gUI) {
            consoleMove(gameState);
        }
    }
}