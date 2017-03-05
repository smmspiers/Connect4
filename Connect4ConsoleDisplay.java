package assignment2017;

import assignment2017.codeprovided.Connect4Displayable;

public class Connect4ConsoleDisplay implements Connect4Displayable {

    public void displayBoard() {
        for (int i = 0; i < 12; i++) {
            System.out.format("|            |n%");
        }

    }

    public static void main(String[] args) {

        Connect4ConsoleDisplay console = new Connect4ConsoleDisplay();

        console.displayBoard();
    }
}
