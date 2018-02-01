package thread;

import bean.IssueBean;
import dao.IssueDao;
import entity.Building;
import entity.Issue;
import entity.room.Room;

public class ThreadManutentore extends Thread{

    public void run() {

        IssueDao dao = new IssueDao();

        Issue i = new Issue("name", new Room("room",
                new Building("building","area")),"Created by ThreadSegretario");
        while (!dao.isIssuePresent(i)) {
            try {
                Thread.sleep(1000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        dao.updateIssue(i, "Assigned to ThreadManutentore");
    }

    public static void main(String args[]){

        new ThreadManutentore().start();
        new ThreadSegretario().start();

    }
}
