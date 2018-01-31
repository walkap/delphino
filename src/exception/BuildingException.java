package exception;

public class BuildingException extends Exception {

    public BuildingException(String message){
        super("Problem adding the building to the database: " + message);
    }
}
