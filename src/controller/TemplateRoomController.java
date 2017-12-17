package controller;

import dao.TemplateRoomDao;
import entity.TemplateRoom;

public class TemplateRoomController {

    private static TemplateRoomDao tRD = new TemplateRoomDao();


    public static void createTemplateRoom(String nT, int sT, String bT, int pT, int cT, Boolean dT){
         //createTemplateRoom(nT, sT, bT, pT, cT, dT);
        //TemplateRoom templateRoom = new TemplateRoom(nT, sT, bT, pT, cT, dT);
        tRD.addTemplateRoom(nT, sT, bT, pT, cT, dT);
        if (tRD.getRes() == 0){
            System.out.println("Ok Template Room created");
        }else{
            System.out.println("Not work");
        }
    }

    public static void deleteTemplateRoom(String nameTemplate){
        tRD.deleteTemplateRoom(nameTemplate);
        if (tRD.getRes() == 0){
            System.out.println("The template of room " + nameTemplate + " has been deleted from database");
        }else{
            System.out.println("We are sorry, the template of room " + nameTemplate + " you wanted to delete it doesn't exist");
        }
    }

    public static TemplateRoom getTemplateRoom(String nameT) throws NullPointerException{
        TemplateRoom tr = null;

        try {
            tr = tRD.getTemplateRoom(nameT);

        }catch (NullPointerException n) {

        }
        return tr;
    }
}
