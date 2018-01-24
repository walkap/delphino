package boundary.managementFeature;

import boundary.managementFeature.createFeature.MainCreateFeature;
import boundary.managementFeature.viewModifyDeleteFeature.MainViewModifyDeleteFeature;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import main.Main;

public class ManagementFeatureUI {

    @FXML
    private Button exitBtn;
    @FXML
    private Button homePageBtn;
    @FXML
    private Button createFBtn;
    @FXML
    private Button modifyDBtn;

    public void mainPrev(){
        Main M = new Main();
        try {
            M.start(new Stage());
            Stage stage = (Stage) homePageBtn.getScene().getWindow();
            stage.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void createFeatureScene(){
        MainCreateFeature M = new MainCreateFeature();
        try {
            M.start(new Stage());
            Stage stage = (Stage) createFBtn.getScene().getWindow();
            stage.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void modifyDeleteFeatureScene(){
        MainViewModifyDeleteFeature M = new MainViewModifyDeleteFeature();
        try {
            M.start(new Stage());
            Stage stage = (Stage) modifyDBtn.getScene().getWindow();
            stage.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void closeWindow(){
        try {
            Stage stage = (Stage) exitBtn.getScene().getWindow();
            stage.close();

        }catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

}
