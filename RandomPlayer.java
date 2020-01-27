package assignment2017;

import java.util.Scanner;

import assignment2017.interfaces.ColumnFullException;
import assignment2017.interfaces.Connect4GameState;
import assignment2017.interfaces.IllegalColumnException;
import assignment2017.interfaces.IllegalRowException;
import assignment2017.interfaces.Connect4Player;

/**
 * Generating a random number in the range 0-6 Putting a counter in the column
 * position generated If the column number is out of range another column is
 * generated If the column selected is full then another column is selected
 * 
 * @author mares
 *
 */
public class RandomPlayer extends Connect4Player {
    public void makeMove(Connect4GameState gameState) {
        int column = (int) (Math.random() * 7);
        try {
            gameState.move(column);
        } catch (IllegalColumnException e) {
            while (column < 0 || column > 6) {
                column = (int) (Math.random() * 7);
            }
        } catch (ColumnFullException e) {
            while (gameState.isColumnFull(column)) {
                column = (int) (Math.random() * 7);
            }
        }
        System.out.println("Computer dropped counter in column " + column);
    }
}
