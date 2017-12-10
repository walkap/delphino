package controller.roomController;

import javafx.fxml.FXML;

import java.awt.*;

public class TemplateClassRoomController {

    @FXML
    private TextField name;
    @FXML
    private TextField seats;
    @FXML
    private TextField board;
    @FXML
    private TextField projector;
    @FXML
    private Checkbox desk;

    public void createClassRoom() {

        String nameClassRoom = name.getText();
        int sts = Integer.parseInt(seats.getText());
        String brd = board.getText();
        String prctr = projector.getText();
    }
}
