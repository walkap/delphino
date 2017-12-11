package dao;

import entity.Building;
import entity.room.Room;

import java.sql.*;

public class RoomDao {

    private static final String TABLE_NAME = "room";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_TYPE = "type";
    private static final String COLUMN_BUILDING = "building";
    private static final String COLUMN_BOARD = "board";
    private static final String COLUMN_TEACHER_DESK = "teacher_desk";
    private static final String COLUMN_SEATS = "seats";
    private static final String COLUMN_PROJECTORS = "projectors";
    private static final String COLUMN_COMPUTERS = "computers";


    public void addRoom(String name, int building, String type, int seats, String boards, int projectors, int computers, Boolean desk) {
        Statement s = null;
        DataSource ds = new DataSource();
        Connection c = ds.getConnection();
        try {
            s = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            StringBuilder sql = new StringBuilder();

            sql.append("insert into " + TABLE_NAME + "(");

            sql.append(COLUMN_NAME).append(", ").append(COLUMN_TYPE).append(", ").append(COLUMN_BUILDING).append(")");

            sql.append(" values(");

            sql.append("'").append(name).append("', ");

            sql.append("'").append(type).append("', ");

            sql.append("'").append(building).append("')");

            System.out.println(sql.toString());
            s.executeUpdate(sql.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ds.closeConnection(c);
            try {
                if (s != null)
                    s.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * This method is used to delete {@code room} object
     * from database
     *
     * @param name - {@code String}
     */
    public void deleteRoom(String name) {
        Statement s = null;
        DataSource ds = new DataSource();
        Connection c = ds.getConnection();
        try {
            s = c.createStatement();
            StringBuilder sql = new StringBuilder();
            sql.append("DELETE from ").append(TABLE_NAME).append(" WHERE ").append(COLUMN_NAME).append(" = ").append(name);
            s.executeUpdate(sql.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ds.closeConnection(c);
            try {
                if (s != null)
                    s.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * This method checks if a room is present
     * in the database using the room's id as parameter
     * @param name - Room's name
     * @return Boolean
     */
    public Boolean isRoomPresent(String name){
        Boolean bool = false;
        Statement s = null;
        DataSource ds = new DataSource();
        Connection c = ds.getConnection();

        try{
            s = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT from ").append(TABLE_NAME).append(" WHERE ").append(COLUMN_NAME).append(" = ").append(name);
            ResultSet rs = s.executeQuery(sql.toString());
            if(!rs.first()){
                System.out.println("The room you're looking for is not present...");
            }else{
                bool = true;
                System.out.println("Yay! We found the room you're looking for...");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            System.out.println("Closing connection...");
            ds.closeConnection(c);
            try {
                if (s != null){
                    System.out.println("Closing statement...");
                    s.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return bool;
    }

    public static void main(String[] args) {

        RoomDao rd = new RoomDao();

        rd.addRoom("C4", 4, "ClassRoom", 0, null, 0, 0, null);

        //rd.deleteRoom(room);

        //rd.isRoomPresent(23);

    }

}
