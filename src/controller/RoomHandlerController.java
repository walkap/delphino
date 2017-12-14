package controller;

import dao.RoomDao;
import entity.room.Room;

import java.util.Vector;

public class RoomHandlerController {

    private RoomDao rd = RoomDao.getInstance();

    public void addNewRoom(Room room){
        if(room.hasTeacherDesk() == null){
            room.setTeacherDesk(false);
        }
        rd.addRoom(room);
    }

    public void deleteRoom(Room room){
        rd.deleteRoom(room);
    }

    public void updateRoom(Room room){
        rd.updateRoom(room);
    }

    public Room getRoom(Room room){
        return rd.getRoom(room);
    }

    public Vector<Room> getAllRooms(){
        return rd.getAllRooms();
    }

    /*public static void main(String[] args) {
        RoomHandlerController rhc = new RoomHandlerController();

        Room room = new Room("D15", "5", "Laboratory");

        rhc.addNewRoom(room);

    }*/

}
