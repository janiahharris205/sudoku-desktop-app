package problemdomain;

/**
 *
 * @author JaNiah Harris
*
* */

import java.io.IOException;

/**
 *
 * @author JaNiah Harris
 * defines the contract for classes responsible for storing and retrieving game data in the application
 */
public interface IStorage {
    void updateGameData(SudokuGame game) throws IOException;
    SudokuGame getGameData() throws IOException;
}
