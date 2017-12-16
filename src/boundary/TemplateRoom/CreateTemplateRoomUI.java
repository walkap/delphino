package boundary.TemplateRoom;

import javafx.scene.control.Button;
import javafx.fxml.FXML;

import javafx.scene.control.TextField;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;

import java.awt.*;


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


    /**
     * clearInputFields is activated with onAction of Cancel Button
     */

    public void clearInputFields(){
        name.clear();
        seats.clear();
        board.clear();
        board.clear();
        projectors.clear();
        desk.setSelected(false);
        computers.clear();

    }

    /**
     * createTemplateRoom is activated with onAction of Confirm Button
     */

    public void createTemplateRoom(){
        String nameT = name.getText();
        int seatsT = Integer.parseInt(seats.getText());
        String boarsT = board.getText();
        int projectorsT = Integer.parseInt(projectors.getText());
        int computersT = Integer.parseInt(computers.getText());
        Boolean deskT = desk.isSelected();

        controller.TemplateRoomController.createTemplateRoom(nameT, seatsT, boarsT, projectorsT, computersT, deskT);

    }

    public void closeWindow(){

        Stage stage = (Stage) quitBtn.getScene().getWindow();
        stage.close();
    }





}
