package entity.room.builder;

import entity.Building;
import entity.room.Room;

public class RoomDirectorBuilder {

    private RoomBuilder myRoomBuilder;

    public Room getRoom()
    {
        return myRoomBuilder.getRoom();
    }

    public void buildRoom(String name, String building, String type)
    {

        switch (type){
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

        myRoomBuilder.createRoom(name, building, type);
        myRoomBuilder.setRoomType();

    }

    public static void main(String[] args){

        RoomDirectorBuilder rdb = new RoomDirectorBuilder();

        rdb.buildRoom("a1", "F", "ClassRoom");

        Room room = rdb.getRoom();

        room.setSeats(12);
        room.setBoard("lavagna nera");

        System.out.println(
                " Id: "  + room.getId() +
                " Name: " + room.getName() +
                " Building: " + room.getBuilding() +
                " Seats: " + room.getSeats() +
                " Board: " + room.getBoard() +
                " Type: " + room.getType());

    }

}
