package userInterface.logic;

import computationLogic.GameLogic;
import constants.GameState;
import constants.Messages;
import java.io.IOException;
import problemdomain.IStorage;
import problemdomain.SudokuGame;
import userInterface.IUserInterfaceContract;

/**
 *
 * @author JaNiah Harris
 * controller component responsible for handling user inputs and updating the game state
 */
public class ControlLogic implements IUserInterfaceContract.EventListener{
    private IStorage storage;
    
    private IUserInterfaceContract.View view;
    
    public ControlLogic(IStorage storage, IUserInterfaceContract.View view) {
        this.storage = storage;
        this.view = view;
    }
    
    @Override
    public void onSudokuInput(int x, int y, int input) {
        try {
            SudokuGame gameData = storage.getGameData();
            int[][] newGridState = gameData.getCopyOfGridState();
            newGridState[x][y] = input;

            gameData = new SudokuGame(
                    GameLogic.checkForCompletion(newGridState),
                    newGridState
            );

            storage.updateGameData(gameData);

            //either way, update the view
            view.updateSquare(x, y, input);

            //if game is complete, show dialog
            if (gameData.getGameState() == GameState.COMPLETE) view.showDialog(Messages.GAME_COMPLETE);
        } catch (IOException e) {
            e.printStackTrace();
            view.showError(Messages.ERROR);
        }
    }

    @Override
    public void onDialogClick() {
        try {
            storage.updateGameData(
                    GameLogic.getNewGame()
            );

            view.updateBoard(storage.getGameData());
        } catch (IOException e) {
            view.showError(Messages.ERROR);
        }
    }
}

