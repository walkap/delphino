package entity.room.builder;

public class CongressHallBuilder extends RoomBuilder {
    @Override
    public void setRoomType() {
        this.myRoom.setType("CongressHall");
    }
}
