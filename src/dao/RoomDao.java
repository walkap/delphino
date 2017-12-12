package dao;

import entity.room.Room;
import entity.room.builder.RoomDirectorBuilder;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class RoomDao extends AbstractDao {

    private static final String TABLE_NAME = "room";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_TYPE = "type";
    private static final String COLUMN_BUILDING = "building";
    private static final String COLUMN_BOARD = "board";
    private static final String COLUMN_TEACHER_DESK = "teacher_desk";
    private static final String COLUMN_SEATS = "seats";
    private static final String COLUMN_PROJECTORS = "projectors";
    private static final String COLUMN_COMPUTERS = "computers";

    /**
     * This method checks if a room is present
     * in the database using the room's id as parameter
     *
     * @param name - Room's name
     * @return Boolean
     */
    private Boolean isRoomPresent(String name) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT from ")
                .append(TABLE_NAME)
                .append(" WHERE ")
                .append(COLUMN_NAME)
                .append(" = '")
                .append(name).append("'");
        System.out.println(sql.toString());
        return this.isPresent(sql.toString());
    }

    /**
     * This method is used to add a new room to the database
     *
     * @param name
     * @param building
     * @param type
     * @param seats
     * @param boards
     * @param projectors
     * @param computers
     * @param desk
     */
    public void addRoom(String name, int building, String type, int seats, String boards, int projectors, int computers, Boolean desk) {
        if (!isRoomPresent(name)) {
            StringBuilder sql = new StringBuilder();
            sql.append("insert into " + TABLE_NAME + "(");
            sql.append(COLUMN_NAME).append(", ").append(COLUMN_TYPE).append(", ").append(COLUMN_BUILDING).append(")");
            sql.append(" values(");
            sql.append("'").append(name).append("', ");
            sql.append("'").append(type).append("', ");
            sql.append("'").append(building).append("')");
            this.executeUpdate(sql.toString());
            System.out.println("Yay! The room has been added to the database!");
        } else {
            System.out.println("It's already present a room named " + name + "in the database");
        }
    }

    /**
     * This method is used to delete {@code room} object
     * from database
     *
     * @param name - {@code String}
     */
    public void deleteRoom(String name) {
        if (isRoomPresent(name)) {
            StringBuilder sql = new StringBuilder();
            sql.append("DELETE from ").append(TABLE_NAME).append(" WHERE ").append(COLUMN_NAME).append(" = '").append(name).append("'");
            this.executeUpdate(sql.toString());
            System.out.println("The room has been deleted from the database!");
        } else {
            System.out.println("We are sorry, the room you wanted to delete it doesn't exist");
        }
    }


    //TODO This should be improved I think isn't working very well. An option could be split each update in a method
    /**
     * This method is used to update a room
     *
     * @param room
     */
    public void updateRoom(Room room) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE " + TABLE_NAME)
                .append(" SET ")
                .append(COLUMN_NAME).append(" = '").append(room.getName()).append("', ")
                .append(COLUMN_TYPE).append(" = '").append(room.getType()).append("', ")
                .append(COLUMN_BUILDING).append(" = '").append(room.getBuilding()).append("', ")
                .append(COLUMN_BOARD).append(" = '").append(room.getBoard()).append("', ")
                .append(COLUMN_TEACHER_DESK).append(" = ").append(room.hasTeacherDesk()).append(", ")
                .append(COLUMN_SEATS).append(" = ").append(room.getSeats()).append(", ")
                .append(COLUMN_PROJECTORS).append(" = ").append(room.getProjectors()).append(", ")
                .append(COLUMN_COMPUTERS).append(" = ").append(room.getComputers())
                .append(" WHERE ").append(COLUMN_NAME).append(" = '").append(room.getName()).append("'");
        System.out.println(sql.toString());
        this.executeUpdate(sql.toString());
    }

    /**
     * This method is used to get an existing room
     *
     * @param name - String
     * @return Room
     */
    public Room getRoom(String name) {
        Room room = null;
        Statement s = null;
        DataSource ds = new DataSource();
        Connection c = ds.getConnection();
        try {
            s = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT * FROM ").append(TABLE_NAME);
            sql.append(" WHERE " + COLUMN_NAME + "='" + name + "'");
            ResultSet rs = s.executeQuery(sql.toString());
            if (rs.next()) {
                RoomDirectorBuilder rdb = new RoomDirectorBuilder();
                rdb.buildRoom(rs.getString(COLUMN_NAME), rs.getString(COLUMN_BUILDING), rs.getString(COLUMN_TYPE));
                room = rdb.getRoom();
                room.setBoard(rs.getString(COLUMN_BOARD));
                room.setTeacherDesk(rs.getBoolean(COLUMN_TEACHER_DESK));
                room.setSeats(rs.getInt(COLUMN_SEATS));
                room.setProjectors(rs.getInt(COLUMN_PROJECTORS));
                room.setComputers(rs.getInt(COLUMN_COMPUTERS));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Closing statement...");
            this.closeStatement(s);
            System.out.println("Closing connection...");
            ds.closeConnection(c);
        }
        System.out.println(room.getName());
        return room;
    }

    /**
     * This method returns all room present in the database
     *
     * @return Vector
     */
    public Vector<Room> getAllRoom() {
        Statement s = null;
        DataSource ds = new DataSource();
        Connection c = ds.getConnection();
        Vector<Room> vec = new Vector<Room>();
        try {
            s = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT * FROM " + TABLE_NAME);
            ResultSet rs = s.executeQuery(sql.toString());
            RoomDirectorBuilder rdb = new RoomDirectorBuilder();
            while (rs.next()) {
                rdb.buildRoom(rs.getString(COLUMN_NAME), rs.getString(COLUMN_BUILDING), rs.getString(COLUMN_TYPE));
                Room room = rdb.getRoom();
                room.setBoard(rs.getString(COLUMN_BOARD));
                room.setTeacherDesk(rs.getBoolean(COLUMN_TEACHER_DESK));
                room.setSeats(rs.getInt(COLUMN_SEATS));
                room.setProjectors(rs.getInt(COLUMN_PROJECTORS));
                room.setComputers(rs.getInt(COLUMN_COMPUTERS));
                vec.add(room);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Closing statement...");
            this.closeStatement(s);
            System.out.println("Closing connection...");
            ds.closeConnection(c);
        }
        return vec;
    }

    public static void main(String[] args) {
        RoomDao rd = new RoomDao();
        //rd.addRoom("F6", 4, "ClassRoom", 0, null, 0, 0, null);
        //rd.deleteRoom("C4");
        //rd.isRoomPresent("C6");
        //rd.updateRoom();
        //rd.getAllRoom();
        //rd.getRoom("D6");
        Room room = new Room("D6", "5", "Laboratory");
        room.setBoard("bianca");
        rd.updateRoom(room);
    }
}