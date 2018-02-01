package exception.templateRoom;

public class TRequals extends Exception {

    public TRequals(String message){
        super("Template Rooms are equals" + message);
    }

    /*public TRequals (Throwable cause) {
        super(cause);
    }

    public TRequals (String message, Throwable cause) {
        super("  " + message + "  ", cause);
    }*/
}
