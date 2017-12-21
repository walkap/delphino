package boundary.managementTemplateRoom.createAndViewTemplateRoomJAVA;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class MainCreateAndViewTemplateRoomJAVA extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("CreateAndViewTemplateRoomJava.fxml"));
        primaryStage.setTitle("Creazione Modello Stanza in Java");
        primaryStage.setScene(new Scene(root, 800, 500));
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }

}
