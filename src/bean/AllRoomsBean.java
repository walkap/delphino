package bean;

import control.HandleRoom;
import entity.room.Room;

import java.util.Vector;

public class AllRoomsBean {

    private Vector<Room> rooms;

    public Vector<Room> getRooms() {

        HandleRoom handleRoom = new HandleRoom();

        rooms = handleRoom.getAllRooms();

        return rooms;
    }

    public void setRooms(Vector<Room> rooms) {
        this.rooms = rooms;
    }
}
