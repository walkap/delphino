import dao.TemplateRoomDao;
import entity.TemplateRoom;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class TemplateRoomDaoTest {

    private TemplateRoomDao tRD = new TemplateRoomDao();
    private TemplateRoom tR1 = null;
    private TemplateRoom tR2 = null;
    private String name = "TEST";
    private int seats = 999;
    private String board = "TEST";
    private int projectors = 999;
    private int computers = 999;
    private Boolean desk = true;

    @Test
    void addTemplateRoom() {

        try {
            try {
                if(tRD.isTemplateRoomPresent(name)){
                    tRD.addTemplateRoom(name, seats, board, projectors, computers, desk);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            tR1 = tRD.getTemplateRoom(name);
            tR2 = new TemplateRoom(name, seats, board, projectors, computers, desk);
            assertEquals(tR1.getNameTemplate(), tR2.getNameTemplate());
            assertEquals(tR1.getSeats(), tR2.getSeats());
            assertEquals(tR1.getBoard(), tR2.getBoard());
            assertEquals(tR1.getProjectors(), tR2.getProjectors());
            assertEquals(tR1.getComputers(), tR2.getComputers());
            assertEquals(tR1.getDesk(), tR2.getDesk());


        }catch (Exception s){
            s.printStackTrace();
        }

    }

    @Test
    void deleteTemplateRoom() {
    }

    @Test
    void getTemplateRoom() {
    }

    @Test
    void updateTemplateRoom() {
    }

    @Test
    void getAllTemplateRoom() {
    }

    @Test
    void isTemplateRoomPresent() {
    }
}