package dao;

import entity.Feature;

import java.io.*;
import java.util.ArrayList;

public class FeatureDaoFileJava {

    private static final String fileName = "templateRoom.ser";

    private boolean isFeaturePresent(Feature f) {

        ArrayList<Feature> myList = deserialize();

        for (int j = 0; j < myList.size(); j++) {
            if (myList.get(j).isEqualTo(f)) {
                return true;
            }
        }
        return false;
    }

    public void addFeature(Feature f) {

        ArrayList<Feature> myList = new ArrayList<>();

        if (!isFeaturePresent(f)) {

            myList = deserialize();
            myList.add(f);
            this.serialize(myList);
            System.out.println("Feature added");
            return;
        }
        System.out.println("Feature exist");

    }

    public void deleteFeature(Feature f) {
        ArrayList<Feature> myList = new ArrayList<>();

        if (isFeaturePresent(f)) {
            myList = deserialize();
            for (int j = 0; j < myList.size(); j++) {
                if (myList.get(j).isEqualTo(f)) {
                    myList.remove(j);
                    System.out.println("Feature deleted");
                    this.serialize(myList);
                    return;
                }

            }
        }
        System.out.println("Feature not present");
    }


    private void serialize(ArrayList<Feature> list) {
        try {
            FileOutputStream file = new FileOutputStream(fileName);
            ObjectOutputStream o = new ObjectOutputStream(file);
            o.writeObject(list);

            o.close();
            file.close();

            System.out.println("Object List has been serialized");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private ArrayList<Feature> deserialize() {


        ArrayList<Feature> myList = new ArrayList<>();

        try {
            FileInputStream file = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(file);
            myList = (ArrayList<Feature>) in.readObject();

        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();

        }

        System.out.println("Begin list");
        for (int j = 0; j < myList.size(); j++) {

            System.out.println(myList.get(j).getDescription());
        }
        System.out.println("end list");

        return myList;

    }public ArrayList<Feature> getFeatures() {

        ArrayList<Feature> list = new ArrayList<>();


        list = deserialize();

        return list;

    }


    public Feature getFeature(String name) {
        FeatureDaoFileJava fDFJ = new FeatureDaoFileJava();
        ArrayList<Feature> myList = fDFJ.deserialize();
        Feature f = new Feature(name);

        for (int j = 0; j < myList.size(); j++) {

            if (myList.get(j).isEqualTo(f)) {

                Feature newFeature = new Feature(myList.get(j).getName()
                        , myList.get(j).getDescription());
                return newFeature;
            }
            return f = null;

        }
        return f = null;

    }
}
