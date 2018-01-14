package main;

import boundary.IssueManagement.IssueMenuManagement.IssueMenu;
import boundary.buildingBoundary.MainBuilding;
import boundary.managementTemplateRoom.MainManagementTemplateRoom;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MainUI {

    @FXML
    private Button exitBtn;
    @FXML
    private Button managTRBtn;
    @FXML
    private Button mRoomButton;

    @FXML
    public void initialize() {

    }

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

    public void managementTemplateRoomScene(){
        MainManagementTemplateRoom M = new MainManagementTemplateRoom();
        try {
            M.start(new Stage());
            Stage stage = (Stage) managTRBtn.getScene().getWindow();
            stage.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void managementRoomButton() throws IOException {
        Parent root;
        Stage stage = (Stage) mRoomButton.getScene().getWindow();
        //Check which button has been clicked
        root = FXMLLoader.load(getClass().getResource("/activity/room_management_activity.fxml"));

        //Create and launch the scene
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void onIssueManagement(){

        IssueMenu M = new IssueMenu();
        try {
            M.start(new Stage());
            Stage stage = (Stage) managTRBtn.getScene().getWindow();
            stage.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void closeWindow() {
        try {
            Stage stage = (Stage) exitBtn.getScene().getWindow();
            stage.close();

        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}
