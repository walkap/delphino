package controller;

import bean.IssueBean;
import dao.IssueDao;
import entity.Building;
import entity.Issue;
import entity.room.Room;

import java.util.ArrayList;

public class IssueHandlerController {

    public void addNewIssue(IssueBean bean){

        Issue i = new Issue (bean.getName(), bean.getArea(), new Building(bean.getBuilding(), bean.getArea()), new Room(bean.getRoom()), bean.getDescription());
        IssueDao dao = new IssueDao();
        dao.addIssue(i);

    }

    public void updateIssue(IssueBean bean, String state) {

        Issue i = new Issue (bean.getName(), bean.getArea(), new Building(bean.getBuilding(), bean.getArea()), new Room(bean.getRoom()), bean.getDescription());
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

        Issue i = new Issue(bean.getName(), bean.getArea(), new Building(bean.getBuilding(), bean.getArea()),
                new Room(bean.getRoom()), bean.getDescription());

        IssueDao dao = new IssueDao();

        dao.deleteIssue(i);
    }

    public static void main(String args[]) {

        }

}
