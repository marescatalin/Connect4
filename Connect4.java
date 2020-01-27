package assignment2017;

import assignment2017.interfaces.ColumnFullException;
import assignment2017.interfaces.Connect4GameState;
import assignment2017.interfaces.Connect4Player;
import assignment2017.interfaces.IllegalColumnException;
import assignment2017.interfaces.IllegalRowException;
import assignment2017.interfaces.Connect4Displayable;

import static assignment2017.interfaces.Connect4GameState.*;

public class Connect4 {
    /**
     * Declaring the instance variables for Connect4 Class
     */
    Connect4GameState gameState;
    Connect4Player red;
    Connect4Player yellow;
    Connect4Displayable display;

    /**
     * Constructor of Connect4
     * 
     * @param gameState
     * @param red
     * @param yellow
     * @param display
     */
    public Connect4(Connect4GameState gameState, Connect4Player red, Connect4Player yellow,
            Connect4Displayable display) {
        this.gameState = gameState;
        this.red = red;
        this.yellow = yellow;
        this.display = display;
    }

    /**
     * Initialising the game As long as the game is not over display the menu
     * Get whoes turn it is and ask that player to make a move When the game is
     * over display the final board Display who the winner is
     */
    public void play() {
        gameState.startGame();
        while (!gameState.gameOver()) {
            display.displayBoard();
            if (gameState.whoseTurn() == RED)
                red.makeMove(gameState);
            else if (gameState.whoseTurn() == YELLOW)
                yellow.makeMove(gameState);
        }
        display.displayBoard();
        if (gameState.getWinner() == RED)
            System.out.println("R wins");
        else if (gameState.getWinner() == YELLOW)
            System.out.println("Y wins");
        else
            System.out.println("Draw");
    }
}
