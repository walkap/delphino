package Entity;

import java.util.Date;

public class Issue  {

    private int id;
    private Date start;
    private Date end;
    private String description;
    private Room room;

    public Issue(int id, Date start, Date end, String description, Room room){
        this.id = id;
        this.start = start;
        this.end = end;
        this.description = description;
        this.room = room;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
