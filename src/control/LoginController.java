package control;

import dao.factory.DaoFactory;
import dao.user.UserDao;
import entity.user.User;
import exception.user.LoginException;
import javafx.fxml.LoadException;
import util.EmailValidator;

public class LoginController {
    private DaoFactory dbFactory = DaoFactory.getDaoFactory(DaoFactory.DATABASE);
    /**
     * This method is used to return a user if present in the database
     *
     * @param email    - String
     * @param password - String
     * @return User
     * @throws LoadException
     */
    public User getUserIfPresent(String email, String password) throws LoginException {
        if (email == null || password == null) {
            throw new LoginException("Email and password are mandatory!");
        }
        EmailValidator emailValidator = new EmailValidator();
        if (!emailValidator.isValidEmail(email)) {
            throw new LoginException("Invalid email address!");
        }
        UserDao userDao = dbFactory.getUserDao();
        User user = null;
        try {
            user = userDao.getUser(email, password);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return user;
    }
}