package assignment2017;

import assignment2017.codeprovided.Connect4Displayable;

public class Connect4ConsoleDisplay implements Connect4Displayable {

    public void displayBoard() {

        for (int row = MyGameState.board.length - 1; row >= 0; row--) {

            System.out.print("|");
            for (int col = 0; col < 7; col++) {

                if (MyGameState.board[row][col] == 0) {
                    System.out.print(" R ");
                } else if (MyGameState.board[row][col] == 1) {
                    System.out.print(" Y ");
                } else if (MyGameState.board[row][col] == -1) {
                    System.out.print("   ");
                }
            }
            System.out.println("|");
        }

        System.out.println(" --------------------- ");
        System.out.println("  0  1  2  3  4  5  6  ");
    }
}
