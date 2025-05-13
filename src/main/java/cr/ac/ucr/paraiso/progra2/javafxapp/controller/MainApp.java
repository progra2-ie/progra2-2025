package cr.ac.ucr.paraiso.progra2.javafxapp.controller;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application {
    // Creating a static root to pass to the controller
    private static BorderPane root = new BorderPane();

    private static Socket socket = null;

    public static Socket createSocket() throws IOException{
        if (socket == null){
            //InetAddress inetAddress = InetAddress.getLocalHost();
            //socket = new Socket("10.235.12.58",9999);
            socket = new Socket("10.59.58.241",9999);
        }
        return socket;
    }

    public static Socket getSocket() {
        return socket;
    }

    public static BorderPane getRoot() {
        return root;
    }



    @Override
    public void start(Stage primaryStage) throws IOException {
        // load main form in to VBox (Root)
        MenuBar menuBar = (MenuBar)
                FXMLLoader.load(getClass().getResource("/main-menubar.fxml"));
        AnchorPane anchorPane = (AnchorPane) FXMLLoader.load(getClass().getResource("/main-pane.fxml"));
        // add main form into the scene
        root.setTop(menuBar);
        root.setCenter(anchorPane);
        Scene scene = new Scene(root, 640, 480);
        createSocket(); // método que crea el socket para el servidor

        primaryStage.setTitle("Múltiples formularios");
        primaryStage.setScene(scene);
        primaryStage.setMaximized(true);    // make the main form fit to the screen
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        launch(args);
    }

}
