package dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig  {

    private static final String FILE = "config.properties";
    private static Properties properties;

    /**
     *
     * Load database parameter from configuration file,
     * then return a type Properties that contain an array
     *
     * @return Properties
     *
     */

    public static Properties getProperties() {

        FileInputStream fileInputStream = null;

        //Try to open a file stream
        try {
            fileInputStream = new FileInputStream(FILE);
            properties = new Properties();
            properties.load(fileInputStream);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try{
                if(fileInputStream != null)
                    fileInputStream.close();
            } catch (IOException e) {
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