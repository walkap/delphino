package entity.room.builder.concreteBuilder;

import entity.room.builder.RoomBuilder;

public class ClassRoomBuilder extends RoomBuilder {

    @Override
    public void setRoomType() {
        this.getRoom().setType("ClassRoom");
    }
}