package entity.builder;

public class CongressHallBuilder extends RoomBuilder {
    @Override
    public void setRoomType() {
        this.getRoom().setType("CongressHall");
    }
}
