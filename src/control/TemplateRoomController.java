package control;

import dao.TemplateRoomDao;
import entity.TemplateRoom;

import java.sql.SQLException;
import java.util.Vector;

public class TemplateRoomController {

    private TemplateRoomDao tRD = new TemplateRoomDao();
    private Vector<TemplateRoom> vec;


    public Boolean createTemplateRoom(String nT, int sT, String bT, int pT, int cT, Boolean dT) {
        Boolean bool = false;
        try {
            tRD.addTemplateRoom(nT, sT, bT, pT, cT, dT);
        }catch (SQLException e){
            e.printStackTrace();
        } finally {
            if (tRD.getRes() == 0) {
                bool = true;
            }
            return bool;
        }

    }

    public void deleteTemplateRoom(String nameTemplate) throws SQLException{
        try {
            tRD.deleteTemplateRoom(nameTemplate);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }


    public TemplateRoom getTemplateRoom(String nameT) throws NullPointerException {
        TemplateRoom tr = null;
        try {
            tr = tRD.getTemplateRoom(nameT);
        } catch (NullPointerException n) {
            n.printStackTrace();
        }
        return tr;
    }

    public Vector<TemplateRoom> getTemplateRooms() throws NullPointerException{
        vec = tRD.getAllTemplateRoom();
        return vec;
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


        if ((name1.equals(name2)) & ((seats1==seats2)) & (board1.equals(board2))
                & (projectors1 == projectors2) & (computers1 == computers2) & (desk1.equals(desk2))){
            bool = true;
        }
        return bool;
    }


    public int modifyTemplateRoom(TemplateRoom templateRoom) {
        int res = 0;
        String nameTemplate = templateRoom.getNameTemplate();
        try {
            if (tRD.isTemplateRoomPresent(nameTemplate)) {
                TemplateRoom templateRoom2 = tRD.getTemplateRoom(nameTemplate);
                TemplateRoomController tRC = new TemplateRoomController();
                if (tRC.areTwoTemplateRoomsEquals(templateRoom, templateRoom2)) {
                    return res;
                    //The Template Room hasn't been update
                } else {
                    try {
                        tRD.updateTemplateRoom(templateRoom);
                    } catch (SQLException e){
                        e.printStackTrace();
                    }
                    //TemplateRoom not update because the values are equals;
                    res = 2;
                }
            } else {
                //TemplateRoom not update because is not present in db
                res = 1;
            }
        }catch (Exception e){
            e.printStackTrace();
        }return res;
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
