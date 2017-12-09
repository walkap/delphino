package entity.room.builder;

public class LaboratoryBuilder extends RoomBuilder {

    @Override
    public void setRoomType() {
        this.myRoom.setType("Laboratory");
    }
}
