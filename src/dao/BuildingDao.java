package dao;

import entity.Building;

import java.sql.*;

public class BuildingDao {

    public void addBuilding(Building building) {

        Statement s = null;
        DataSource ds = new DataSource();
        Connection c = ds.getConnection();
        try {
            s = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            String sql = "insert into  building(name, area) values ('" + building.getName() +
                    "','" + building.getArea() + "')";

            System.out.println(sql);

            s.executeQuery(sql);
        } catch (SQLException e) {
            e.getMessage();
        }
        finally {
            ds.closeConnection(c);
            try {
                if (s != null)
                    s.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main (String args[]) {
        Building building = new Building("C", "Ingegneria");
        BuildingDao buildingDao = new BuildingDao();
        buildingDao.addBuilding(building);
    }

}
