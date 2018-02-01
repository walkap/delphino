package entity;

import entity.room.Room;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IssueTest {

    @Test
    void getName() {

        Issue i = new Issue("name", new Room("room",
                new Building("building","area")),"Created by ThreadSegretario");
        assertEquals("building", i.getRoom().getBuilding().getName());
    }

    @Test
    void isEqualTo() {
    }

    @Test
    void setName() {
    }

    @Test
    void getRoom() {
    }

    @Test
    void setRoom() {
    }

    @Test
    void getDescription() {
    }

    @Test
    void setDescription() {
    }

    @Test
    void getState() {
    }

    @Test
    void setState() {
    }
}