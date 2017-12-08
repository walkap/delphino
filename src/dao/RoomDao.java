package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RoomDao {

    public void addRoom(String name, int id){
        Statement s = null;
        DataSource ds = new DataSource();
        Connection c = ds.getConnection();
        try{
            s = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql = "insert into Room(name, id) values ('" + name + "'," + id + ")";
            s.executeUpdate(sql);
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ds.closeConnection(c);
            try{
                if(s != null)
                    s.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
