package boundary;

import javafx.fxml.FXML;

import java.awt.*;

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
    private Checkbox desk;

    // EXAMPLE TO USE
    //    public void createBuilding() {
    //
    //        String nameBuilding = name.getText();
    //        int floorsNumber = Integer.parseInt(floorsNum.getText());
    //
    //        Building building = new Building(nameBuilding, floorsNumber);
    //        BuildingDao buildingDao = new BuildingDao();
    //        buildingDao.addBuilding(building);
    //    }



}
