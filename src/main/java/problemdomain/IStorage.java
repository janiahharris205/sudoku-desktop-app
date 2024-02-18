package problemdomain;

/**
 *
 * @author JaNiah Harris
*
* */

import java.io.IOException;

/**
 *
 * @author janiahharris
 */
public interface IStorage {
    void updateGameData(SudokuGame game) throws IOException;
    SudokuGame getGameData() throws IOException;
}
