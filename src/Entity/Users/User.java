package Entity.Users;

/**This is a generic structure for a User in own application
 * It will be finished in next iteration
 */

public class User {
    private int ID;
    private String name;
    private String surname;

    public User(int ID, String name, String surname){
        this.ID = ID;
        this.name = name;
        this.surname = surname;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
