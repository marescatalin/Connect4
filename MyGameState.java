package assignment2017;

import assignment2017.interfaces.ColumnFullException;
import assignment2017.interfaces.Connect4GameState;
import assignment2017.interfaces.IllegalColumnException;
import assignment2017.interfaces.IllegalRowException;

import static assignment2017.interfaces.Connect4GameState.*;

public class MyGameState extends Connect4GameState {
    // Declaring the instance variables of MyGameState
    public int currentTurn;
    public int[][] myGrid;

    // Providing a no-arg constructor for my MyGameState
    public MyGameState() {
    }

    /**
     * Starts the game. Initialises every grid position in the board to EMPTY
     * and sets the current turn to RED
     */
    public void startGame() {
        myGrid = new int[NUM_ROWS][NUM_COLS];
        for (int i = 0; i < myGrid.length; i++) {
            for (int j = 0; j < myGrid[0].length; j++) {
                myGrid[i][j] = EMPTY;
            }
        }
        currentTurn = RED;

    }

    /**
     * Drops a counter into a slot on the board. The colour of the counter
     * depends on whose turn it is
     * 
     * @param col
     *            the column in which to drop the counter, in the range 0-6
     * @throws ColumnFullException
     *             if the column denoted by col is full (i.e. the move cannot be
     *             played)
     * @throws IllegalColumnException
     *             if col is not in the range 0-6 (i.e. an invalid column)
     */
    public void move(int col) throws ColumnFullException, IllegalColumnException {
        int emptyRow = 0;
        if (col > 6 || col < 0)
            throw new IllegalColumnException(col);
        if (this.isColumnFull(col))
            throw new ColumnFullException(col);
        while (myGrid[emptyRow][col] != EMPTY) {
            emptyRow++;
        }
        myGrid[emptyRow][col] = this.whoseTurn();
        if (this.whoseTurn() == RED)
            currentTurn = YELLOW;
        else
            currentTurn = RED;

    }

    /**
     * Returns whose turn is it
     * 
     * @return the constant RED if it is red's turn, else YELLOW
     */
    public int whoseTurn() {
        if (currentTurn == RED)
            return RED;
        else
            return YELLOW;
    }

    /**
     * Returns a constant denoting the status of the slot at the position
     * denoted by the col and row parameters
     * 
     * @param col
     *            the column of the position being queried (in the range 0-6)
     * @param row
     *            the row of the position being queried (in the range 0-5)
     * @return the EMPTY constant if the slot is empty, the RED constant if the
     *         slot is filled by a red counter, the YELLOW constant if is yellow
     * @throws IllegalColumnException
     *             if col is not in the range 0-6 (i.e. an invalid column)
     * @throws IllegalRowException
     *             if col is not in the range 0-5 (i.e. an invalid row)
     */
    public int getCounterAt(int col, int row) throws IllegalColumnException, IllegalRowException {
        if (col > 6 || col < 0)
            throw new IllegalColumnException(col);
        if (row > 5 || row < 0)
            throw new IllegalRowException(row);
        if (myGrid[row][col] == RED)
            return RED;
        else if (myGrid[row][col] == YELLOW)
            return YELLOW;
        else
            return EMPTY;
    }

    /**
     * Returns whether the board is full and the game has ended in a tie
     * 
     * @return true if the board is full, else false
     */

    public boolean isBoardFull() {
        for (int i = 0; i < myGrid.length; i++) {
            for (int j = 0; j < myGrid[0].length; j++) {
                if (myGrid[i][j] == EMPTY)
                    return false;
            }
        }
        return true;

    }

    /**
     * Returns whether the column denoted by the col parameter is full or not
     * 
     * @param col
     *            the column being queried (in the range 0-6)
     * @return true if the column denoted by col is full of counters, else false
     * @throws IllegalColumnException
     *             if col is not in the range 0-6 (i.e. an invalid column)
     */

    public boolean isColumnFull(int col) throws IllegalColumnException {
        if (col > 6 || col < 0)
            throw new IllegalColumnException(col);
        for (int i = myGrid.length - 1; i >= 0; i--) {
            if (myGrid[i][col] == EMPTY)
                return false;
        }
        return true;
    }

