package control;

import dao.room.RoomDao;
import dao.room.RoomDaoDb;
import entity.room.Room;
import entity.room.builder.RoomBuilder;
import entity.room.builder.RoomDirectorBuilder;
import exception.room.InsertRoomException;

import java.sql.SQLException;
import java.util.Vector;

public class RoomManagementController {

    private RoomDao roomDao = new RoomDaoDb();
    private Room myRoom;

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
    public void insertRoom(String name, String type, int building, String board, boolean teacherDesk, int seats, int projectors, int computers) throws InsertRoomException {

        if(name == null || type == null || building == 0){
            throw new InsertRoomException("Name, type and building are mandatory!");
        }

        RoomDirectorBuilder director = new RoomDirectorBuilder();
        RoomBuilder builder = director.buildRoom(name.toUpperCase(), type, building)
                .setBoard(board)
                .setTeacherDesk(teacherDesk)
                .setSeats(seats)
                .setProjectors(projectors)
                .setComputers(computers);
        myRoom = builder.getRoom();
        try{
            roomDao.insertRoom(myRoom);
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
            roomDao.deleteRoom(room);
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
    public void updateRoom(String name, String type, int building, String board, boolean teacherDesk, int seats, int projectors, int computers) throws InsertRoomException {

        if(name == null || type == null || building == 0){
            throw new InsertRoomException("Name, type and building are mandatory!");
        }

        RoomDirectorBuilder director = new RoomDirectorBuilder();
        RoomBuilder builder = director.buildRoom(name.toUpperCase(), type, building)
                .setBoard(board)
                .setTeacherDesk(teacherDesk)
                .setSeats(seats)
                .setProjectors(projectors)
                .setComputers(computers);
        myRoom = builder.getRoom();
        try {
            roomDao.updateRoom(myRoom);
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
        try{
            myRoom = roomDao.getRoom(name);
        }catch (NullPointerException e){
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
        return roomDao.getAllRooms();
    }

    /**
     * This method get the vector of all rooms selected by the filter
     * @param type - String
     * @param building - int
     * @param board - String
     * @param teacherDesk - Boolean
     * @param seats - int
     * @param projectors - int
     * @param computers - int
     * @return Vector
     */
    public Vector<Room> getRooms(String type, int building, String board, boolean teacherDesk, int seats, int projectors, int computers){
        return roomDao.getRooms(type, building, board, teacherDesk, seats, projectors, computers);
    }

}