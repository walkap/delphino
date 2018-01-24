package control;

import dao.user.UserDao;
import dao.user.UserDaoDb;
import entity.user.User;
import javafx.fxml.LoadException;

public class LoginController {

    private UserDao userDao = new UserDaoDb();

    /**
     * This method is used to return a user if present in the database
     *
     * @param email    - String
     * @param password - String
     * @return User
     * @throws LoadException
     */
    public User getUserIfPresent(String email, String password) throws LoadException {
        if (email == null || password == null) {
            throw new LoadException("Email and password are mandatory!");
        }
        User user = null;
        try {
            user = userDao.getUser(email, password);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return user;
    }
}