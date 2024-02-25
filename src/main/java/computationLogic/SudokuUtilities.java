package computationLogic;

import problemdomain.SudokuGame;
import static problemdomain.SudokuGame.GRID_BOUNDARY;

/**
 *
 * @author JaNiah Harris
 * provides utility methods for working with sudoku arrays
 */
public class SudokuUtilities {
    
    //copies the values from one array (oldArray) to another (newArray). 
    //It uses System.arraycopy to efficiently copy the contents of each row from 
    //oldArray to the corresponding row in newArray
    public static void copySudokuArrayValues(int[][] oldArray, int[][] newArray) {
        for (int xIndex = 0; xIndex < SudokuGame.GRID_BOUNDARY; xIndex++){
            System.arraycopy(oldArray[xIndex], 0, newArray[xIndex], 0, SudokuGame.GRID_BOUNDARY);
        }
    }

    /**
     * Creates and returns a new Array with the same values as the inputted Array.
     *
     * @param oldArray
     * @return 
     */
    public static int[][] copyToNewArray(int[][] oldArray) {
        int[][] newArray = new int[SudokuGame.GRID_BOUNDARY][SudokuGame.GRID_BOUNDARY];
        for (int xIndex = 0; xIndex < SudokuGame.GRID_BOUNDARY; xIndex++){
            System.arraycopy(oldArray[xIndex], 0, newArray[xIndex], 0, SudokuGame.GRID_BOUNDARY);
        }

        return newArray;
    }
}

