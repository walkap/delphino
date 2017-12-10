package entity.room.builder;

import entity.Building;
import entity.room.Room;

public abstract class RoomBuilder {

    public Room myRoom;

    public void createRoom(int id, String name, Building building, int floor){
        myRoom = new Room(id, name, building, floor);
    }

    public Room getRoom(){
        return myRoom;
    }

    public RoomBuilder setSeats(int arg0){
        myRoom.setSeats(arg0);
        return this;
    }

    public RoomBuilder setBoard(String arg0){
        myRoom.setBoard(arg0);
        return this;
    }

    public RoomBuilder setProjector(String arg0){
        myRoom.setProjector(arg0);
        return this;
    }

    public RoomBuilder setComputers(int arg0){
        myRoom.setComputers(arg0);
        return this;
    }

    public RoomBuilder hasDesk(Boolean arg0){
        myRoom.setDesk(arg0);
        return this;
    }

    public abstract void setRoomType();

}