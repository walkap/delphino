package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class AbstractDao {

    /**
     * This method is used to add, delete and update
     * @param sql - String
     */

    protected void executeUpdate(String sql){
        Statement s = null;
        DataSource ds = new DataSource();
        Connection c = ds.getConnection();
        try{
            s = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            s.executeUpdate(sql);
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            System.out.println("Closing connection...");
            ds.closeConnection(c);
            try {
                if (s != null) {
                    System.out.println("Closing statement...");
                    s.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    protected Boolean isPresent(String sql){
        Boolean bool = false;
        Statement s = null;
        DataSource ds = new DataSource();
        Connection c = ds.getConnection();

        try{
            s = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = s.executeQuery(sql);

            if (!rs.first()) {
                System.out.println("The room you're looking for is not present...");
            } else {
                bool = true;
                System.out.println("Yay! We found the room you're looking for...");
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            System.out.println("Closing connection...");
            ds.closeConnection(c);
            try {
                if (s != null) {
                    System.out.println("Closing statement...");
                    s.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return bool;
    }
}