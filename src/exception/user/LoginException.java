package exception.user;

public class LoginException extends Exception {

    public LoginException(String message){
        super("Problem during the login: " + message);
    }

}
