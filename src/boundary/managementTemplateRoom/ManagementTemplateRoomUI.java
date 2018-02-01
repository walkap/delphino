package boundary.managementTemplateRoom;

import boundary.managementTemplateRoom.createTemplateRoom.MainCreateTemplateRoom;
import boundary.managementTemplateRoom.modifyDeleteTemplateRoom.MainModifyDeleteTemplateRoom;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import main.Main;
import static util.ChangeScene.changeScene;



public class ManagementTemplateRoomUI {

    @FXML
    private Button modifyTemplateRoomBtn;
    @FXML
    private Button createTemplateRoomBtnBD;
    @FXML
    private Button exitBtn;
    @FXML
    private Button homePageBtn;

    public void createTemplateRoomScene(){
        MainCreateTemplateRoom C = new MainCreateTemplateRoom();
        try {
            C.start(new Stage());
            Stage stage = (Stage) createTemplateRoomBtnBD.getScene().getWindow();
            stage.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void mainPrev(){
        Main M = new Main();
        changeScene(M, homePageBtn.getScene());
    }

    public void modifyTemplateRoomScene(){
        MainModifyDeleteTemplateRoom M = new MainModifyDeleteTemplateRoom();
        changeScene(M, modifyTemplateRoomBtn.getScene());
    }

    public void closeWindow(){
        try {
            Stage stage = (Stage) exitBtn.getScene().getWindow();
            stage.close();

        }catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public void initialize(){

    }
}
