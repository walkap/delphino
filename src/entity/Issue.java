package entity;

import entity.room.Room;

import java.io.Serializable;

public class Issue implements Serializable {

    private String name;
    private String area;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public Room getRoom() {
        return room;
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

    private Building building;
    private Room room;
    private String description;
    private String state;

    private static final long serialVersionUID = 1L;


    public Issue (String name, String area, Building building, Room room, String description) {
        this.name = name;
        this.area = area;
        this.building = building;
        this.room = room;
        this.description = description;
        this.state = "New";
    }


    public boolean isEqualTo(Issue i) {

        if (i == null){
            return false;
        }
        if (this.getName().equalsIgnoreCase(i.getName()) && this.getArea().equalsIgnoreCase(i.getArea()) &&
                this.getBuilding().getName().equalsIgnoreCase(i.getBuilding().getName()) &&
                this.getRoom().getName().equalsIgnoreCase(i.getRoom().getName())) {
            return true;
        }
        return false;


    }

}
