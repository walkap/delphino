package dao.user;

import dao.AbstractDao;
import dao.DataSource;
import entity.user.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class UserDaoDb extends AbstractDao implements UserDao{

    private static final String TABLE_NAME = "user";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_SURNAME = "surname";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_TYPE = "type";
    private static final String COLUMN_PASSWORD = "password";

    private DataSource ds = new DataSource();

    @Override
    public void insertUser(User user){
        StringBuilder sql = new StringBuilder();
        sql.append("insert into ").append(TABLE_NAME).append("(")
                .append(COLUMN_NAME).append(", ")
                .append(COLUMN_SURNAME).append(", ")
                .append(COLUMN_EMAIL).append(")")
                .append(" values(")
                .append("'").append(user.getName()).append("', ")
                .append("'").append(user.getSurname()).append("', ")
                .append("'").append(user.getEmail()).append("')");
        this.executeUpdate(sql.toString());
    }

    @Override
    public void deleteUser(User user){
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE from ")
                .append(TABLE_NAME)
                .append(" WHERE ")
                .append(COLUMN_EMAIL).append(" = '").append(user.getEmail()).append("'");
        this.executeUpdate(sql.toString());
    }

    @Override
    public void updateUser(User user) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE " + TABLE_NAME)
                .append(" SET ")
                .append(COLUMN_NAME).append(" = '").append(user.getName().toUpperCase()).append("', ")
                .append(COLUMN_SURNAME).append(" = '").append(user.getSurname()).append("', ")
                .append(COLUMN_EMAIL).append(" = '").append(user.getEmail()).append("')");
        this.executeUpdate(sql.toString());
    }

    @Override
    public User getUser(String email, String password) throws NullPointerException {
        Statement s = null;
        Connection c = ds.getConnection();
        ResultSet rs = null;
        User user = null;
        try{
            s = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT * FROM ").append("\"").append(TABLE_NAME).append("\"")
                    .append(" WHERE ")
                    .append(COLUMN_EMAIL)
                    .append(" = '").append(email).append("'")
                    .append(" AND ")
                    .append("\"").append(COLUMN_PASSWORD).append("\"")
                    .append(" = '").append(password).append("'");

            System.out.println(sql.toString());
            rs = s.executeQuery(sql.toString());
            if(rs.next()){
                user = new User(rs.getString(COLUMN_NAME), rs.getString(COLUMN_SURNAME), rs.getString(COLUMN_EMAIL));
                user.setType(rs.getString(COLUMN_TYPE));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            this.closeResultSet(rs);
            this.closeStatement(s);
            ds.closeConnection(c);
        }
        return user;
    }

    @Override
    public Vector<User> getAllUsers() {
        Statement s = null;
        Connection c = ds.getConnection();
        ResultSet rs = null;
        Vector<User> vec = new Vector<>();
        try {
            s = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT * FROM " + TABLE_NAME);
            rs = s.executeQuery(sql.toString());
            while (rs.next()) {
                User user = new User(rs.getString(COLUMN_NAME), rs.getString(COLUMN_SURNAME), rs.getString(COLUMN_EMAIL));
                user.setType(COLUMN_TYPE);
                vec.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeResultSet(rs);
            this.closeStatement(s);
            ds.closeConnection(c);
        }
        return vec;
    }
}
