package boundary.managementTemplateRoom.modifyDeleteTemplateRoom;

import controller.TemplateRoomController;
import dao.TemplateRoomDao;
import entity.TemplateRoom;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import main.Main;

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
    private Button startBtn;
    @FXML
    private Button modify;
    @FXML
    private Button delete;

    private static TemplateRoomDao tRD = new TemplateRoomDao();
    private static TemplateRoom tr = null;



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

    public void setText(TextField textField, String text) {
        textField.setText(text);
    }


    public void chooseTemplateRoomAndFillTV(){

        ListViewTemplateRooms.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                List<String> list = ListViewTemplateRooms.getSelectionModel().getSelectedItems();
                String item = list.get(0);
                tr = controller.TemplateRoomController.getTemplateRoom(item);
                name.setText(tr.getNameTemplate());
                seats.setText(Integer.toString(tr.getSeats()));
                board.setText(tr.getBoard());
                projectors.setText(Integer.toString(tr.getProjectors()));
                computers.setText(Integer.toString(tr.getComputers()));
                desk.setSelected(tr.getDesk());

            }
        });

    }

    public void clearInputFields(){
        /*name.setText("Name");
        seats.setText("000");
        board.setText("Board");
        projectors.setText("0");
        computers.setText("0");
        desk.setSelected(false);
        */
        name.setText("");
        seats.setText("0");
        projectors.setText("0");
        computers.setText("0");
        board.setText("No board");
        desk.setSelected(false);

    }


    public void modifyTemplateRoom(){
        String nTR = name.getText();
        int sTR = Integer.parseInt(seats.getText());
        String bTR = board.getText();
        int pTR = Integer.parseInt(projectors.getText());
        int cTR = Integer.parseInt(computers.getText());
        Boolean dTR = desk.isSelected();

        System.out.println(nTR);

        if (!nTR.isEmpty()){
            TemplateRoom tr = new TemplateRoom(nTR, sTR, bTR, pTR, cTR, dTR);
            int res = TemplateRoomController.modifyTemplateRoom(tr);
            if(res == 2){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle(null);
                alert.setHeaderText(null);
                alert.setContentText("The Template Room has been update");
                alert.showAndWait();
                System.out.println(res);

            }else{
                if (res == 0) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle(null);
                    alert.setHeaderText(null);
                    alert.setContentText("Changes at least a value for modify the Template Room");
                    alert.showAndWait();
                    System.out.println(res);

                } else if (res == 1){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle(null);
                    alert.setHeaderText(null);
                    alert.setContentText("Error in db");
                    alert.showAndWait();
                    System.out.println(res);

                }
            }
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText("Error with name of Template");
            alert.setContentText("You don't choose any Template!");
            alert.showAndWait();
        }
    }


    public void closeWindow(){

        Stage stage = (Stage) quitBtn.getScene().getWindow();
        stage.close();
    }

    public void deleteTemplateRoom(){
        String nameT = name.getText();

        if(!nameT.isEmpty()){
            controller.TemplateRoomController.deleteTemplateRoom(nameT);
            if(tRD.getRes() == 0){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle(null);
                alert.setHeaderText(null);
                alert.setContentText("The template of room '"
                        + nameT + "' has been deleted from database");
                alert.showAndWait();
                ListViewTemplateRooms.getItems().remove(nameT);

            }else if(tRD.getRes() == 1){
                System.out.println("We are sorry, the template of room you wanted to delete it doesn't exist");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle(null);
                alert.setHeaderText(null);
                alert.setContentText("We are sorry, the template of room '"
                        + nameT + "' you wanted to delete it doesn't exist");
                alert.showAndWait();

            }
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error with name of Template");
            alert.setContentText("You don't choose any Template!");
            alert.showAndWait();
        }
    }

    public void mainTemplateRoomScene() throws Exception {
        Main M = new Main();
        try {
            M.start(new Stage());
            Stage stage = (Stage) startBtn.getScene().getWindow();
            stage.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initialize() {

        seats.setText("0");
        projectors.setText("0");
        computers.setText("0");
        board.setText("No board");
        desk.setSelected(false);
        ModifyDeleteTemplateRoomUI dTO = new ModifyDeleteTemplateRoomUI();
        ObservableList<String> values = FXCollections.observableArrayList(dTO.createListOfName());
        ListViewTemplateRooms.setItems(values);

    }
}
