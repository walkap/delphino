package main;

import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("MainUI.fxml"));
        primaryStage.setTitle("Main");
        primaryStage.setScene(new Scene(root, 600, 500));
        primaryStage.show();

    }

    //Todo create a initial db if it is not exist, and populate with random items

    public static void main(String[] args) {
        launch(args);
    }
}
