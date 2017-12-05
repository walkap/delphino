package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataSource  {

    /**
     * Returns a connection to the database
     * @return Connection
     *
     */
    private Properties properties;

    private Connection connection;

    private String USER, PASSWORD, DB_URL, DRIVER;


    public Connection getConnection() {

        properties = ReadConfig.getProperties();

        USER = properties.getProperty("USER");
        PASSWORD = properties.getProperty("PASSWORD");
        DB_URL = properties.getProperty("DB_URL");
        DRIVER = properties.getProperty("DRIVER_CLASS_NAME");
       try {
           Class.forName(DRIVER);
           connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
       }
       catch (SQLException | ClassNotFoundException e){

           e.printStackTrace();

       }
        return connection;
    }

}
