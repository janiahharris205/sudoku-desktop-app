module personalprojects.sudoku {
    requires javafx.controls;
    requires javafx.fxml;

    opens personalprojects.sudoku to javafx.fxml;
    exports personalprojects.sudoku;
}
