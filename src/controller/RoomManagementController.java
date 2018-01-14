package controller;

import dao.room.RoomDao;
import dao.room.RoomDaoDb;
import entity.room.Room;
import entity.room.builder.RoomBuilder;
import entity.room.builder.RoomDirectorBuilder;

import java.sql.SQLException;
import java.util.Vector;

public class RoomManagementController {

    //private RoomDao daoDb = RoomDao.getInstance();

    private RoomDao daoDb = new RoomDaoDb();

    private static RoomManagementController instance = null;

    /**
     * Default private constructor
     */
    private RoomManagementController() {
    }

    /**
     * This is a singleton, it returns an instance of this class
     *
     * @return - RoomManagementController
     */
    public static RoomManagementController getInstance() {
        if (instance == null) {
            instance = new RoomManagementController();
        }
        return instance;
    }

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
    public void addNewRoom(String name, String type, int building, String board, boolean teacherDesk, int seats, int projectors, int computers) {
        RoomDirectorBuilder director = new RoomDirectorBuilder();
        RoomBuilder builder = director.buildRoom(name, type, building)
                .setBoard(board)
                .setTeacherDesk(teacherDesk)
                .setSeats(seats)
                .setProjectors(projectors)
                .setComputers(computers);
        Room room = builder.getRoom();
        try{
            daoDb.addRoom(room);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * This method delete a romm from database
     *
     * @param room - Room
     */
    public void deleteRoom(Room room) {
        try{
            daoDb.deleteRoom(room);
        }catch (NullPointerException e){
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
    public void updateRoom(String name, String type, int building, String board, boolean teacherDesk, int seats, int projectors, int computers) {
        RoomDirectorBuilder director = new RoomDirectorBuilder();
        RoomBuilder builder = director.buildRoom(name, type, building)
                .setBoard(board)
                .setTeacherDesk(teacherDesk)
                .setSeats(seats)
                .setProjectors(projectors)
                .setComputers(computers);
        Room room = builder.getRoom();
        try {
            daoDb.updateRoom(room);
        }catch (NullPointerException e){
            e.printStackTrace();
        }
    }

    /**
     * This method get a room from database passing an id as parameter
     *
     * @param name - String
     * @return Room
     */
    public Room getRoomByName(String name) {
        Room room = null;
        try{
            room = daoDb.getRoom(name);
        }catch (NullPointerException e){
            e.printStackTrace();
        }
        return room;
    }

    /**
     * This method get the vector of all rooms present in the database
     *
     * @return Vector
     */
    public Vector<Room> getAllRooms() {
        return daoDb.getAllRooms();
    }

    /*public static void main(String[] args) {

    }*/
}