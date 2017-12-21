package boundary.managementTemplateRoom.createAndViewTemplateRoomJAVA;

import boundary.managementTemplateRoom.MainManagementTemplateRoom;
import controller.ReaderDataController;
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

public class CreateAndViewTemplateRoomJAVAUI {

    @FXML
    private Button exitBtn;
    @FXML
    private Button homePageBtn;
    @FXML
    private Button prevPageBtn;
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
    private ListView<String> listView;

    private static ReaderDataController rDC = new ReaderDataController();
    private static TemplateRoom tr = null;

    public void createTemplateRoom() {
        String nameT = name.getText();
        int seatsT = Integer.parseInt(seats.getText());
        String boardsT = board.getText();
        int projectorsT = Integer.parseInt(projectors.getText());
        int computersT = Integer.parseInt(computers.getText());
        Boolean deskT = desk.isSelected();
        TemplateRoom tr = new TemplateRoom(nameT, seatsT,
                boardsT, projectorsT, computersT, deskT);

        if (!nameT.isEmpty()) {
            if(controller.WriterDataController.writeTemplateRoom(tr))            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle(null);
                alert.setHeaderText(null);
                alert.setContentText("The Template " + nameT + " has been created");
                alert.showAndWait();
            }else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle(null);
                alert.setHeaderText(null);
                alert.setContentText("The Template '" + nameT + "' is present yet");
                alert.showAndWait();}
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText("Name can't be null");
            alert.showAndWait();
        }
    }


    private ArrayList<String> createListOfName() {

        ArrayList<String> array = new ArrayList<>();
        int i = 0;
        Vector vec = rDC.getAllTemplateRoom();
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

    public void clearInputFields(){

        name.setText("");
        seats.setText("0");
        projectors.setText("0");
        computers.setText("0");
        board.setText("Noboard");
        desk.setSelected(false);

    }

    public void managementTemplateRoomScene() throws Exception {
        MainManagementTemplateRoom M = new MainManagementTemplateRoom();
        try {
            M.start(new Stage());
            Stage stage = (Stage) prevPageBtn.getScene().getWindow();
            stage.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mainTemplateRoomScene() throws Exception {
        Main M = new Main();
        try {
            M.start(new Stage());
            Stage stage = (Stage) homePageBtn.getScene().getWindow();
            stage.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initialize() {

        seats.setText("0");
        projectors.setText("0");
        computers.setText("0");
        board.setText("Noboard");
        desk.setSelected(false);
        CreateAndViewTemplateRoomJAVAUI dTO = new CreateAndViewTemplateRoomJAVAUI();
        ObservableList<String> values = FXCollections.observableArrayList(dTO.createListOfName());
        listView.setItems(values);

    }


    public void closeWindow(){

        Stage stage = (Stage) exitBtn.getScene().getWindow();
        stage.close();
    }

    public void chooseTemplateRoomAndFillTV(){

        listView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                List<String> list = listView.getSelectionModel().getSelectedItems();
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
}

