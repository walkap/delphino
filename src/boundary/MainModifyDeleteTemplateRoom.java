package boundary;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainModifyDeleteTemplateRoom extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("ModifyDeleteTemplateRoom.fxml"));
        primaryStage.setTitle("Modifica o Elimina Modello Stanza");
        primaryStage.setScene(new Scene(root, 800, 500));
        primaryStage.show();

    }
    public static void main(String[] args) {
        launch(args);
    }
}
