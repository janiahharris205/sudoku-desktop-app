package userInterface;

import problemdomain.SudokuGame;

/**
 *
 * @author JaNiah Harris
 * represents the event listener interface, which defines methods that handle 
 * user interactions or events within the Sudoku game interface
 */
public interface IUserInterfaceContract {
    interface EventListener {
        void onSudokuInput(int x, int y, int input);
        void onDialogClick();
    }
    interface View {
        void setListener(IUserInterfaceContract.EventListener listener);
        void updateSquare(int x, int y, int input);
        void updateBoard(SudokuGame game);
        void showDialog(String message);
        void showError(String message);
    }
}
