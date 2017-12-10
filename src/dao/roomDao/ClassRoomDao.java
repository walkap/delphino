package dao.roomDao;

import dao.DataSource;
import dao.RoomDao;
import entity.room.Room;

import java.sql.*;

public class ClassRoomDao {

    private Connection connection;

    public void addClassRoom(Room classRoom){

        Statement stmt = null;
        DataSource src = new DataSource();
        connection = src.getConnection();
        try {
            stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            String sql = "insert into Room(id, name, building, floor, type, seats, board, projector, desk) values " +
                    "('" + classRoom.getId() + "'," + classRoom.getName() + "'," + classRoom.getBuilding() + "',"
                    + classRoom.getFloor() + "'," + classRoom.getType() + "'," + classRoom.getSeats() + "'," + classRoom.getBoard() +
                    "'," + classRoom.getProjector() + "'," + classRoom.hasDesk() + ")";
            stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.getMessage();
        }finally {
            try {
                connection.close();
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

/*    public static void main (String args[]) {
        Room classRoom = new Room(1 , 5 , 150, 3);
        RoomDao classRoomDao = new RoomDao();

    } */
}
