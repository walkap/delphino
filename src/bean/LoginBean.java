package bean;


import control.LoginController;
import entity.user.User;
import exception.user.LoginException;

public class LoginBean {

    private String email;
    private String password;

    public LoginBean(String email, String password) {
        this.email = email;
        this.password = password;
    }

    private String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    /**
     * This method validate a user once has tried to login
     * @return boolean
     */
    public boolean validate() {
        LoginController loginController = new LoginController();
        User user = null;
        try {
            user = loginController.getUserIfPresent(getEmail(), getPassword());
        } catch (LoginException e) {
            e.printStackTrace();
        }
        return (user != null);
    }
}
