package control;

import bean.IssueBean;
import dao.IssueDao;
import entity.Building;
import entity.Issue;
import entity.room.Room;
import exception.IssueException;

import java.util.ArrayList;

public class IssueHandlerController {

    public void addNewIssue(IssueBean bean) throws IssueException{

        Issue i = new Issue (bean.getName(), new Room(bean.getRoom(),
                new Building(bean.getBuilding(),bean.getArea())),bean.getDescription());
        IssueDao dao = new IssueDao();
        dao.addIssue(i);

    }

    public void updateIssue(IssueBean bean, String state) {

        Issue i = new Issue (bean.getName(), new Room(bean.getRoom(),
                new Building(bean.getBuilding(),bean.getArea())),bean.getDescription());
        IssueDao dao = new IssueDao();
        dao.updateIssue(i, state);
    }


    public ArrayList<IssueBean> getIssueBeans(){

        IssueDao dao = new IssueDao();

        ArrayList<Issue> issues = dao.getIssues();

        ArrayList<IssueBean> beans = IssueBean.getBeans(issues);

        return beans;

    }

    public void deleteIssue(IssueBean bean){

        Issue i = new Issue(bean.getName(), new Room(bean.getRoom(), bean.getBuilding(),
                new Building(bean.getBuilding(),bean.getArea())),bean.getDescription());

        IssueDao dao = new IssueDao();

        dao.deleteIssue(i);
    }


}
