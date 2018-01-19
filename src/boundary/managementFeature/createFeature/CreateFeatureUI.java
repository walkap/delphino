package boundary.managementFeature.createFeature;

import boundary.managementFeature.MainManagementFeature;
import boundary.managementTemplateRoom.MainManagementTemplateRoom;
import control.FeatureController;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.Main;

public class CreateFeatureUI {

    @FXML
    private TextField nameF;
    @FXML
    private TextField description;
    @FXML
    private Button previousPageBtn;
    @FXML
    private Button homePageBtn;
    @FXML
    private Button exitBtn;

    private FeatureController fC = new FeatureController();


    /**
     * This method use a button for return Management Feature window;
     *
     */
    public void managementFeatureScene(){
        MainManagementFeature M = new MainManagementFeature();
        try {
            M.start(new Stage());
            Stage stage = (Stage) previousPageBtn.getScene().getWindow();
            stage.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method use a button for return Home Page window;
     *
     */

    public void mainScene(){
        Main M = new Main();
        try {
            M.start(new Stage());
            Stage stage = (Stage) homePageBtn.getScene().getWindow();
            stage.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * clearInputFields is activated with onAction of Cancel Button
     */

    public void clearInputFields() {

        nameF.setText("");
        description.setText("");
    }

    /**
     * createFeature is activated with onAction of Confirm Button
     */

    public void createFeatureBtn(){
        String nameFe = nameF.getText();
        String descF = description.getText();

        if (!nameFe.isEmpty() && !descF.isEmpty()) {
                fC.createFeature(nameFe, descF) ;
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle(null);
                alert.setHeaderText(null);
                alert.setContentText("The Feature " + nameFe + " has been created");
                alert.showAndWait();

        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText("Name and description can't be null");
            alert.showAndWait();
        }
    }


        /**
         * This method is activated by Button;
         */

        public void closeWindow () {

            Stage stage = (Stage) exitBtn.getScene().getWindow();
            stage.close();
        }

        public void initialize () {
            nameF.setText("");
            description.setText("");
        }

    }
