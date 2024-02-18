package buildLogic;

import computationLogic.GameLogic;
import java.io.IOException;
import persistence.LocalStorageImpl;
import problemdomain.IStorage;
import problemdomain.SudokuGame;
import userInterface.IUserInterfaceContract;
import userInterface.logic.ControlLogic;

/**
 *
 * @author JaNiah Harris
 */
public class SudokuBuildLogic {
    public static void build(IUserInterfaceContract.View userInterface) throws IOException {
        SudokuGame initialState;
        IStorage storage = new LocalStorageImpl("gamedata");

        try {
            //will throw if no game data is found in local storage

            initialState = storage.getGameData();
        } catch (IOException e) {

            initialState = GameLogic.getNewGame();
            //this method below will also throw an IOException
            //if we cannot update the game data. At this point
            //the application is considered unrecoverable
            storage.updateGameData(initialState);
        }
    

        IUserInterfaceContract.EventListener uiLogic = new ControlLogic(storage, userInterface);
        userInterface.setListener(uiLogic);
        userInterface.updateBoard(initialState);
    }
}

