package entity.room;

import entity.Building;

import java.io.Serializable;

public class Room implements Serializable{

    private static final long serialVersionUID = 1L;

    //These variables are mandatory
    private int id;
    private String name;
    private Building building;
    private String type;

    //There variable are optional
    private int seats;
    private String board;
    private int projectors;
    private int computers;
    private Boolean teacherDesk;

    /**
     * Constructor
     *
     * @param name     - Room's name
     * @param building - Room's building
     */
    public Room(String name, String type, Building building) {
        this.name = name;
        this.type = type;
        this.building = building;
    }

    public Room(String name, Building building) {
        this.name = name;
        this.building = building;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Building getBuilding() {
        return building;
    }

    public int getSeats() {
        return seats;
    }

    public String getBoard() {
        return board;
    }

    public int getProjectors() {
        return projectors;
    }

    public int getComputers() {
        return computers;
    }

    public Boolean hasTeacherDesk() {
        return teacherDesk;
    }

    public String getType() {
        return type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public void setBoard(String board) {
        this.board = board;
    }

    public void setProjectors(int projectors) {
        this.projectors = projectors;
    }

    public void setComputers(int computers) {
        this.computers = computers;
    }

    public void setTeacherDesk(Boolean teacherDesk) {
        this.teacherDesk = teacherDesk;
    }

    public void setType(String type) {
        this.type = type;
    }
}