package assignment2017;

import assignment2017.interfaces.ColumnFullException;
import assignment2017.interfaces.Connect4GameState;
import assignment2017.interfaces.IllegalColumnException;
import assignment2017.interfaces.IllegalRowException;
import assignment2017.interfaces.Connect4Displayable;

import static assignment2017.interfaces.Connect4GameState.*;

/**
 * Displaying the board Showing R for red counters and Y for yellow counters
 * 
 * @author mares
 *
 */
public class Connect4ConsoleDisplay implements Connect4Displayable {
    Connect4GameState gameState;

    public Connect4ConsoleDisplay(Connect4GameState state) {
        gameState = state;
    }

    public void displayBoard() {
        MyGameState newState = (MyGameState) gameState;
        for (int i = 5; i >= 0; i--) {
            System.out.print("| ");
            for (int j = 0; j < newState.myGrid[0].length; j++) {
                if (gameState.getCounterAt(j, i) == EMPTY)
                    System.out.print("  ");
                else {
                    if (gameState.getCounterAt(j, i) == RED)
                        System.out.print("R ");
                    else
                        System.out.print("Y ");
                }
            }
            System.out.println("|");
        }
        System.out.println(" --------------- ");
        System.out.println("  0 1 2 3 4 5 6  ");
    }

}
