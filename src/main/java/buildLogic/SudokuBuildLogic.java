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
 * This class contains a static method build responsible for initializing the Sudoku game logic and user interface.
 * It takes an instance of IUserInterfaceContract.View as a parameter. 
 * The method attempts to retrieve the game state from local storage using a LocalStorageImpl object. 
 * If no game data is found, it creates a new game state using GameLogic.getNewGame() method and stores it. 
 * After obtaining the initial game state, it initializes the game's event listener and updates the user 
 * interface with the initial game state. 
 * If any I/O exception occurs during this process, it is propagated, marking the application as unrecoverable
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

