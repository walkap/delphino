package boundary.templateRoom.createTemplateRoom;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.fxml.FXML;

import javafx.scene.control.TextField;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;


/**
 * https://stackoverflow.com/questions/26962788/fxmlloader-how-to-access-the-components-by-fxid
 * https://stackoverflow.com/questions/33881046/how-to-connect-fx-controller-with-main-app
 * https://docs.oracle.com/javafx/2/get_started/fxml_tutorial.htm
 * http://code.makery.ch/library/javafx-8-tutorial/it/part1/
 * https://examples.javacodegeeks.com/desktop-java/javafx/fxml/javafx-fxml-controller-example/
 * https://blog.idrsolutions.com/2015/05/how-to-create-a-javafx-gui-using-scene-builder-in-netbeans/
 * http://javajdk.net/tutorial/javafx-button-example/
 *
 * https://www.jetbrains.com/help/idea/javafx.html
 */

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

    public void initialize(){
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


    /**
     * clearInputFields is activated with onAction of Cancel Button
     */

    public void clearInputFields(){
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

    public void controlInputEmpty(){
    }

    /**
     * createTemplateRoom is activated with onAction of Confirm Button
     */

    public void createTemplateRoom(){
        String nameT = name.getText();
        int seatsT = Integer.parseInt(seats.getText());
        String boardsT = board.getText();
        int projectorsT = Integer.parseInt(projectors.getText());
        int computersT = Integer.parseInt(computers.getText());
        Boolean deskT = desk.isSelected();

        if(!nameT.isEmpty()) {
            if (controller.TemplateRoomController.createTemplateRoom(nameT, seatsT,
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
        }else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText("Name can't be null");
            alert.showAndWait();
        }

    }

    public void closeWindow(){

        Stage stage = (Stage) quitBtn.getScene().getWindow();
        stage.close();
    }





}
