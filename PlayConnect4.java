package assignment2017;

import assignment2017.interfaces.ColumnFullException;
import assignment2017.interfaces.Connect4GameState;
import assignment2017.interfaces.IllegalColumnException;
import assignment2017.interfaces.IllegalRowException;
import assignment2017.interfaces.Connect4Player;
import assignment2017.interfaces.Connect4Displayable;

import static assignment2017.interfaces.Connect4GameState.*;

/**
 * Creating a new instance of MyGameState Creating a new instance of
 * RandomPlayer Creating a new instance of KeyboardPlayer Creating a new
 * instance of Connect4ConsoleDisplay and passing it the current gameState
 * Creating a new instance of Connect4 and passing it the current gameState, the
 * instance of RandomPlayer, the instance of KeyboardPlayer and the class that
 * has the method which generates the menu Calling the method play() from
 * Connect4 class, this method controls the flow of the game
 * 
 * @author mares
 *
 */
public class PlayConnect4 {

    public static void main(String[] args) {
        Connect4GameState gameState = new MyGameState();
        Connect4Player red = new RandomPlayer();
        Connect4Player yellow = new KeyboardPlayer();
        Connect4ConsoleDisplay display = new Connect4ConsoleDisplay(gameState);
        Connect4 game = new Connect4(gameState, red, yellow, display);
        game.play();
    }

}
