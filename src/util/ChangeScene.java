package util;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ChangeScene {

    public static void changeScene(Application application, Scene scene) {
        try {
            application.start(new Stage());
            Stage stage = (Stage) scene.getWindow();
            stage.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
