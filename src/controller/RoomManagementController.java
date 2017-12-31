package controller;

import dao.RoomDao;
import entity.room.Room;
import entity.room.builder.RoomBuilder;
import entity.room.builder.RoomDirectorBuilder;

import java.util.Vector;

public class RoomManagementController {

    private RoomDao rd = RoomDao.getInstance();

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
        rd.addRoom(room);
    }

    /**
     * This method delete a romm from database
     *
     * @param room - Room
     */
    public void deleteRoom(Room room) {
        rd.deleteRoom(room);
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
        rd.updateRoom(room);
    }

    /**
     * This method get a room from database passing an id as parameter
     *
     * @param name - String
     * @return
     */
    public Room getRoomByName(String name) {
        System.out.println("RoomManagementController getRoom(int " + name + "): " + rd.getRoom(name));
        return rd.getRoom(name);
    }

    /**
     * This method get the vector of all rooms present in the database
     *
     * @return Vector
     */
    public Vector<Room> getAllRooms() {
        return rd.getAllRooms();
    }

    /*public static void main(String[] args) {
        //RoomManagementController rhc = new RoomManagementController();
        //rhc.getRoom(14);
    }*/
}