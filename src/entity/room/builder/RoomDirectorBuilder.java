package entity.room.builder;

import entity.Building;
import entity.room.Room;

public class RoomDirectorBuilder {

    private RoomBuilder myRoomBuilder;

    public Room getRoom()
    {
        return myRoomBuilder.getRoom();
    }

    public void constructRoom(int id, String name, Building building, int floor, String type)
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

        myRoomBuilder.createRoom(id, name, building, floor);
        myRoomBuilder.setRoomType();

    }

    public static void main(String[] args){

        RoomDirectorBuilder rdb = new RoomDirectorBuilder();

        rdb.constructRoom(23, "a1", new Building("D", 4), 3, "ClassRoom");

        Room room = rdb.getRoom();

        room.setSeats(12);
        room.setBoard("lavagna nera");

        System.out.println(
                "Floor: " + room.getFloor() +
                " Id: "  + room.getId() +
                " Name: " + room.getName() +
                " Building: " + room.getBuilding().getName() +
                " Seats: " + room.getSeats() +
                " Board: " + room.getBoard() +
                " Type: " + room.getType());

    }

}
