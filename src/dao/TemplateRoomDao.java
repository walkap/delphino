package dao;

public class TemplateRoomDao extends AbstractDao {

    private static final String TABLE_NAME = "template_room";
    private static final String COLUMN_NAME = "name_model";
    private static final String COLUMN_BOARD = "board";
    private static final String COLUMN_TEACHER_DESK = "teacher_desk";
    private static final String COLUMN_SEATS = "seats";
    private static final String COLUMN_PROJECTORS = "projectors";
    private static final String COLUMN_COMPUTERS = "computers";

    public void addModelRoom(String nameModel, int seats, String board, int projectors, int computers, Boolean desk) {

        if (!isTemplateRoomPresent(nameModel)) {
            StringBuilder sql = new StringBuilder();
            sql.append("insert into " + TABLE_NAME + "(");
            sql.append(COLUMN_NAME).append(", ");
            sql.append(COLUMN_SEATS).append(", ");
            sql.append(COLUMN_BOARD).append(", ");
            sql.append(COLUMN_PROJECTORS).append(", ");
            sql.append(COLUMN_COMPUTERS).append(", ");
            sql.append(COLUMN_TEACHER_DESK).append(")");
            sql.append(" values(");
            sql.append("'").append(nameModel).append("', ");
            sql.append("'").append(seats).append("', ");
            sql.append("'").append(board).append("', ");
            sql.append("'").append(projectors).append("', ");
            sql.append("'").append(computers).append("', ");
            sql.append("'").append(desk).append("')");
            this.executeUpdate(sql.toString());

            System.out.println("The Template of Room has been added to the database");
        } else {
            System.out.println("Ops!" + nameModel + "already exists in the system");
        }
    }

        /**
         * This method is used to delete {@code templateRoom} object
         * from database
         *
         * @param nameModel - {@code string}
         */

        public void deleteTemplateRoom(String nameModel) {
            if(!isTemplateRoomPresent(nameModel)) {
                StringBuilder sql = new StringBuilder();
                sql.append("DELETE from ").append(TABLE_NAME).append(" WHERE ").append(COLUMN_NAME).append(" = '").append(nameModel).append("'");
                this.executeUpdate(sql.toString());
                System.out.println("The template of room" + nameModel + "has been deleted from database");
            }else{
                System.out.println("We are sorry, the template of room you wanted to delete it doesn't exist");
            }
        }

    /**
     * This method checks if a room is present
     * in the database using the room's id as parameter
     *
     * @param nameModel - TemplateRoom's name
     * @return Boolean
     */
    public Boolean isTemplateRoomPresent(String nameModel) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT from ").append(TABLE_NAME).append(" WHERE ").append(COLUMN_NAME).append(" = '").append(nameModel).append("'");
        System.out.println(sql.toString());
        return this.isPresent(sql.toString());
    }

    public static void main(String[] args) {
        TemplateRoomDao rtd = new TemplateRoomDao();
        //rd.addRoom("C6", 4, "ClassRoom", 0, null, 0, 0, null);
        rtd.addModelRoom("A", 150, "BlackBoard", 2, 0, true);
        //rd.deleteRoom("C4");
        //rd.isRoomPresent("C6");
        //rd.updateRoom();
    }
}


