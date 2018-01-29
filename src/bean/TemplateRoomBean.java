package bean;

import control.TemplateRoomController;

public class TemplateRoomBean {


    private String nameTemplate;
    private int seats;
    private String board;
    private int projectors;
    private int computers;
    private Boolean desk;
    private TemplateRoomController tRC = new TemplateRoomController();


    /**
     * Constructor
     *
     * @param nameTemplate - TemplateRoom's name
     * @param seats - TemplateRoom's seats
     * @param board - TemplateRoom's board
     * @param projectors - TemplateRoom's projectors
     * @param computers - TemplateRoom's computers
     * @param desk - TemplateRoom's desk
     */

    public TemplateRoomBean(String nameTemplate, int seats, String board, int projectors, int computers, Boolean desk){
        this.nameTemplate = nameTemplate;
        this.seats = seats;
        this.board = board;
        this.projectors = projectors;
        this.computers = computers;
        this.desk = desk;

    }

    /**
     * Setter and getter of TemplateRoomBean
     */

    public String getNameTemplate() {
        return nameTemplate;
    }

    public void setNameTemplate(String nameTemplate) {
        this.nameTemplate = nameTemplate;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public String getBoard() {
        return board;
    }

    public void setBoard(String board) {
        this.board = board;
    }

    public int getProjectors() {
        return projectors;
    }

    public void setProjectors(int projectors) {
        this.projectors = projectors;
    }

    public int getComputers() {
        return computers;
    }

    public void setComputers(int computers) {
        this.computers = computers;
    }

    public Boolean getDesk() {
        return desk;
    }

    public void setDesk(Boolean desk) {
        this.desk = desk;
    }

    public void createTemplateRoom(){
        try {
            tRC.createTemplateRoom(nameTemplate, seats, board, projectors, computers, desk);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

