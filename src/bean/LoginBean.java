package bean;

import control.LoginController;
import entity.user.User;
import exception.user.LoginException;

public class LoginBean {

    public String email;
    public String password;

    private void setEmail(String email) {
        this.email = email;
    }

   private void setPassword(String password) {
        this.password = password;
    }

    public LoginBean(){

    }

    public LoginBean(String email, String password) {
        this.email = email;
        this.password = password;
    }

    private String getEmail() {
        return email;
    }

    private String getPassword() {
        return password;
    }

    /**
     * This method validate a user once has tried to login
     *
     * @return boolean
     */
    public boolean validate(String email, String password) {

        LoginController loginController = new LoginController();
        User user = null;
        try {
            user = loginController.getUserIfPresent(email, password);
        } catch (LoginException e) {
            e.printStackTrace();
        }
        return (user != null);
    }
}
