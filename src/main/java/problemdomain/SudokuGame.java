package problemdomain;

import computationLogic.SudokuUtilities;
import constants.GameState;
import java.io.Serializable;

/**
 *
 * @author JaNiah Harris
 * represents a sudoku game
 */
public class SudokuGame implements Serializable {
    private final GameState gameState; //inum that represents different states of a game
    private final int[][] gridState; //sudoku grid
    
    public static final int GRID_BOUNDARY = 9; //constant
    
    public SudokuGame(GameState gameState, int[][] gridState){
            this.gameState = gameState;
            this.gridState = gridState;
    }

    public GameState getGameState () {
        return gameState;
    }

    public int[][] getCopyOfGridState () {
        return SudokuUtilities.copyToNewArray(gridState);
    }
}

