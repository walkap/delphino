package control;

import dao.TemplateRoomDao;
import entity.TemplateRoom;

public class TemplateRoomController {

    private TemplateRoomDao tRD = new TemplateRoomDao();
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


    public Boolean createTemplateRoom(String nT, int sT, String bT, int pT, int cT, Boolean dT) {
        //createTemplateRoom(nT, sT, bT, pT, cT, dT);
        //TemplateRoom boundary.templateRoom = new TemplateRoom(nT, sT, bT, pT, cT, dT);
        Boolean bool = false;
        tRD.addTemplateRoom(nT, sT, bT, pT, cT, dT);
        if (tRD.getRes() == 0) {
            System.out.println("Ok Template Room created");
            bool = true;
        } else {
            System.out.println("Not work");
        }
        return bool;
    }

    public void deleteTemplateRoom(String nameTemplate) {
        tRD.deleteTemplateRoom(nameTemplate);
    }


    public TemplateRoom getTemplateRoom(String nameT) throws NullPointerException {
        TemplateRoom tr = null;
        try {
            tr = tRD.getTemplateRoom(nameT);

        } catch (NullPointerException n) {
            System.exit(1);
        }
        return tr;
    }


    private Boolean areTwoTemplateRoomsEquals(TemplateRoom tr1, TemplateRoom tr2){
        Boolean bool = false;
        String name1 = tr1.getNameTemplate();
        int seats1 = tr1.getSeats();
        String board1 = tr1.getBoard();
        int projectors1 = tr1.getProjectors();
        int computers1 = tr1.getComputers();
        Boolean desk1 = tr1.getDesk();

        String name2 = tr2.getNameTemplate();
        int seats2 = tr2.getSeats();
        String board2 = tr2.getBoard();
        int projectors2 = tr2.getProjectors();
        int computers2 = tr2.getComputers();
        Boolean desk2 = tr2.getDesk();

        System.out.println(name1);
        System.out.println(name2);

        if ((name1.equals(name2))/* & (seats1 == seats2) & (board1 == board2)
                & (projectors1 == projectors2) & (computers1 == computers2) & (desk1 == desk2)*/){
            bool = true;
        }
        return bool;
    }


    public int modifyTemplateRoom(TemplateRoom templateRoom) {
        int res = 0;
        String nameTemplate = templateRoom.getNameTemplate();
        if (tRD.isTemplateRoomPresent(nameTemplate)) {
            TemplateRoom templateRoom2 = tRD.getTemplateRoom(nameTemplate);
            TemplateRoomController tRC = new TemplateRoomController();
            if (tRC.areTwoTemplateRoomsEquals(templateRoom, templateRoom2)) {

                System.out.println(0);
                //The Template Room hasn't been update
            } else {
                tRD.updateTemplateRoom(templateRoom);
                //TemplateRoom not update because the values are equals;
                res = 2;
                System.out.println(2);
            }
        } else {
            //TemplateRoom not update because is not present in db
            System.out.println(1);
            res = 1;
        } return res;
    }

    public static void main(String[] args) {
        TemplateRoomDao rtd = new TemplateRoomDao();
        TemplateRoomController tRC = new TemplateRoomController();
        //rtd.addTemplateRoom("C", 150, "BlackBoard", 2, 0, true);
        //rtd.deleteTemplateRoom("B");
        TemplateRoom tR1 = rtd.getTemplateRoom("D");
        TemplateRoom tR2 = rtd.getTemplateRoom("C");
        Boolean b = tRC.areTwoTemplateRoomsEquals(tR1, tR2);
        System.out.println(b);
        //rtd.getAllTemplateRoom();
        //TemplateRoom tr = new TemplateRoom("C", 150, "White", 3, 20, false);
        //rtd.updateTemplateRoom(tr);

    }
}
