package boundary.TemplateRoom;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainCreateTemplateRoom extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("CreateTemplateRoom.fxml"));
        primaryStage.setTitle("Creazione Modello Stanza");
        primaryStage.setScene(new Scene(root, 600, 500));
        primaryStage.show();

    }
    public static void main(String[] args) {
        launch(args);
    }
}
