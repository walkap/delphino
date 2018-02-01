package dao;

import entity.TemplateRoom;
import exception.templateRoom.TemplateRoomPresentException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/**
 *  http://code.makery.ch/blog/javafx-dialogs-official/
 *
 */

public class TemplateRoomDao extends AbstractDao {

    private static final String TABLE_NAME = "template_room";
    private static final String COLUMN_NAME = "name_template";
    private static final String COLUMN_BOARD = "board";
    private static final String COLUMN_TEACHER_DESK = "teacher_desk";
    private static final String COLUMN_SEATS = "seats";
    private static final String COLUMN_PROJECTORS = "projectors";
    private static final String COLUMN_COMPUTERS = "computers";
    private static int res;
    private TemplateRoom tr = null;
    private DataSource ds = new DataSource();

    public boolean addTemplateRoom(String nameTemplate, int seats, String board, int projectors, int computers, Boolean desk) throws SQLException {

        try {
            if (!isTemplateRoomPresent(nameTemplate)) {
                StringBuilder sql = new StringBuilder();
                sql.append("insert into " + TABLE_NAME + "(");
                sql.append(COLUMN_NAME).append(", ");
                sql.append(COLUMN_SEATS).append(", ");
                sql.append(COLUMN_BOARD).append(", ");
                sql.append(COLUMN_PROJECTORS).append(", ");
                sql.append(COLUMN_COMPUTERS).append(", ");
                sql.append(COLUMN_TEACHER_DESK).append(")");
                sql.append(" values(");
                sql.append("'").append(nameTemplate).append("', ");
                sql.append("'").append(seats).append("', ");
                sql.append("'").append(board).append("', ");
                sql.append("'").append(projectors).append("', ");
                sql.append("'").append(computers).append("', ");
                sql.append("'").append(desk).append("')");
                this.executeUpdate(sql.toString());

                return true;
            } else {
                return false;
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public int getRes(){
      return res;
    };

    private void setRes(int res){
        this.res = res;
    };


    /**
     * This method is used to delete templateRoom object
     * from database
     *
     * @param nameTemplate - {@code string}
     */

    public void deleteTemplateRoom(String nameTemplate) throws SQLException {

        try {
            if (isTemplateRoomPresent(nameTemplate)) {
                StringBuilder sql = new StringBuilder();
                sql.append("DELETE from ").append(TABLE_NAME)
                        .append(" WHERE ").append(COLUMN_NAME)
                        .append(" = '").append(nameTemplate).append("'");
                this.executeUpdate(sql.toString());
                setRes(0);
            } else {
                setRes(1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }



    /**
     * This method is used to get an existing templateRoom
     *
     * @param nameTemplate - String
     * @return Room
     */

    public TemplateRoom getTemplateRoom(String nameTemplate) throws NullPointerException {
        Connection c = ds.getConnection();
        Statement s = null;

        try {
            s = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT * FROM ").append(TABLE_NAME);
            sql.append(" WHERE " + COLUMN_NAME + "='" + nameTemplate + "'");
            ResultSet rs = s.executeQuery(sql.toString());
            if (rs.next()) try {
                //TemplateRoom tr = new TemplateRoom(rs.getString(COLUMN_NAME));
                tr = new TemplateRoom(rs.getString(COLUMN_NAME),
                        rs.getInt(COLUMN_SEATS),
                        rs.getString(COLUMN_BOARD),
                        rs.getInt(COLUMN_PROJECTORS),
                        rs.getInt(COLUMN_COMPUTERS),
                        rs.getBoolean(COLUMN_TEACHER_DESK));
            } catch (NullPointerException n) {
                n.printStackTrace();
                System.exit(0);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeStatement(s);
            ds.closeConnection(c);
        }
        return tr;
    }

    /**
     * This method is used to update a templateRoom
     *
     * @param templateRoom
     */

    public void updateTemplateRoom(TemplateRoom templateRoom) throws SQLException{
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE " + TABLE_NAME)
                .append(" SET ")
                .append(COLUMN_NAME).append(" = '").append(templateRoom.getNameTemplate()).append("', ")
                .append(COLUMN_BOARD).append(" = '").append(templateRoom.getBoard()).append("', ")
                .append(COLUMN_TEACHER_DESK).append(" = ").append(templateRoom.getDesk()).append(", ")
                .append(COLUMN_SEATS).append(" = ").append(templateRoom.getSeats()).append(", ")
                .append(COLUMN_PROJECTORS).append(" = ").append(templateRoom.getProjectors()).append(", ")
                .append(COLUMN_COMPUTERS).append(" = ").append(templateRoom.getComputers())
                .append(" WHERE ").append(COLUMN_NAME).append(" = '").append(templateRoom.getNameTemplate()).append("'");
        this.executeUpdate(sql.toString());
    }

    /**
     * This method returns all template rooms present in the database
     *
     * @return Vector
     */

    public Vector<TemplateRoom> getAllTemplateRoom() throws NullPointerException {
        Connection c = ds.getConnection();
        Statement s = null;

        Vector<TemplateRoom> vec = new Vector<>();
        try {
            s = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT * FROM " + TABLE_NAME);
            ResultSet rs = s.executeQuery(sql.toString());
            while (rs.next()) {
                try {
                    TemplateRoom tr = new TemplateRoom(rs.getString(COLUMN_NAME),
                            rs.getInt(COLUMN_SEATS),
                            rs.getString(COLUMN_BOARD),
                            rs.getInt(COLUMN_PROJECTORS),
                            rs.getInt(COLUMN_COMPUTERS),
                            rs.getBoolean(COLUMN_TEACHER_DESK));
                    vec.add(tr);

                }catch (NullPointerException n){

                    n.printStackTrace();
                    System.exit(0);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeStatement(s);
            ds.closeConnection(c);
        }
        return vec;
    }


    /**
     * This method checks if a template room is present
     *
     * @param nameTemplate - TemplateRoom's name
     * @return Boolean
     */

    public Boolean isTemplateRoomPresent(String nameTemplate) throws TemplateRoomPresentException {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT from ")
                .append(TABLE_NAME)
                .append(" WHERE ")
                .append(COLUMN_NAME)
                .append(" = '")
                .append(nameTemplate).append("'");
        return this.isPresent(sql.toString());

    }


    public static void main(String[] args) {
        TemplateRoomDao rtd = new TemplateRoomDao();
        //rtd.addTemplateRoom("C", 150, "BlackBoard", 2, 0, true);
        //rtd.deleteTemplateRoom("B");
        //rtd.getTemplateRoom("D");
        //rtd.getAllTemplateRoom();
        //TemplateRoom tr = new TemplateRoom("C", 150, "White", 3, 20, false);
        //rtd.updateTemplateRoom(tr);

    }
}



