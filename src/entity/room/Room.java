package entity.room;

public class Room {

    //These variables are mandatory
    private int id;
    private String name;
    private int building;
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
    public Room(String name, String type, int building) {
        this.name = name;
        this.type = type;
        this.building = building;
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
     * @return int
     */
    public int getBuilding() {
        return building;
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
    public int getProjectors() {
        return projectors;
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
    public Boolean hasTeacherDesk() {
        return teacherDesk;
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

    public void setBuilding(int building) {
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