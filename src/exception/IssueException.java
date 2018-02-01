package exception;

public class IssueException extends Exception{

    public IssueException(String message){
        super("Problem adding the issue to the database: " + message);
    }

}
