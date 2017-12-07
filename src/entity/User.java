package entity;

public class User {

    private int id;
    private String name;
    private String surname;

    public User(int id, String name, String surname){
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public void setID(int ID) {
        this.id = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

}
