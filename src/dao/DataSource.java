package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataSource  {

    private Connection connection;

    /**
     *
     * Returns a connection to the database
     *
     * @return Connection
     *
     */

    public Connection getConnection() {

        Properties properties = ReadConfig.getProperties();

        String user = properties.getProperty("USER");
        String password = properties.getProperty("PASSWORD");
        String dbUrl = properties.getProperty("DB_URL");
        String driver = properties.getProperty("DRIVER_CLASS_NAME");

       try {
           Class.forName(driver);
           connection = DriverManager.getConnection(dbUrl, user, password);
       }
       catch (SQLException | ClassNotFoundException e){
           e.printStackTrace();
       }

       return connection;
    }

}