package dao;

import entity.Building;
import exception.BuildingException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BuildingDao extends AbstractDao {

    private static final String TABLE_NAME = "building";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_AREA = "area";

    private Boolean isBuildingPresent(String name, String area) {

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT from ")
                .append(TABLE_NAME)
                .append(" WHERE ")
                .append(COLUMN_NAME)
                .append(" = '")
                .append(name).append("'")
                .append(" AND ")
                .append(COLUMN_AREA)
                .append(" = '")
                .append(area).append("'");
        System.out.println(sql.toString());
        return this.isPresent(sql.toString());
    }


    public void addBuilding(Building building) throws BuildingException {

        if (!isBuildingPresent(building.getName(), building.getArea())) {
            StringBuilder sql = new StringBuilder();
            sql.append("insert into ").append(TABLE_NAME).append("(")
                    .append(COLUMN_NAME).append(", ")
                    .append(COLUMN_AREA).append(")")
                    .append(" values(")
                    .append("'").append(building.getName()).append("', ")
                    .append("'").append(building.getArea()).append("')");
            this.executeUpdate(sql.toString());
            System.out.println("The building has been added to the database");
        } else {
            System.out.println("It's already present a building named " + building.getName() + "in the database");
            throw new BuildingException();
        }
    }

    public ArrayList<String> getBuildingsFromArea(String area) {
        Statement s = null;
        DataSource ds = new DataSource();
        Connection c = ds.getConnection();
        ArrayList<String> list = new ArrayList<>();
        try {
            s = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT * FROM " + TABLE_NAME)
                    .append(" WHERE ")
                    .append(COLUMN_AREA)
                    .append(" = ")
                    .append("'")
                    .append(area)
                    .append("'");
            ResultSet rs = s.executeQuery(sql.toString());
            while (rs.next()) {
                String nameBuilding = rs.getString(COLUMN_NAME);
                list.add(nameBuilding);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Closing statement...");
            this.closeStatement(s);
            System.out.println("Closing connection...");
            ds.closeConnection(c);
        }
        return list;
    }


    public ArrayList<String> getRoomsFromBuilding(String area, String building) {
        Statement s = null;
        DataSource ds = new DataSource();
        Connection c = ds.getConnection();
        ArrayList<String> list = new ArrayList<>();
        try {
            s = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT * FROM room")
                    .append(" WHERE ")
                    .append("area")
                    .append(" = ")
                    .append("'")
                    .append(area)
                    .append("'")
                    .append(" AND ")
                    .append("building")
                    .append(" = ")
                    .append("'")
                    .append(building)
                    .append("'");
            ResultSet rs = s.executeQuery(sql.toString());
            while (rs.next()) {
                String nameRoom = rs.getString("name");
                list.add(nameRoom);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Closing statement...");
            this.closeStatement(s);
            System.out.println("Closing connection...");
            ds.closeConnection(c);
        }
        return list;
    }

    public void updateBuilding(Building oldBuilding, Building newBuilding) throws BuildingException {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE " + TABLE_NAME)
                .append(" SET ")
                .append(COLUMN_NAME).append(" = '").append(newBuilding.getName()).append("', ")
                .append(COLUMN_AREA).append(" = '").append(newBuilding.getArea()).append("'")
                .append(" WHERE ").append(COLUMN_NAME).append(" = '").append(oldBuilding.getName()).append("'")
                .append(" AND ").append(COLUMN_AREA).append(" = '").append(oldBuilding.getArea()).append("'");
        System.out.println(sql.toString());
        this.executeUpdate(sql.toString());
        System.out.println("The building has been updated!");

    }

    public void deleteBuilding(Building building) {

        if (isBuildingPresent(building.getName(), building.getArea())) {
            StringBuilder sql = new StringBuilder();
            sql.append("DELETE from ")
                    .append(TABLE_NAME)
                    .append(" WHERE ")
                    .append(COLUMN_NAME).append(" = '").append(building.getName()).append("'")
                    .append(" AND ").append(COLUMN_AREA).append(" = '").append(building.getArea())
                    .append("'");
            this.executeUpdate(sql.toString());
            System.out.println("The building has been deleted from the database!");
        } else {
            System.out.println("The building is not in the database");
        }
    }
}
