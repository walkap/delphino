package controller;

import dao.TemplateRoomDao;

public class TemplateRoomController {

    public static void createTemplateRoom(String nT, int sT, String bT, int pT, int cT, Boolean dT){
         //createTemplateRoom(nT, sT, bT, pT, cT, dT);
        //TemplateRoom templateRoom = new TemplateRoom(nT, sT, bT, pT, cT, dT);
        TemplateRoomDao tRD = new TemplateRoomDao();
        tRD.addTemplateRoom(nT, sT, bT, pT, cT, dT);
        if (tRD.getRes() == 0){
            System.out.println("Ok Template Room created");
        }else{
            System.out.println("Not work");
        }
    }
}