    /**
     * Indicates whether the game has been won, and by whom
     * 
     * @return the constant EMPTY if there is no winner yet, else the constant
     *         RED if the red player has four in a row, or the YELLOW constant
     *         if it is yellow that has won
     */

    public int getWinner() {
        // Check winner in rows
        for (int i = 0; i < myGrid.length; i++) {
            for (int j = 0; j < myGrid[0].length - 3; j++) {
                if ((myGrid[i][j] == RED) && (myGrid[i][j + 1] == RED) && (myGrid[i][j + 2] == RED)
                        && (myGrid[i][j + 3] == RED))
                    return RED;
                if ((myGrid[i][j] == YELLOW) && (myGrid[i][j + 1] == YELLOW) && (myGrid[i][j + 2] == YELLOW)
                        && (myGrid[i][j + 3] == YELLOW))
                    return YELLOW;
            }
        }
        // Check winner in columns

        for (int i = 0; i < myGrid[0].length - 1; i++) {
            for (int j = 0; j < myGrid.length - 3; j++) {
                if ((myGrid[j][i] == RED) && (myGrid[j + 1][i] == RED) && (myGrid[j + 2][i] == RED)
                        && (myGrid[j + 3][i] == RED))
                    return RED;
                if ((myGrid[j][i] == YELLOW) && (myGrid[j + 1][i] == YELLOW) && (myGrid[j + 2][i] == YELLOW)
                        && (myGrid[j + 3][i] == YELLOW))
                    return YELLOW;
            }
        }

        // Get winner diagonally \
        for (int i = 0; i < 3; i++) {
            for (int j = 6; j > 2; j--) {
                if ((myGrid[i][j] == RED) && (myGrid[i + 1][j - 1] == RED) && (myGrid[i + 2][j - 2] == RED)
                        && (myGrid[i + 3][j - 3] == RED)) {
                    return RED;
                } else if ((myGrid[i][j] == YELLOW) && (myGrid[i + 1][j - 1] == YELLOW)
                        && (myGrid[i + 2][j - 2] == YELLOW) && (myGrid[i + 3][j - 3] == YELLOW)) {
                    return YELLOW;
                }
            }
        }

        // Check winner diagonally /
        for (int i = 5; i > 2; i--) {
            for (int j = 6; j > 2; j--) {
                if ((myGrid[i][j] == RED) && (myGrid[i - 1][j - 1] == RED) && (myGrid[i - 2][j - 2] == RED)
                        && (myGrid[i - 3][j - 3] == RED)) {
                    return RED;
                } else if ((myGrid[i][j] == YELLOW) && (myGrid[i - 1][j - 1] == YELLOW)
                        && (myGrid[i - 2][j - 2] == YELLOW) && (myGrid[i - 3][j - 3] == YELLOW)) {
                    return YELLOW;
                }
            }
        }
        // If no winner is found return EMPTY
        return EMPTY;

    }

    /**
     * Indicates whether the current game has finished
     * 
     * @return true if there is a winner or the board is full
     */

    public boolean gameOver() {
        if (this.getWinner() != EMPTY)
            return true;
        else if (this.isBoardFull())
            return true;
        else
            return false;
    }

    /**
     * Copies the current Connect4GameState instance into another object
     * 
     * @return the new Connect4GameState instance
     */
    public Connect4GameState copy() {
        // Creating a deep copy of the current MyGameState
        // and returning that copy of the new MyGameState
        int newCurrentTurn = this.currentTurn;
        int[][] copy = new int[NUM_ROWS][NUM_COLS];
        for (int i = 0; i < myGrid.length; i++) {
            for (int j = 0; j < myGrid[0].length; j++) {
                copy[i][j] = this.myGrid[i][j];
            }
        }
        MyGameState newGameState = new MyGameState();
        newGameState.currentTurn = newCurrentTurn;
        newGameState.myGrid = copy;
        return newGameState;
    }

}
