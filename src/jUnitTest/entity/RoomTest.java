package entity;

import entity.room.Room;
import entity.room.builder.RoomBuilder;
import entity.room.builder.RoomDirectorBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {
    @Test
    void getRoomTest(){
        RoomDirectorBuilder rdb = new RoomDirectorBuilder();
        RoomBuilder rb = rdb.buildRoom("C5", "ClassRoom", new Building("Didattica", "Ingegneria"))
                .setBoard("black")
                .setComputers(3)
                .setProjectors(1)
                .setSeats(100)
                .setTeacherDesk(true);
        Room room = rb.getRoom();
        assertEquals("C5", room.getName());
        assertEquals("ClassRoom", room.getType());
        assertEquals("Didattica", room.getBuilding().getName());
        assertEquals("Ingegneria", room.getBuilding().getArea());
        assertEquals("black", room.getBoard());
        assertEquals(3, room.getComputers());
        assertEquals(1, room.getProjectors());
        assertEquals(100, room.getSeats());
        assertEquals(true, room.hasTeacherDesk());
    }
}
