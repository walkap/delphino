package dao;

import java.sql.*;

public abstract class AbstractDao {


    /**
     * This method is used to close the statement
     * @param s - Statement
     */
    protected void closeStatement(Statement s){
        try {
            if (s != null) {
                System.out.println("Closing statement...");
                s.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is used to close the result set
     * @param rs - ResultSet
     */
    protected void closeResultSet(ResultSet rs){
        try{
            if(rs != null) {
                rs.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * This method is used to add, delete and update
     *
     * @param sql - String
     */

    protected void executeUpdate(String sql) {
        Statement s = null;
        DataSource ds = new DataSource();
        Connection c = ds.getConnection();
        try {
            s = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            s.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Closing statement...");
            this.closeStatement(s);
            System.out.println("Closing connection...");
            ds.closeConnection(c);
        }
    }

    /**
     * This method check if an object is present in the database
     * returns a boolean
     *
     * @param sql - String
     * @return Boolean
     */

    protected Boolean isPresent(String sql) {
        Boolean bool = false;
        Statement s = null;
        DataSource ds = new DataSource();
        Connection c = ds.getConnection();
        try {
            s = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = s.executeQuery(sql);
            if (!rs.first()) {
                System.out.println("The room you're looking for is not present...");
            } else {
                bool = true;
                System.out.println("Yay! We found the room you're looking for...");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Closing statement...");
            this.closeStatement(s);
            System.out.println("Closing connection...");
            ds.closeConnection(c);
        }
        return bool;
    }

}