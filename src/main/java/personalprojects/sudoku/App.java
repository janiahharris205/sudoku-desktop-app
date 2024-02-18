package personalprojects.sudoku;

import java.io.IOException;

import buildLogic.SudokuBuildLogic;
import javafx.application.Application;
import javafx.stage.Stage;
import userInterface.IUserInterfaceContract;
import userInterface.UserInterfaceImpl;

/**
 * @author JaNiah Harris
 * Email: janiah.harris205@gmail.com
 * Last updated: February 18, 2024 
 * Description: The Program is a Sudoku desktop application
 */
public class App extends Application {
    
    private IUserInterfaceContract.View uiImpl;
    
    @Override
    public void start(@SuppressWarnings("exports") Stage primaryStage) throws IOException {
        //Get SudokuGame object for a new game
        uiImpl = new UserInterfaceImpl(primaryStage);

        try {
            SudokuBuildLogic.build(uiImpl);
        } catch (IOException e) {
            throw e;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}