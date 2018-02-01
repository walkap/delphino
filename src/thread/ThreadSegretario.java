package thread;

import dao.IssueDao;
import entity.Building;
import entity.Issue;
import entity.room.Room;
import exception.IssueException;

public class ThreadSegretario extends Thread{

    public void run() {

        System.out.println("Inside ThreadSegretario");
        Issue i = new Issue("name", new Room("room",
                new Building("building","area")),"Created by ThreadSegretario");
        IssueDao dao = new IssueDao();
        try {
            dao.addIssue(i);
        }catch(IssueException e){
            e.printStackTrace();
        }
    }
}
