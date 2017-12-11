package dao;

import entity.room.Room;

import java.sql.*;

public class RoomDao {

    private static final String TABLE_NAME = "room";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_BUILDING = "building";
    private static final String COLUMN_FLOOR = "floor";
    private static final String COLUMN_BOARD = "board";
    private static final String COLUMN_DESK = "desk";
    private static final String COLUMN_SEATS = "seats";
    private static final String COLUMN_PROJECTOR = "projector";
    private static final String COLUMN_COMPUTERS = "computers";

    /**
     * This mehthod is user to insert new {@code Room} object
     * to the database
     *
     * @param room - {@code Room}
     */
    public void addRoom(Room room) {
        Statement s = null;
        DataSource ds = new DataSource();
        Connection c = ds.getConnection();
        try {
            s = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            StringBuilder sql = new StringBuilder();
            sql.append("insert into ");
            sql.append(TABLE_NAME).append("(");
            sql.append(COLUMN_NAME).append(",").append(COLUMN_ID).append(")");
            sql.append(" values ").append(" (");
            sql.append("'").append(room.getName()).append("'").append(",");
            sql.append(room.getId()).append(")");

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
     * This method is uset to delete {@code room} object
     * from database
     *
     * @param id - {@code int}
     */
    public void deleteRoom(int id) {
        Statement s = null;
        DataSource ds = new DataSource();
        Connection c = ds.getConnection();
        try {
            s = c.createStatement();
            StringBuilder sql = new StringBuilder();
            sql.append("DELETE from ").append(TABLE_NAME).append(" WHERE ").append(COLUMN_ID).append(" = ").append(id);
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
     * @param id - Room's id
     * @return Boolean
     */
    public Boolean isRoomPresent(int id){
        Boolean bool = false;
        Statement s = null;
        DataSource ds = new DataSource();
        Connection c = ds.getConnection();

        try{
            s = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT from ").append(TABLE_NAME).append(" WHERE ").append(COLUMN_ID).append(" = ").append(id);
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

        //Room room = new Room(22, "b5", new Building("F", 4), 3);

        //rd.addRoom(room);

        //rd.deleteRoom(room);

        //rd.isRoomPresent(23);

    }

}
