package entity;

import entity.room.Room;

import java.io.Serializable;

public class Issue implements Serializable {

    private String name;
    private Room room;
    private String description;
    private String state;

    private static final long serialVersionUID = 1L;


    public Issue (String name, Room room, String description) {
        this.name = name;
        this.room = room;
        this.description = description;
        this.state = "New";
    }


    public boolean isEqualTo(Issue i) {

        if (i == null){
            return false;
        }
        return (this.getName().equals(i.getName()) && this.getRoom().getName().equals(i.getRoom().getName())
                 && this.getRoom().getBuilding().getName().equals(i.getRoom().getBuilding().getName())
                  && this.getRoom().getBuilding().getArea().equals(i.getRoom().getBuilding().getArea()));

    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Room getRoom() {
        return this.room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}
