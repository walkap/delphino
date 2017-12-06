package dao;

import Entity.Building;

import java.sql.*;

public class BuildingDao {

    private Connection connection;


    public void addBuilding(Building building) {

        Statement stmt = null;
        DataSource src = new DataSource();
        connection = src.getConnection();
        try {
            stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            String sql = "insert into  Buildings(name, numberFloors) values ('" + building.getName() +
                    "'," + building.getNumbersOfFloors() + ")";
            stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.getMessage();
        }
        finally {

            try {
                connection.close();
            } catch (SQLException e) {

                e.printStackTrace();
            }


        }
    }

    public static void main (String args[]) {
        Building building = new Building("Headbuilding", 10);
        BuildingDao buildingDao = new BuildingDao();
        buildingDao.addBuilding(building);
    }

}
