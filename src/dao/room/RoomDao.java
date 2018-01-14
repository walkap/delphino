package dao.room;

import entity.room.Room;

import java.sql.SQLException;
import java.util.Vector;

public interface RoomDao {

    void addRoom(Room room) throws SQLException;

    void deleteRoom(Room room);

    void updateRoom(Room room);

    Room getRoom(String name);

    Vector<Room> getAllRooms();

}