package dao.room;

import dao.AbstractDao;
import dao.DataSource;
import entity.room.Room;
import entity.room.builder.RoomBuilder;
import entity.room.builder.RoomDirectorBuilder;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class RoomDaoDb extends AbstractDao implements RoomDao {

    private static final String TABLE_NAME = "room";
    private static final String COLUMN_ID = "id";
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
     * @param name - String
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
        return this.isPresent(sql.toString());
    }

    /**
     * This method is used to add a new room to the database
     *
     * @param room - Room
     * @throws SQLException
     */
    public void addRoom(Room room) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into ").append(TABLE_NAME).append("(")
                .append(COLUMN_NAME).append(", ")
                .append(COLUMN_TYPE).append(", ")
                .append(COLUMN_SEATS).append(", ")
                .append(COLUMN_BOARD).append(", ")
                .append(COLUMN_PROJECTORS).append(", ")
                .append(COLUMN_COMPUTERS).append(", ")
                .append(COLUMN_TEACHER_DESK).append(", ")
                .append(COLUMN_BUILDING).append(")")
                .append(" values(")
                .append("'").append(room.getName()).append("', ")
                .append("'").append(room.getType()).append("', ")
                .append("'").append(room.getSeats()).append("', ")
                .append("'").append(room.getBoard()).append("', ")
                .append("'").append(room.getProjectors()).append("', ")
                .append("'").append(room.getComputers()).append("', ")
                .append("'").append(room.hasTeacherDesk()).append("', ")
                .append("'").append(room.getBuilding()).append("')");
        this.executeUpdate(sql.toString());
    }

    /**
     * This method is used to delete {@code room} object
     * from database
     *
     * @param room - Room
     * @throws NullPointerException
     */
    public void deleteRoom(Room room) throws NullPointerException {
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE from ")
                .append(TABLE_NAME)
                .append(" WHERE ")
                .append(COLUMN_ID).append(" = '").append(room.getId()).append("'");
        this.executeUpdate(sql.toString());
    }

    //TODO This should be improved I think isn't working very well. An option could be split each update in a method

    /**
     * This method is used to update a room
     *
     * @param room - Room
     * @throws NullPointerException
     */
    public void updateRoom(Room room) throws NullPointerException{
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
        this.executeUpdate(sql.toString());
    }

    /**
     * This method is used to get an existing room
     *
     * @param name - String
     * @return Room
     * @throws NullPointerException
     */
    public Room getRoom(String name) throws NullPointerException{
        Statement s = null;
        DataSource ds = new DataSource();
        Connection c = ds.getConnection();
        Room room = null;
        try {
            s = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT * FROM ").append(TABLE_NAME)
                    .append(" WHERE ")
                    .append(COLUMN_NAME)
                    .append("='")
                    .append(name)
                    .append("'");
            ResultSet rs = s.executeQuery(sql.toString());
            if (rs.next()) {
                RoomDirectorBuilder rdb = new RoomDirectorBuilder();
                RoomBuilder rb = rdb.buildRoom(rs.getString(COLUMN_NAME), rs.getString(COLUMN_TYPE), rs.getInt(COLUMN_BUILDING));
                setAllOptionalAttributes(rb, rs);
                room = rdb.getRoom();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Closing statement...");
            this.closeStatement(s);
            System.out.println("Closing connection...");
            ds.closeConnection(c);
        }
        return room;
    }

    /**
     * This method returns all room present in the database
     *
     * @return Vector
     */
    public Vector<Room> getAllRooms() {
        Statement s = null;
        DataSource ds = new DataSource();
        Connection c = ds.getConnection();
        Vector<Room> vec = new Vector<>();
        try {
            s = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT * FROM " + TABLE_NAME);
            ResultSet rs = s.executeQuery(sql.toString());
            RoomDirectorBuilder rdb = new RoomDirectorBuilder();
            while (rs.next()) {
                RoomBuilder rb = rdb.buildRoom(rs.getString(COLUMN_NAME), rs.getString(COLUMN_TYPE), rs.getInt(COLUMN_BUILDING));
                setAllOptionalAttributes(rb, rs);
                Room room = rdb.getRoom();
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

    /**
     * This method set all otpional attributes
     *
     * @param rb - RoomBuilder
     * @param rs - ResultSet
     * @throws SQLException
     */
    private void setAllOptionalAttributes(RoomBuilder rb, ResultSet rs) throws SQLException {
        rb.setId(rs.getInt(COLUMN_ID))
                .setBoard(rs.getString(COLUMN_BOARD))
                .setTeacherDesk(rs.getBoolean(COLUMN_TEACHER_DESK))
                .setSeats(rs.getInt(COLUMN_SEATS))
                .setProjectors(rs.getInt(COLUMN_PROJECTORS))
                .setComputers(rs.getInt(COLUMN_COMPUTERS));
    }

    public static void main(String[] args) {
        //RoomDao rd = new RoomDao();
        /*try {
            //RoomDao.getInstance().addRoom(getInstance().getRoom("D15"));
        }catch (SQLException e){
            e.printStackTrace();
        }*/
        //rd.deleteRoom(getInstance().getRoom("D15"));
        //rd.isRoomPresent(room.getName());
        //rd.updateRoom();
        //rd.getAllRoom();
        //rd.getRoom(19);
        //Room room = new Room("D6", "5", "Laboratory");
        //room.setBoard("bianca");
        //rd.updateRoom(room);
    }

}