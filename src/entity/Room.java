package entity;

public class Room {

    //These variables are mandatory
    private int id;
    private String name;
    private Building building;
    private int floor;
    private String type;

    //There variable are optional
    private int seats;
    private String board;
    private String projector;
    private int computers;
    private Boolean desk;


    /**
     * Constructor
     *
     * @param id       - Room's id
     * @param name     - Room's name
     * @param building - Room's building
     * @param floor    - Room's floor
     */
    public Room(int id, String name, Building building, int floor) {
        this.id = id;
        this.name = name;
        this.building = building;
        this.floor = floor;
    }

    /**
     * Get the room's id
     *
     * @return int
     */
    public int getId() {
        return id;
    }

    /**
     * Get the room's name
     *
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Get the room's building (place)
     *
     * @return Building
     */
    public Building getBuilding() {
        return building;
    }

    /**
     * Get the room's floor inside the building specified
     * It should be <= building floors
     * @return int
     */
    public int getFloor() {
        return floor;
    }

    /**
     * Get the room's seats
     * This is an optional variable
     * @return int
     */
    public int getSeats() {
        return seats;
    }

    /**
     * Get the room's type of board (e.g. blackboard)
     * This is an optional variable
     * @return String
     */
    public String getBoard() {
        return board;
    }

    /**
     * Get the room's projector type
     * This is an optional variable
     * @return String
     */
    public String getProjector() {
        return projector;
    }

    /**
     * Get the number of computers present
     * in the room
     *
     * @return int
     */
    public int getComputers() {
        return computers;
    }

    /**
     * Boolean to know if the desk is present or not
     *
     * @return Boolean
     */
    public Boolean hasDesk() {
        return desk;
    }

    /**
     * Get the room's type
     *
     * @return String
     */
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

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public void setBoard(String board) {
        this.board = board;
    }

    public void setProjector(String projector) {
        this.projector = projector;
    }

    public void setComputers(int computers) {
        this.computers = computers;
    }

    public void setDesk(Boolean desk) {
        this.desk = desk;
    }

    public void setType(String type) {
        this.type = type;
    }
}
