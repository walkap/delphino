package boundary.managementTemplateRoom.createTemplateRoom;

import boundary.managementTemplateRoom.MainManagementTemplateRoom;
import control.TemplateRoomController;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.fxml.FXML;

import javafx.scene.control.TextField;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;
import main.Main;


public class CreateTemplateRoomUI {

    @FXML
    private TextField name;
    @FXML
    private TextField seats;
    @FXML
    private TextField board;
    @FXML
    private TextField projectors;
    @FXML
    private CheckBox desk;
    @FXML
    private TextField computers;
    @FXML
    private Button quitBtn;
    @FXML
    private Button startBtn;
    @FXML
    private Button prePageBtn;

    public void initialize() {
        /*
        name.setText("Name");
        board.setText("Board");
        projectors.setText("0");
        computers.setText("00");
        desk.setSelected(false);
        */
        seats.setText("0");
        projectors.setText("0");
        computers.setText("0");
        board.setText("No board");


    }

    private TemplateRoomController tRC = new TemplateRoomController();


    /**
     * This method use a button for return Management Template Room window;
     *
     */
    public void managementTemplateRoomScene(){
        MainManagementTemplateRoom M = new MainManagementTemplateRoom();
        try {
            M.start(new Stage());
            Stage stage = (Stage) prePageBtn.getScene().getWindow();
            stage.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method use a button for return Home Page window;
     *
     */

    public void mainTemplateRoomScene(){
        Main M = new Main();
        try {
            M.start(new Stage());
            Stage stage = (Stage) startBtn.getScene().getWindow();
            stage.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * clearInputFields is activated with onAction of Cancel Button
     */

    public void clearInputFields() {
        /*name.setText("Name");
        seats.setText("000");
        board.setText("Board");
        projectors.setText("0");
        computers.setText("00");
        desk.setSelected(false);
        */
        name.setText("");
        seats.setText("0");
        board.setText("No board");
        board.setText("");
        projectors.setText("0");
        computers.setText("0");
        desk.setSelected(false);
    }

    /**
     * createTemplateRoom is activated with onAction of Confirm Button
     */

    public void createTemplateRoom() {
        String nameT = name.getText();
        int seatsT = Integer.parseInt(seats.getText());
        String boardsT = board.getText();
        int projectorsT = Integer.parseInt(projectors.getText());
        int computersT = Integer.parseInt(computers.getText());
        Boolean deskT = desk.isSelected();

        if (!nameT.isEmpty()) {
            if (tRC.createTemplateRoom(nameT, seatsT,
                    boardsT, projectorsT, computersT, deskT)) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle(null);
                alert.setHeaderText(null);
                alert.setContentText("The Template " + nameT + " has been created");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle(null);
                alert.setHeaderText(null);
                alert.setContentText("The Template '" + nameT + "' is present yet");
                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText("Name can't be null");
            alert.showAndWait();
        }

    }

    /**
     * This method is activated by Button;
     *
     */

    public void closeWindow() {

        Stage stage = (Stage) quitBtn.getScene().getWindow();
        stage.close();
    }


}
