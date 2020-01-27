package assignment2017;

import java.util.Scanner;

import assignment2017.interfaces.ColumnFullException;
import assignment2017.interfaces.Connect4GameState;
import assignment2017.interfaces.IllegalColumnException;
import assignment2017.interfaces.IllegalRowException;
import assignment2017.interfaces.Connect4Player;

public class KeyboardPlayer extends Connect4Player {
    public void makeMove(Connect4GameState gameState) {
        /**
         * Ask the user for input Make a move as long as the column is in the
         * correct range and the column the user tries to input into is not full
         */
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter a column number, 0 to 6 followed by return. ");
        while (!scan.hasNextInt()) {
            scan.next();
            System.out.println("Please enter a column number, 0 to 6 followed by return. ");
        }
        int column = scan.nextInt();
        try {
            gameState.move(column);
        } catch (IllegalColumnException e) {
            while (column < 0 || column > 6) {
                System.out.println("Please enter a column number, 0 to 6 followed by return. ");
                column = scan.nextInt();
            }
        } catch (ColumnFullException e) {
            while (gameState.isColumnFull(column)) {
                System.out.println("Column " + column + " is full.");
                System.out.println("Please enter a column number, 0 to 6 followed by return. ");
                column = scan.nextInt();
            }
        }
    }

}
