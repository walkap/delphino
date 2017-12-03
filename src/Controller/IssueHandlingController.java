package Controller;

import Entity.Issue;
import Entity.Room;
import Entity.Users.User;

import java.util.Date;

public class IssueHandlingController {

    private User user;
    private int id;
    private Date start;
    private Date end;
    private String description;
    private Room room;

    public void createIssue(int id, Date start, Date end, String description, Room room){

        Issue issue = new Issue(id, start, end, description, room);


    }
}
