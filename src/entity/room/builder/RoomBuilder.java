package entity.room.builder;

import entity.room.Room;

public abstract class RoomBuilder {

    private Room myRoom;

    public void createRoom(String name, String type, int building){
        myRoom = new Room(name, type, building);
    }

    public Room getRoom(){
        return myRoom;
    }

    public RoomBuilder setId(int arg0){
        myRoom.setId(arg0);
        return this;
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

    public RoomBuilder setTeacherDesk(Boolean arg0){
        myRoom.setTeacherDesk(arg0);
        return this;
    }

    public abstract void setRoomType();

}