package dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig  {

    private static final String FILE = "config.properties";

    private static Properties properties;

    /**
     * Singleton pattern
     * Load database parameter from configuration file,
     * the database type is not specified, so it is possible
     * to connect to any database
     */
    private ReadConfig(){

    }

    public static Properties getProperties() {

        if (properties == null) {

            properties = new Properties();
        }

            FileInputStream input = null;

        try {
            input = new FileInputStream(FILE);
            properties.load(input);


        } catch (IOException e) {

            System.out.println("File not found");
            e.printStackTrace();
        }
        finally {

            try{

                if (input != null)
                  input.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }

        return properties;

    }

    public static void main(String[] args){

        Properties p = ReadConfig.getProperties();


        System.out.println(p);
    }

}
