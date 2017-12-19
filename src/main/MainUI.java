package main;

import boundary.buildingBoundary.MainBuilding;
import boundary.managementTemplateRoom.MainManagementTemplateRoom;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class MainUI {

    @FXML
    private Button exitBtn;
    @FXML
    private Button managTRBtn;

    public void managementBuilding() throws Exception {
        MainBuilding M = new MainBuilding();
        try {
            M.start(new Stage());
            Stage stage = (Stage) managTRBtn.getScene().getWindow();
            stage.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void managementTemplateRoomScene() throws Exception {
        MainManagementTemplateRoom M = new MainManagementTemplateRoom();
        try {
            M.start(new Stage());
            Stage stage = (Stage) managTRBtn.getScene().getWindow();
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
