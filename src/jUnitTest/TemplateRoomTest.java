import entity.TemplateRoom;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TemplateRoomTest {

    @Test
    void getNameTemplate() {
        TemplateRoom templateRoom = new TemplateRoom("a", 150, "Nero", 2, 0, true);
        assertEquals(150, templateRoom.getSeats());
    }

    @Test
    void setNameTemplate() {
    }

    @Test
    void getSeats() {
    }

    @Test
    void setSeats() {
    }


}