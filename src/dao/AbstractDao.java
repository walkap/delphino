package dao;

import java.sql.*;

public abstract class AbstractDao {

    /**
     * This method is used to close the statement
     *
     * @param s - Statement
     */
    protected void closeStatement(Statement s) {
        try {
            if (s != null) {
                s.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is used to close the result set
     *
     * @param rs - ResultSet
     */
    protected void closeResultSet(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is used to add, delete and update
     *
     * @param sql - String
     */

    protected void executeUpdate(String sql) {
        PreparedStatement ps = null;
        DataSource ds = new DataSource();
        Connection c = ds.getConnection();
        try {
            ps = c.prepareStatement(sql, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeStatement(ps);
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
        ResultSet rs = null;
        DataSource ds = new DataSource();
        Connection c = ds.getConnection();
        try {
            s = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = s.executeQuery(sql);
            if (rs.first()) {
                bool = true;
                }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeResultSet(rs);
            this.closeStatement(s);
            ds.closeConnection(c);
        }
        return bool;
    }
}