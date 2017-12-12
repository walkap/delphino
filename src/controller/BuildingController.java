package controller;

import entity.Building;
import dao.BuildingDao;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class BuildingController {
    @FXML
    private TextField name;
    @FXML
    private TextField area;

    public void createBuilding() {

        String nameBuilding = name.getText();
        String nameArea = area.getText();

        Building building = new Building(nameBuilding, nameArea);
        BuildingDao buildingDao = new BuildingDao();
        buildingDao.addBuilding(building);
    }

}