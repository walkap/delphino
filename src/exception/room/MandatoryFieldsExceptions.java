package exception.room;

public class MandatoryFieldsExceptions extends Exception {

    public MandatoryFieldsExceptions(String message){
        super("The following field are mandatory: " + message);
    }

    public MandatoryFieldsExceptions(Throwable cause){
        super(cause);
    }

    public MandatoryFieldsExceptions(String message, Throwable cause){
        super(message, cause);
    }

}
