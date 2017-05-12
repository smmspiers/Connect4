package assignment2017;

import assignment2017.codeprovided.ColumnFullException;
import assignment2017.codeprovided.Connect4GameState;
import assignment2017.codeprovided.Connect4Player;
import assignment2017.codeprovided.IllegalColumnException;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * A class that represents a Key Listener Player
 * @author Sammy Spiers
 * @version 1.0
 */
public class KeyListenerPlayer extends Connect4Player implements KeyListener {

    private MyGameState gameState;

    KeyListenerPlayer(MyGameState gameState) {
        this.gameState = gameState;
    }

    private int whichKey(KeyEvent k) {
        return (k.getKeyCode() - 48);
        // Takeaway 48 to get corresponding key from key code
    }

    @Override
    public void keyPressed(KeyEvent k) {
        try {
            gameState.move(whichKey(k));
        } catch (ColumnFullException e) {
            System.out.println("COLUMN FULL");
        } catch (IllegalColumnException e) {
            if (whichKey(k) > 6 && whichKey(k) < 10) {
                System.out.println("NOT A VALID COLUMN");
            } else {
                System.out.println("INCORRECT INPUT");
            }
        }
    }

    /* Had to implement the following methods since I am extending an abstract class
       and implementing and interface, however they are redundant
     */
    public void keyTyped(KeyEvent k) {

    }

    public void keyReleased(KeyEvent k) {

    }

    public void makeMove(Connect4GameState gameState) {

    }
}
