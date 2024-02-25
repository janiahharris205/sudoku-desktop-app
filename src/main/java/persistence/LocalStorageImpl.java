package persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import problemdomain.SudokuGame;
import problemdomain.IStorage;

/**
 *
 * @author JaNiah Harris
 * provides functionality for storing and retrieving Sudoku game data locally on the user's system
 */
public class LocalStorageImpl implements IStorage {

    private final File GAME_DATA;
    
    public LocalStorageImpl(String fileName) {
        this.GAME_DATA = new File(
                System.getProperty("user.home"),
                fileName + ".txt" // Adjusted the file name
        );
    }
//    public LocalStorageImpl() {
//    
//    private static File GAME_DATA = new File(
//            System.getProperty("user.home"),
//            "gamedata.txt"
//    );

    //overrides the method from the IStorage interface to update the game data. 
    //it writes the provided SudokuGame object to the GAME_DATA file using object serialization
    @Override
    public void updateGameData(SudokuGame game) throws IOException {
        try {
            FileOutputStream fileOutputStream =
                    new FileOutputStream(GAME_DATA);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(game);
            objectOutputStream.close();
        } catch (IOException e) {
            throw new IOException("Unable to access Game Data");
        }
    }

    //overrides the method from the IStorage interface to retrieve the game data
    @Override
    public SudokuGame getGameData() throws IOException {
        try {
            FileInputStream fileInputStream =
                    new FileInputStream(GAME_DATA);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            SudokuGame gameState = (SudokuGame) objectInputStream.readObject();
            objectInputStream.close();
            return gameState;
        } catch (ClassNotFoundException | IOException e) {
            throw new IOException("File Not Found");
        }
    }
}
