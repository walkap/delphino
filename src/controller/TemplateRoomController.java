package controller;

import dao.TemplateRoomDao;
import entity.TemplateRoom;

public class TemplateRoomController {

    private static TemplateRoomDao tRD = new TemplateRoomDao();
    private String nameTemplate;
    private int seats;
    private String board;
    private int projectors;
    private int computers;
    private Boolean desk;
    private static int value;


    public static int getValue() {
        return value;
    }

    private static void setValue(int v) {
        value = v;
    }



    public static int createTemplateRoom(String nT, int sT, String bT, int pT, int cT, Boolean dT) {
        //createTemplateRoom(nT, sT, bT, pT, cT, dT);
        //TemplateRoom templateRoom = new TemplateRoom(nT, sT, bT, pT, cT, dT);
        tRD.addTemplateRoom(nT, sT, bT, pT, cT, dT);
        int res = 0;
        if (tRD.getRes() == 0 ) {
            System.out.println("Ok Template Room created");
            return res;
        } else {
            System.out.println("Not work");
            return res = 1;
        }
    }

    public static void deleteTemplateRoom(String nameTemplate) {
        tRD.deleteTemplateRoom(nameTemplate);
        if (tRD.getRes() == 0) {
            System.out.println("The template of room " + nameTemplate + " has been deleted from database");
        } else {
            System.out.println("We are sorry, the template of room " + nameTemplate + " you wanted to delete it doesn't exist");
        }
    }

    public static TemplateRoom getTemplateRoom(String nameT) throws NullPointerException {
        TemplateRoom tr = null;

        try {
            tr = tRD.getTemplateRoom(nameT);

        } catch (NullPointerException n) {
            System.exit(1);
        }
        return tr;
    }

    public static void modifyTemplateRoom(TemplateRoom templateRoom) {
        String nameTemplate = templateRoom.getNameTemplate();
        if (tRD.isTemplateRoomPresent(nameTemplate)) {
            TemplateRoom templateRoom2 = tRD.getTemplateRoom(nameTemplate);
            if(templateRoom2.getBoard() == templateRoom.getBoard() &&
                    templateRoom2.getSeats() == templateRoom.getSeats() &&
                    templateRoom2.getProjectors() == templateRoom.getProjectors() &&
                    templateRoom2.getComputers() == templateRoom.getProjectors() &&
                    templateRoom2.getDesk() == templateRoom.getDesk()){
                setValue(0);
                System.out.println(0);
                //The Template Room hasn't been update
            }else{
                tRD.updateTemplateRoom(templateRoom);
                //TemplateRoom not update because the values are equals;
                setValue(2);
                System.out.println(2);
            }
        } else {
            //TemplateRoom not update because is not present in db
            System.out.println(1);
            setValue(1);
        }
    }
}
