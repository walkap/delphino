package controller;

import dao.BuildingDao;
import entity.Building;

public class BuildingController {

    public void createNewBuilding(String name, String area) {

        BuildingDao buildingDao = new BuildingDao();
        buildingDao.addBuilding(new Building(name, area));


    }

    public void modifyBuilding(String oldName, String oldArea, String newName, String newArea) {

        Building oldBuilding = new Building(oldName, oldArea);
        Building newBuilding = new Building(newName, newArea);

        BuildingDao buildingDao = new BuildingDao();
        buildingDao.updateBuilding(oldBuilding, newBuilding);
    }

    public void deleteBuilding(String name, String area) {

        Building building = new Building(name, area);

        BuildingDao buildingDao = new BuildingDao();
        buildingDao.deleteBuilding(building);


    }

}