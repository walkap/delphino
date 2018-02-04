package dao.user;

import entity.Issue;
import entity.user.User;

import java.io.*;
import java.util.ArrayList;
import java.util.Vector;

public class UserDaoFile implements UserDao{

    private static final String fileName = "/delphino/user.ser";

    @Override
    public void insertUser(User user) {


        ArrayList<User> myList = new ArrayList<>();


            myList = deserialize();
            myList.add(user);
            this.serialize(myList);



    }

    @Override
    public void deleteUser(User user) {
        ArrayList<User> myList = new ArrayList<>();

        myList = deserialize();
        for (int j = 0; j < myList.size(); j++) {
            if (myList.get(j).getEmail().equals(user.getEmail())
                    && myList.get(j).getPassword().equals(user.getPassword())) {
                myList.remove(j);
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

    @Override
    public void updateUser(User user) {

        ArrayList<User> myList = new ArrayList<>();

        myList = deserialize();
        for (int j = 0; j < myList.size(); j++) {
            if (myList.get(j).getEmail().equals(user.getEmail())
                    && myList.get(j).getPassword().equals(user.getPassword())) {
                myList.get(j).setEmail(user.getEmail());
                myList.get(j).setSurname(user.getSurname());
                myList.get(j).setName(user.getName());

                }
                this.serialize(myList);
                return;
            }

    }

    @Override
    public User getUser(String email, String password) {

        ArrayList<User> myList = new ArrayList<>();

        myList = deserialize();
        for (int j = 0; j < myList.size(); j++) {
            if (myList.get(j).getEmail().equals(email)
                    && myList.get(j).getPassword().equals(password)) {
                 myList.get(j);

                this.serialize(myList);
                return myList.get(j);


            }
        }
        return null;
    }

    @Override
    public Vector<User> getAllUsers() {
        ArrayList<User> myList = new ArrayList<>();

        myList = deserialize();
        Vector <User> list = new Vector<>();
        list.addAll(0, myList);
        return list;
    }

    public void serialize(ArrayList<User> list) {

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

    public ArrayList<User> deserialize() {


        ArrayList<User> myList = new ArrayList<>();

        try {
            // Reading the object from a file
            FileInputStream file = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(file);
            myList = (ArrayList <User>)in.readObject();

        }catch (ClassNotFoundException e){
            e.printStackTrace();

        }catch(EOFException ex)
        {
            System.out.println("deserialization");

        }
        catch(IOException e){
            e.printStackTrace();

        }

        return myList;

    }
}
