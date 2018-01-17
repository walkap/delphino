package exception.room;

public class InsertRoomException extends Exception{

    public InsertRoomException(String message){
        super("Problem adding the room to the database: " + message);
    }

    public InsertRoomException(Throwable cause){
        super(cause);
    }

    public InsertRoomException(String message, Throwable cause){
        super(message, cause);
    }
}
