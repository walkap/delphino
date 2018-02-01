package exception.templateRoom;

public class TemplateRoomPresentException extends Exception {

    public TemplateRoomPresentException(String message){
        super("Template Room is not present" + message);
    }
    /*public TemplateRoomPresentException (Throwable cause) {
        super(cause);
    }

    public TemplateRoomPresentException (String message, Throwable cause) {
        super("  " + message + " ", cause);
    }*/
}
