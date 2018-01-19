package boundary.managementFeature.createFeature;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class MainCreateFeature extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("CreatureFeature.fxml"));
        primaryStage.setTitle("Creazione Feature");
        primaryStage.setScene(new Scene(root, 700, 400));
        primaryStage.show();

    }
    public static void main(String[] args) {
        launch(args);
    }
}
