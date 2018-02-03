package dao;

import entity.Issue;
import exception.IssueException;

import java.io.*;
import java.util.ArrayList;

public class IssueDao {

    private static final String fileName = "/delphino/Issue.ser";

    public boolean isIssuePresent(Issue i) {

        ArrayList<Issue> myList = deserialize();

        for (int j = 0; j < myList.size(); j++) {

            if (myList.get(j).isEqualTo(i)){
                return true;
            }
        }

        return false;

    }

    public void addIssue(Issue i) throws IssueException{

        ArrayList<Issue> myList = new ArrayList<>();

        if (!isIssuePresent(i)){

            myList = deserialize();
            myList.add(i);
            this.serialize(myList);
            System.out.println("Issue added!");
            return;
        }

        throw new IssueException("Issue already present!");

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
        }
    }

    public void deleteIssue(Issue i) {
        ArrayList<Issue> myList = new ArrayList<>();

            myList = deserialize();
            for (int j = 0; j < myList.size(); j++) {
                if (myList.get(j).isEqualTo(i)) {
                    myList.remove(j);
                    System.out.println("Issue removed!");
                    if (myList.size() == 0) {
                        try {
                            PrintWriter writer = new PrintWriter(fileName);
                            writer.print("");
                            writer.close();
                            return;
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                    this.serialize(myList);
                    return;
                }
            }
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
        }
    }

    public ArrayList<Issue> getIssues() {

     ArrayList<Issue> list = new ArrayList<>();


     list = deserialize();

     return list;

    }

    public void updateIssue (Issue i, String state) {

        System.out.println(i.getName()+ "" + i.getRoom().getName());

        System.out.println("old state :"+ i.getState());
            ArrayList<Issue> list = deserialize();
            for (int j = 0; j < list.size(); j++) {

                System.out.println(list.get(j).getName()+ "" + list.get(j).getRoom().getName());

                if (list.get(j).isEqualTo(i)) {
                    list.get(j).setState(state);
                    this.serialize(list);
                    System.out.println("new state: " + list.get(j).getState());
                    System.out.println("Issue updated!");
                    return;
                }
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
                    System.out.println("deserialization");

                }
        catch(IOException e){
            e.printStackTrace();

        }

        for (int j = 0; j < myList.size(); j++) {

            System.out.println(myList.get(j).getState());
        }

        return myList;

    }
}