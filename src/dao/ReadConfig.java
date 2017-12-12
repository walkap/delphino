package dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

    private static final String FILE = "config.properties";
    private static Properties properties;
    private FileInputStream fileInputStream;
    private static ReadConfig instance = null;

    /**
     * Private Default constructor avoid instantiation
     * from external class
     */

    private ReadConfig(){

    }

    /**
     * Signleton Pattern used to have a single instance of this class
     * @return ReadConfig
     */

    private static ReadConfig getInstance(){
        if(instance == null){
            instance = new ReadConfig();
        }
        return instance;
    }

    /**
     * Open a file stream
     *
     * @return FileInputStream
     * @throws IOException
     */

    private FileInputStream openStream() throws IOException {
        fileInputStream = new FileInputStream(FILE);
        return fileInputStream;
    }

    /**
     * Close the file stream
     *
     */

    private void closeStream() {
        try{
            if (fileInputStream != null)
                fileInputStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Load database parameter from configuration file,
     * then return a type Properties that contain an array
     *
     * @return Properties
     */

    public static Properties getProperties() {
        try {
            properties = new Properties();
            properties.load(getInstance().openStream());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            getInstance().closeStream();
        }
        return properties;
    }

    public static void main(String[] args) {
        Properties p = ReadConfig.getProperties();
        System.out.println(p);
    }

}