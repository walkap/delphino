package entity.room.builder;

import entity.Building;
import entity.room.Room;

public abstract class RoomBuilder {

    private Room myRoom;

    public void createRoom(String name, Building building, String type){
        myRoom = new Room(name, building, type);
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

    public RoomBuilder setProjectors(int arg0){
        myRoom.setProjectors(arg0);
        return this;
    }

    public RoomBuilder setComputers(int arg0){
        myRoom.setComputers(arg0);
        return this;
    }

    public RoomBuilder hasTeacherDesk(Boolean arg0){
        myRoom.setTeacherDesk(arg0);
        return this;
    }

    public abstract void setRoomType();

}