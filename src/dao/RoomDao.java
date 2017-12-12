package dao;

import entity.room.Room;

public class RoomDao extends AbstractDao {

    private static final String TABLE_NAME = "room";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_TYPE = "type";
    private static final String COLUMN_BUILDING = "building";
    private static final String COLUMN_BOARD = "board";
    private static final String COLUMN_TEACHER_DESK = "teacher_desk";
    private static final String COLUMN_SEATS = "seats";
    private static final String COLUMN_PROJECTORS = "projectors";
    private static final String COLUMN_COMPUTERS = "computers";

    public void addRoom(String name, int building, String type, int seats, String boards, int projectors, int computers, Boolean desk) {
        if(!isRoomPresent(name)){
            StringBuilder sql = new StringBuilder();
            sql.append("insert into " + TABLE_NAME + "(");
            sql.append(COLUMN_NAME).append(", ").append(COLUMN_TYPE).append(", ").append(COLUMN_BUILDING).append(")");
            sql.append(" values(");
            sql.append("'").append(name).append("', ");
            sql.append("'").append(type).append("', ");
            sql.append("'").append(building).append("')");
            this.executeUpdate(sql.toString());

            System.out.println("Yay! The room has been added to the database!");
        }else{
            System.out.println("It's already present a room named " + name + "in the database");
        }
    }

    /**
     * This method is used to delete {@code room} object
     * from database
     *
     * @param name - {@code String}
     */
    public void deleteRoom(String name) {
        if(isRoomPresent(name)){
            StringBuilder sql = new StringBuilder();
            sql.append("DELETE from ").append(TABLE_NAME).append(" WHERE ").append(COLUMN_NAME).append(" = '").append(name).append("'");
            this.executeUpdate(sql.toString());
            System.out.println("The room has been deleted from the database!");
        }else{
            System.out.println("We are sorry, the room you wanted to delete it doesn't exist");
        }
    }

    /**
     * This method checks if a room is present
     * in the database using the room's id as parameter
     *
     * @param name - Room's name
     * @return Boolean
     */
    public Boolean isRoomPresent(String name) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT from ").append(TABLE_NAME).append(" WHERE ").append(COLUMN_NAME).append(" = '").append(name).append("'");
        System.out.println(sql.toString());
        return this.isPresent(sql.toString());
    }

    public static void main(String[] args) {
        RoomDao rd = new RoomDao();
        //rd.addRoom("C6", 4, "ClassRoom", 0, null, 0, 0, null);
        //rd.deleteRoom("C4");
        //rd.isRoomPresent("C6");
        //rd.updateRoom();
    }
}