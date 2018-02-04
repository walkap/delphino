package exception.room;

public class RoomAlreadyExistsExceptions extends Exception{

    public RoomAlreadyExistsExceptions(String message){
        super("Problem adding the room to the database: " + message);
    }

    public RoomAlreadyExistsExceptions(Throwable cause){
        super(cause);
    }

    public RoomAlreadyExistsExceptions(String message, Throwable cause){
        super(message, cause);
    }
}
