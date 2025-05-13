package cr.ac.ucr.paraiso.progra2.javafxapp.controller;

import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class MainMenuController {

    public void exit(ActionEvent event) throws IOException {
        Platform.exit();
    }

    public void loadMcdPane(ActionEvent event) throws IOException {

        GridPane gridPane = (GridPane)
                FXMLLoader.load(getClass().getResource("/mcd.fxml"));
        // Set a margin of 10 pixels on the top and 20 pixels on the left
        gridPane.setPadding(new Insets(10, 0, 0, 20));
        // top, right, bottom, left
        BorderPane borderPane = MainApp.getRoot();
        borderPane.setCenter(gridPane);
    }
}
