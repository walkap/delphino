package entity.room.builder.concreteBuilder;

import entity.room.builder.RoomBuilder;

public class LaboratoryBuilder extends RoomBuilder {

    @Override
    public void setRoomType() {
        this.getRoom().setType("Laboratory");
    }
}
