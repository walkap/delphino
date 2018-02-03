package control;

import dao.factory.DaoFactory;
import dao.room.RoomDao;
import entity.Building;
import entity.room.Room;
import entity.room.builder.RoomBuilder;
import entity.room.builder.RoomDirectorBuilder;
import exception.room.InsertRoomException;

import java.sql.SQLException;
import java.util.Vector;

public class HandleRoom {
    private DaoFactory dbFactory = DaoFactory.getDaoFactory(DaoFactory.FILE);

    /**
     * This method insert new room in the database, getting parameter
     * from front end
     *
     * @param name        - String
     * @param type        - String
     * @param building    - int
     * @param board       - String
     * @param teacherDesk - boolean
     * @param seats       - int
     * @param projectors  - int
     * @param computers   - int
     */
    public void insertRoom(String name, String type, String building, String area, String board, boolean teacherDesk, int seats, int projectors, int computers) throws InsertRoomException {
        //This exception checks if all mandatory fields have benn filled
        if (name == null || type == null || building == null || area == null) {
            throw new InsertRoomException("Name, type, building and area are mandatory!");
        }
        //Create a director builder that decides which kind of room instantiate
        RoomDirectorBuilder director = new RoomDirectorBuilder();
        //The builder create a room
        RoomBuilder builder = director.buildRoom(name.toUpperCase(), type, new Building(building, area))
                .setBoard(board)
                .setTeacherDesk(teacherDesk)
                .setSeats(seats)
                .setProjectors(projectors)
                .setComputers(computers);
        //The builder create a room
        Room myRoom = builder.getRoom();
        //Get the DAO to access the persistence
        RoomDao roomDao = dbFactory.getRoomDao();
        try {
            //Get the method to insert the room in the persistence
            roomDao.insertRoom(myRoom);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method delete a romm from database
     *
     * @param room - Room
     */
    public void deleteRoom(Room room) throws NullPointerException {
        //Get the DAO to access the persistence
        RoomDao roomDao = dbFactory.getRoomDao();
        try {
            //Get the method to delete the room from the persistence
            roomDao.deleteRoom(room);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method update a room
     *
     * @param name        - String
     * @param type        - String
     * @param building    - int
     * @param board       - String
     * @param teacherDesk - boolean
     * @param seats       - int
     * @param projectors  - int
     * @param computers   - int
     */
    public void updateRoom(String name, String type, String building, String area, String board, boolean teacherDesk, int seats, int projectors, int computers) throws InsertRoomException {
        //This exception checks if all mandatory fields have benn filled
        if (name == null || type == null || building == null || area == null) {
            throw new InsertRoomException("Name, type, building and area are mandatory!");
        }
        //Create a director builder that decides which kind of room instantiate
        RoomDirectorBuilder director = new RoomDirectorBuilder();
        //The builder create a room
        RoomBuilder builder = director.buildRoom(name.toUpperCase(), type, new Building(building, area))
                .setBoard(board)
                .setTeacherDesk(teacherDesk)
                .setSeats(seats)
                .setProjectors(projectors)
                .setComputers(computers);
        //The builder create a room
        Room myRoom = builder.getRoom();
        //Get the DAO to access the persistence
        RoomDao roomDao = dbFactory.getRoomDao();
        try {
            //Get the method to update the current room
            roomDao.updateRoom(myRoom);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method get a room from the persistence by its name
     *
     * @param name - String
     * @return Room
     */
    public Room getRoomByName(String name) {
        //Get the DAO to access the persistence
        RoomDao roomDao = dbFactory.getRoomDao();
        Room myRoom = null;
        try {
            //Get the method to get the room from the persistence by name
            myRoom = roomDao.getRoomByName(name);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return myRoom;
    }

    /**
     * This method get a room from the persistence by its id
     *
     * @param id int
     * @return Room
     */
    public Room getRoomById(int id) {
        //Get the DAO to access the persistence
        RoomDao roomDao = dbFactory.getRoomDao();
        Room myRoom = null;
        try {
            //Get the method to get the room from the persistence by id
            myRoom = roomDao.getRoomById(id);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return myRoom;
    }

    /**
     * This method get the vector of all rooms present in the database
     *
     * @return Vector
     */
    public Vector<Room> getAllRooms() {
        //Get the DAO to access the persistence
        RoomDao roomDao = dbFactory.getRoomDao();
        return roomDao.getAllRooms();
    }

    /**
     * This method get the vector of all rooms selected by the filter
     *
     * @param type        - String
     * @param building    - int
     * @param board       - String
     * @param teacherDesk - Boolean
     * @param seats       - int
     * @param projectors  - int
     * @param computers   - int
     * @return Vector
     */
    public Vector<Room> searchRooms(String type, String building, String board, boolean teacherDesk, int seats, int projectors, int computers) {
        //Get the DAO to access the persistence
        RoomDao roomDao = dbFactory.getRoomDao();
        return roomDao.searchRooms(type, building, board, teacherDesk, seats, projectors, computers);
    }

}