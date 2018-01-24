package dao.user;

import entity.user.User;

import java.util.Vector;

public interface UserDao {

    /**
     * This abstract method insert a new user
     *
     * @param user - User
     */
    void insertUser(User user);

    /**
     * This abstract method delete an existing user
     *
     * @param user - User
     */
    void deleteUser(User user);

    /**
     * This abstract method update an existing user
     *
     * @param user - User
     */
    void updateUser(User user);

    /**
     * This abstract method get a user from the database
     *
     * @param email - String
     * @return User
     */
    User getUser(String email, String password);

    /**
     * This abstract method get a vector of users from the database
     *
     * @return Vector
     */
    Vector<User> getAllUsers();

}
