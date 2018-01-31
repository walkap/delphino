package bean;

import control.TemplateRoomController;
import entity.TemplateRoom;

import java.util.Vector;

public class TemplateRoomBean {


    private String nameTemplate;
    private int seats;
    private String board;
    private int projectors;
    private int computers;
    private Boolean desk;
    private TemplateRoomController tRC = new TemplateRoomController();




    public TemplateRoomBean(){

    }

    public TemplateRoom viewTemplateRoom(String nT){
        TemplateRoom templateRoom = tRC.getTemplateRoom(nT);
        return templateRoom;
    }

    public Vector<TemplateRoom> viewAllTemplateRooms(){
        Vector<TemplateRoom> templateRooms = tRC.getTemplateRooms();
        return templateRooms;
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

    public void createTemplateRoom(String n, int s, String b, int p, int c, Boolean d){
        try {
            tRC.createTemplateRoom(n, s, b, p, c, d);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

