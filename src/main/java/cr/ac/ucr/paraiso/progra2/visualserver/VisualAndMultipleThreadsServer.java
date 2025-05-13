package cr.ac.ucr.paraiso.progra2.visualserver;

import cr.ac.ucr.paraiso.progra2.sockets.sevidormultihilo.KKMultiServidorHilo;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.collections.ListChangeListener;

import java.io.IOException;
import java.net.ServerSocket;

public class VisualAndMultipleThreadsServer extends Application {
    private Label statusLabel;
    private TextArea taStatus;
    @Override
    public void start(Stage primaryStage) {
        System.out.println(Thread.currentThread().toString());
        Pane pane = new Pane(); //container for shapes
        RectangleMaker rectangleMaker = new RectangleMaker(); //make new shapes on other thread
        rectangleMaker.getShapes().addListener(
                (ListChangeListener<Shape>) change -> {
                    //respond to shapes added
                    while (change.next()) {
                        //if items are removed
                        for (Shape s : change.getRemoved()) {
                            Platform.runLater(()->  pane.getChildren().remove(s));
                        }
                        //if items are added
                        for (Shape s : change.getAddedSubList()) {
                            //It is used Platform.runLater because statusLabel is a JavaFX UI component,
                            // and all UI updates must happen on the JavaFX Application Thread.
                            Platform.runLater(()-> pane.getChildren().add(s));
                        }
                    }
                });

        this.statusLabel = new Label("Servidor activo");
        this.taStatus = new TextArea("Servidor activo");
        VBox vBox = new VBox(10);
        vBox.getChildren().addAll(taStatus,pane);
        Scene scene = new Scene(vBox,600,600);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Aplicación con múltiples hilos");
        primaryStage.show();
        primaryStage.sizeToScene();
        rectangleMaker.begin(); //start making new rectangles
        serverSocketStart();
        taStatus.setEditable(false);
    }
    private void serverSocketStart(){

        Task<Void> backgroundTask = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                boolean escuchando = true;

                try {
                    ServerSocket serverSocket = new ServerSocket(9999);
                    System.out.println("Servidor activo");
                    while(escuchando){
                        System.out.println(Thread.currentThread().toString());
                        KKMultiServidorHilo hilo = new KKMultiServidorHilo(serverSocket.accept());
                        hilo.start();
                        // It is used Platform.runLater because statusLabel is a JavaFX UI component, and all UI updates must happen on the JavaFX Application Thread.
                        Platform.runLater(() ->
                                taStatus.appendText("\n" + hilo.toString()));
                    }
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.exit(-1);
                }
                return null;
            }
        };
        new Thread(backgroundTask).start();
    }//severStart
    public static void main(String[] args) {
        launch(args);


    }
}//VisualAndMultipleThreadsServer

