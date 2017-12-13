package entity.room.builder.concreteBuilder;

import entity.room.builder.RoomBuilder;

public class CongressHallBuilder extends RoomBuilder {
    @Override
    public void setRoomType() {
        this.getRoom().setType("CongressHall");
    }
}
