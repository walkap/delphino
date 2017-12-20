package entity.room.builder;

import entity.room.Room;
import entity.room.builder.concreteBuilder.ClassRoomBuilder;
import entity.room.builder.concreteBuilder.CongressHallBuilder;
import entity.room.builder.concreteBuilder.LaboratoryBuilder;

public class RoomDirectorBuilder {

    private RoomBuilder myRoomBuilder;

    /**
     * This method create a new instance of room
     *
     * @param name     - String
     * @param building - String
     * @param type     - String
     */
    public RoomBuilder buildRoom(String name, String type, int building) {

        switch (type) {
            case "ClassRoom":
                myRoomBuilder = new ClassRoomBuilder();
                break;
            case "Laboratory":
                myRoomBuilder = new LaboratoryBuilder();
                break;
            case "Congress Hall":
                myRoomBuilder = new CongressHallBuilder();
                break;
        }

        myRoomBuilder.createRoom(name, type, building);
        myRoomBuilder.setRoomType();

        return myRoomBuilder;
    }

    /**
     * This method get the current room instance
     *
     * @return Room
     */
    public Room getRoom() {
        return myRoomBuilder.getRoom();
    }


    /*public static void main(String[] args){
        RoomDirectorBuilder director = new RoomDirectorBuilder();
        RoomBuilder builder = director.buildRoom("c12", "ClassRoom", "F");
    }*/

}
