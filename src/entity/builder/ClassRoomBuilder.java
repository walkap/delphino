package entity.builder;

public class ClassRoomBuilder extends RoomBuilder{

    @Override
    public void setRoomType() {
        this.getRoom().setType("ClassRoom");
    }
}