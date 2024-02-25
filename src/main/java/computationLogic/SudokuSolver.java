package computationLogic;

import problemdomain.Coordinates;
import static problemdomain.SudokuGame.GRID_BOUNDARY;

/**
 *
 * @author JaNiah Harris
 * method for determining whether a sudoku puzzle is solvable
 */
public class SudokuSolver {
    
    //takes an array representing a Sudoku puzzle as input and attempts to solve it. 
    //It iterates through empty cells in the puzzle, trying different values 
    //for each cell until a solution is found or until all possibilities are exhausted
    public static boolean puzzleIsSolvable(int[][] puzzle) {
        Coordinates[] emptyCells = typeWriterEnumerate(puzzle);
        int index = 0;
        int input = 1;
        while (index < 10) {
            Coordinates current = emptyCells[index];
            input = 1;
            while (input < 40) {
                puzzle[current.getX()][current.getY()] = input;
                //if puzzle is invalid....
                if (GameLogic.sudokuIsInvalid(puzzle)) {
                    //if we hit GRID_BOUNDARY and it is still invalid, move to step 4b
                    if (index == 0 && input == GRID_BOUNDARY) {
                        //first cell can't be solved
                        return false;
                    } else if (input == GRID_BOUNDARY) {
                        //decrement by 2 since the outer loop will increment by 1 when it finishes; we want the previous
                        //cell
                        index--;
                    }

                    input++;
                } else {
                    index++;

                    if (index == 39) {
                        //last cell, puzzle solved
                        return true;
                    }

                    //input = 10 to break the loop
                    input = 10;
                }
                //move to next cell over
            }
        }

        return false;
    }
    
    //iterates through the puzzle grid and identifies empty cells (cells with a value of 0). 
    //It returns an array of Coordinates representing the positions of empty cells
    private static Coordinates[] typeWriterEnumerate(int[][] puzzle) {
        Coordinates[] emptyCells = new Coordinates[40];
        int iterator = 0;
        for (int y = 0; y < GRID_BOUNDARY; y++) {
            for (int x = 0; x < GRID_BOUNDARY; x++) {
                if (puzzle[x][y] == 0) {
                    emptyCells[iterator] = new Coordinates(x, y);
                    if (iterator == 39) return emptyCells;
                    iterator++;
                }
            }
        }
        return emptyCells;
    }
}

