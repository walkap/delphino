package boundary;

import dao.TemplateRoomDao;
import entity.TemplateRoom;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;


public class ModifyDeleteTemplateRoomUI {

    @FXML
    private ListView<String> ListViewTemplateRooms;
    @FXML
    private Button quitBtn;
    @FXML
    private TextField name;
    @FXML
    private TextField seats;
    @FXML
    private TextField board;
    @FXML
    private TextField projectors;
    @FXML
    private TextField computers;
    @FXML
    private CheckBox desk;
    @FXML
    private Button modify;
    @FXML
    private Button delete;

    private static TemplateRoomDao tRD = new TemplateRoomDao();



    private ArrayList<String> createListOfName() {

        ArrayList<String> array = new ArrayList<>();
        int i = 0;
        Vector vec = tRD.getAllTemplateRoom();
        int l = vec.size();
        List list = null;
        while (i < l) {
            TemplateRoom tR = (TemplateRoom) vec.elementAt(i);
            String n = tR.getNameTemplate();
            i++;
            array.add(n);

        }
        System.out.println(array);
        return array;
    }

    public void chooseTemplateRoomAndFillTV(){


    }

    public void closeWindow(){

        Stage stage = (Stage) quitBtn.getScene().getWindow();
        stage.close();
    }

    public void deleteTemplateRoom(){
        String nameT = name.getText();
        if(!nameT.isEmpty()){
            controller.TemplateRoomController.deleteTemplateRoom(nameT);
            /* if(check res){

            }else{

            }*/
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error with name of Template");
            alert.setContentText("You don't choose any Template!");

            alert.showAndWait();
        }

    }


    public void initialize() {

        ModifyDeleteTemplateRoomUI dTO = new ModifyDeleteTemplateRoomUI();
        ObservableList<String> values = FXCollections.observableArrayList(dTO.createListOfName());
        ListViewTemplateRooms.setItems(values);

    }
}
