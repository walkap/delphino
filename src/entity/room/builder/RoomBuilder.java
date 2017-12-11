package entity.room.builder;

import entity.Building;
import entity.room.Room;

public abstract class RoomBuilder {

    private Room myRoom;

    public void createRoom(int id, String name, Building building){
        myRoom = new Room(id, name, building);
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

    public RoomBuilder hasDesk(Boolean arg0){
        myRoom.setDesk(arg0);
        return this;
    }

    public abstract void setRoomType();

}