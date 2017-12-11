package controller;

import entity.Building;
import dao.BuildingDao;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class BuildingController {
    @FXML
    private TextField name;
    @FXML
    private TextField floorsNum;

    public void createBuilding() {

        String nameBuilding = name.getText();
        int floorsNumber = Integer.parseInt(floorsNum.getText());

        Building building = new Building(nameBuilding, floorsNumber);
        BuildingDao buildingDao = new BuildingDao();
        buildingDao.addBuilding(building);
    }

}