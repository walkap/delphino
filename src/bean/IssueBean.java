package bean;

import dao.IssueDao;
import entity.Issue;

import java.io.Serializable;
import java.util.ArrayList;

public class IssueBean {

    private String name;
    private String area;
    private String building;
    private String room;
    private String description;
    private String state;

    private static final long serialVersionUID = 1L;


    public IssueBean (String name, String area, String building, String room, String description) {
        this.name = name;
        this.area = area;
        this.building = building;
        this.room = room;
        this.description = description;
        this.state = "New";
    }
    public IssueBean (String name, String area, String building, String room, String description, String state) {
        this.name = name;
        this.area = area;
        this.building = building;
        this.room = room;
        this.description = description;
        this.state = state;
    }

//    public boolean equals(Object obj) {
//
//        IssueBean other = (IssueBean) obj;
//        if (obj == null){
//            return false;
//        }
//        if (this.getName().equals(other.getName()) && this.getArea().equals(other.getArea()) &&
//                this.getBuilding().equals(other.getBuilding()) &&
//                this.getRoom().equals(other.getRoom())) {
//            return true;
//        }
//        return false;
//    }
    public static IssueBean getBean(Issue i) {
        return new IssueBean( i.getName(), i.getArea(),i.getBuilding().getName(),
                i.getRoom().getName(), i.getDescription(), i.getState());

    }

    public static ArrayList<IssueBean> getBeans(ArrayList<Issue> list) {

        IssueDao dao = new IssueDao();

        ArrayList<Issue> issueList = dao.getIssues();

        ArrayList<IssueBean> beanList = new ArrayList<IssueBean>();

        int len = issueList.size();
        for (int i = 0; i < len; i++) {

            beanList.add(getBean(issueList.get(i)));
        }

        return beanList;


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
