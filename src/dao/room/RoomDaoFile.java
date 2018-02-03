package dao.room;

import entity.Building;
import entity.room.Room;
import java.io.*;
import java.util.Vector;

public class RoomDaoFile implements RoomDao{

    private static final String FILE_PATH = "/Users/robertocapannelli/Projects/delphino/room.ser";

    /**
     * This method is used to serialize an object vector in a file
     *
     * @param vec - Vector
     */
    private void serialization(Vector<Room> vec) {
        FileOutputStream fileOutput = null;
        ObjectOutputStream objectOutput = null;
        try {
            File file = new File(FILE_PATH);
            if(file.createNewFile()){
                System.out.println("The file has been create!");
            }
            //Open file stream
            fileOutput = new FileOutputStream(FILE_PATH);
            //Open object stream
            objectOutput = new ObjectOutputStream(fileOutput);
            //Write object on file
            objectOutput.writeObject(vec);
            System.out.println("RoomFileDao serialization: object has been written!");

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("RoomFileDao serialization: object has NOT been written!");
        } finally {
            try {
                if (objectOutput != null) {
                    //Close object stream
                    objectOutput.close();
                }
                if (fileOutput != null) {
                    //Close file stream
                    fileOutput.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * This method is used to deserialize an object vector from a file
     *
     * @return Vector
     */
    private Vector<Room> deserialization() {
        Vector<Room> vec = null;
        try {
            File file = new File(FILE_PATH);
            if(file.createNewFile()){
                System.out.println("The file has been create!");
            }
            //Open file stream
            FileInputStream fileOutput = new FileInputStream(FILE_PATH);
            //Open object stream
            ObjectInputStream objectOutput = new ObjectInputStream(fileOutput);
            try {
                //Get vector object
                vec = (Vector<Room>) objectOutput.readObject();
                System.out.println("RoomFileDao deserialization: read object " + vec);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                System.out.println("RoomFileDao deserialization: couldn't read object");
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        System.out.println("RoomFileDao deserialization: return object " + vec);
        return vec;
    }

    /**
     * This method is used to ensure that a room is present in a file
     *
     * @param name - String
     * @return Boolean
     */
    private Boolean isRoomPresent(String name) {
        Vector<Room> vec = deserialization();
        for (Room room : vec) {
            if (room.getName().equals(name)) {
                System.out.println("RoomFileDao isRoomPresent(): yay the room you're looking for is present!");
                return true;
            }
        }
        System.out.println("RoomFileDao isRoomPresent(): the room you're looking for is NOT present!");
        return false;
    }

    /**
     * This method is used to add a room to a file
     *
     * @param room - String
     */
    @Override
    public void insertRoom(Room room) {
        //if (!isRoomPresent(room.getName())) {
            Vector<Room> vec = deserialization();
            vec.add(room);
            this.serialization(vec);
            System.out.println("RoomFileDao insertRoom(): yay your room has been added to the file!");
       // }
    }

    /**
     * This method is used to delete a room from a file
     *
     * @param room - Room
     */
    @Override
    public void deleteRoom(Room room) {
        if (isRoomPresent(room.getName())) {
            Vector<Room> vec = deserialization();
            for (int i = 0; i < vec.size(); i++) {
                if (vec.get(i).getName().equals(room.getName())) {
                    vec.remove(i);
                    this.serialization(vec);
                    System.out.println("RoomFileDao deleteRoom: yay the room you selected has been deleted succesfully!");
                    return;
                }
            }
        }
    }

    /**
     * This method is used to update an existing room in the file
     *
     * @param room - Room
     */
    @Override
    public void updateRoom(Room room) {
        if (isRoomPresent(room.getName())) {
            Vector<Room> vec = deserialization();
            for (Room currentRoom : vec) {
                if (currentRoom.getName().equals(room.getName())) {
                    currentRoom.setType(room.getType());
                    currentRoom.setBuilding(room.getBuilding());
                    currentRoom.setSeats(room.getSeats());
                    currentRoom.setBoard(room.getBoard());
                    currentRoom.setProjectors(room.getProjectors());
                    currentRoom.setComputers(room.getComputers());
                    currentRoom.setTeacherDesk(room.hasTeacherDesk());
                    this.serialization(vec);
                    System.out.println("RoomFileDao updateRoom(): yay the room has been successfully updated!");
                    return;
                }
            }
        }
    }

    /**
     * This methof is used to get an existing room in a file
     *
     * @param name - String
     * @return Room
     */
    @Override
    public Room getRoomByName(String name) {
        Room room;
        Vector<Room> vec = deserialization();
        for (Room currentRoom : vec) {
            if (currentRoom.getName().equals(name)) {
                room = currentRoom;
                System.out.println("Room: " + room.getName() + " found!");
                return room;
            }
        }
        return null;
    }


    @Override
    public Room getRoomById(int id){
        return null;
    }

    /**
     * This method returns all rooms in the persistence file
     * @return Vector<Room>
     */
    @Override
    public Vector<Room> getAllRooms(){
        Vector<Room> vec = deserialization();
        System.out.println("All rooms found!");
        return vec;
    }

    @Override
    public Vector<Room> searchRooms(String type, String building, String board, boolean teacherDesk, int seats, int projectors, int computers) {
        return null;
    }

    public static void main(String[] args) {
        //RoomDaoFile roomDaoFile = new RoomDaoFile();

        //Room room = new Room("B5", new Building("Didattica", "Ingegneria"));
        //Vector<Room> vector = new Vector<Room>();
        //vector.add(room);
        //roomDaoFile.serialization(vector);
        //roomDaoFile.deserialization();
        //roomDaoFile.isRoomPresent("B1");
        //roomDaoFile.insertRoom(room);
        //roomDaoFile.deleteRoom(room);
        //roomDaoFile.updateRoom(room);
        //roomDaoFile.getRoomByName("B5");
        //roomDaoFile.getAllRooms();

    }

}