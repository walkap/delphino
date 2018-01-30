package dao.room;

import entity.room.Room;

import java.sql.SQLException;
import java.util.Vector;

public interface RoomDao {

    /**
     * This abstract method insert a new room in the persistence
     *
     * @param room - Room
     * @throws SQLException
     */
    void insertRoom(Room room) throws SQLException;

    /**
     * This abstract method delete a room from the persistence
     *
     * @param room - Room
     */
    void deleteRoom(Room room);

    /**
     * This abstract method update a room from the persistence if present
     *
     * @param room - Room
     */
    void updateRoom(Room room);

    /**
     * This abstract method returns a room from the persistence if present
     *
     * @param name - String
     * @return Room
     */
    Room getRoomByName(String name);

    /**
     * This abstract method returns a room from the persistence if present
     * by id
     * @param id int
     * @return Room
     */
    Room getRoomById(int id);

    /**
     * This abstract method returns a vector of rooms from the persistence
     *
     * @return Vector
     */
    Vector<Room> getAllRooms();

    /**
     * This abstract method filter rooms from persistence and returns
     * a vector of rooms
     *
     * @param type        - String
     * @param building    - int
     * @param board       - String
     * @param teacherDesk - boolean
     * @param seats       - int
     * @param projectors  - int
     * @param computers   - int
     * @return Vector
     */
    Vector<Room> getRooms(String type, String building, String board, boolean teacherDesk, int seats, int projectors, int computers);

}