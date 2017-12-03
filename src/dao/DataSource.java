package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource extends ReadConfig {

    private Connection getConnection() throws SQLException, ClassNotFoundException{

        ReadConfig rc = new ReadConfig();
        rc.load();

        String USER = rc.getUser();
        String PASSWORD = rc.getPassword();
        String DB_URL = rc.getDbUrl();
        String DRIVER = rc.getDriverUrl();

        Connection connection;

        Class.forName(DRIVER);
        connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);

        return connection;
    }

}
