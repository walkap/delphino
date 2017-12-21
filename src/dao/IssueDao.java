package dao;

import entity.Issue;

import java.io.*;
import java.util.ArrayList;

public class IssueDao {

    private static final String fileName = "Issue.ser";

    public boolean isIssuePresent(Issue i) {

        ArrayList<Issue> myList = deserialize();

        for (int j = 0; j < myList.size(); j++) {

            if (myList.get(j).isEqualTo(i)){
                return true;
            }
        }

        return false;

    }

    public void addIssue(Issue i) {

        ArrayList<Issue> myList = new ArrayList<>();

        if (!isIssuePresent(i)){

            myList = deserialize();
            myList.add(i);
            this.serialize(myList);
            System.out.println("Issue added!");
            return;
        }

        System.out.println("Issue already present!");

    }

    public void serialize (ArrayList<Issue> list) {
        try {
            //Saving of object in a file
            FileOutputStream file = new FileOutputStream(fileName);
            ObjectOutputStream o = new ObjectOutputStream(file);

            // Method for serialization of object
            o.writeObject(list);

            o.close();
            file.close();

            System.out.println("Object List has been serialized");

        }

        catch(IOException ex)
        {
            ex.printStackTrace();
            System.out.println("IOException is caught");
        }
    }

    public void deleteIssue(Issue i) {
        ArrayList<Issue> myList = new ArrayList<>();

        if (isIssuePresent(i)) {
            myList = deserialize();
            for (int j = 0; j < myList.size(); j++) {
                if (myList.get(j).isEqualTo(i)) {
                    myList.remove(j);
                    System.out.println("Issue removed!");
                    this.serialize(myList);
                    return;
                }

            }
        }
        System.out.println("Issue not present!");
    }

    public void serialize(Issue i) {

        ArrayList<Issue> myList = deserialize();

        myList.add(i);

        try {
            //Saving of object in a file
            FileOutputStream file = new FileOutputStream(fileName);
            ObjectOutputStream o = new ObjectOutputStream(file);

            // Method for serialization of object
            o.writeObject(myList);

            o.close();
            file.close();

            System.out.println("Object has been serialized");

        }

        catch(IOException ex)
        {
            ex.printStackTrace();
            System.out.println("IOException is caught");
        }
    }

    public ArrayList<Issue> getIssues() {

     ArrayList<Issue> list = new ArrayList<>();


     list = deserialize();

     return list;

    }

    public void updateIssue (Issue i, String state) {

        System.out.println("old state :"+ i.getState());
        if (isIssuePresent(i)) {
            ArrayList<Issue> list = deserialize();
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).isEqualTo(i)) {
                    list.get(j).setState(state);
                    this.serialize(list);
                    System.out.println("new state: " + list.get(j).getState());
                    System.out.println("Issue updated!");
                    return;
                }
            }
        }
        else{
            System.out.println("Issue not found!");
            return;
            }
    }

    public ArrayList<Issue> deserialize() {


        ArrayList<Issue> myList = new ArrayList<>();

        try {
            // Reading the object from a file
            FileInputStream file = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(file);
            myList = (ArrayList <Issue>)in.readObject();

        }catch (ClassNotFoundException e){
            e.printStackTrace();

        }catch(EOFException ex)
                {
                    System.out.println("IOException is caught reeeee");

                }
        catch(IOException e){
            e.printStackTrace();

        }

        System.out.println("Begin list");
        for (int j = 0; j < myList.size(); j++) {

            System.out.println(myList.get(j).getState());
        }
        System.out.println("end list");

        return myList;

    }
}