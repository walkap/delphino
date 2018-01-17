package dao;

import entity.Feature;

import java.io.*;
import java.util.ArrayList;

public class FeatureDaoFileJava {

    private static final String fileName = "feature.ser";

    public void newFeatureFile() {
        String path = "src/feature.ser";
        try {
            File file = new File(path);

            if (file.exists())
                System.out.println("Il file " + path + " esiste");
            else if (file.createNewFile())
                System.out.println("Il file " + path + " è stato creato");
            else
                System.out.println("Il file " + path + " non può essere creato");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateFeature (Feature f) {
        String nameF = f.getName();
        String descriptionF = f.getDescription();
        try {
            if(isFeaturePresent(f)){
                ArrayList<Feature> list = deserialize();
                for (int j=0; j < list.size(); j++){
                    if(list.get(j).isEqualTo(f)){
                        list.get(j).setName(nameF);
                        list.get(j).setDescription(descriptionF);
                        this.serialize(list);
                        System.out.println("Feature updated!");
                        return;
                    }
                }
            }else {
                System.out.println("Feature not found!");
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean isFeaturePresent(Feature f) throws Exception{

        ArrayList<Feature> myList = deserialize();

        for (int j = 0; j < myList.size(); j++) {
            if (myList.get(j).isEqualTo(f)) {
                return true;
            }
        }
        return false;
    }

    public void addFeature(Feature f) throws Exception {

        ArrayList<Feature> myList = new ArrayList<>();

        try {
            if (!isFeaturePresent(f)) {

                myList = deserialize();
                myList.add(f);
                this.serialize(myList);
                System.out.println("Feature added");
                return;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Feature exist");

    }

    public void deleteFeature(Feature f) throws Exception {
        ArrayList<Feature> myList = new ArrayList<>();
        File file = new File(fileName);
        if(!file.exists()) {
            FeatureDaoFileJava fDFJ = new FeatureDaoFileJava();
            fDFJ.newFeatureFile();
        }
        try {
            if (isFeaturePresent(f)) {
                myList = deserialize();
                for (int j = 0; j < myList.size(); j++) {
                    if (myList.get(j).isEqualTo(f)) {
                        myList.remove(j);
                        System.out.println("Feature deleted");
                        if (myList.size() == 0) {
                            try {
                                PrintWriter writer = new PrintWriter(fileName);
                                writer.print("");
                                writer.close();
                                return;
                            }catch (FileNotFoundException e){
                                e.printStackTrace();
                            }
                        }
                        this.serialize(myList);
                        return;
                    }

                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Feature not present");
    }


    private void serialize(ArrayList<Feature> list) {
        try {
            File file = new File(fileName);
            if(!file.exists()) {
                FeatureDaoFileJava fDFJ = new FeatureDaoFileJava();
                fDFJ.newFeatureFile();
            }
            FileOutputStream fileOS = new FileOutputStream(fileName);
            ObjectOutputStream o = new ObjectOutputStream(fileOS);
            o.writeObject(list);
            o.close();
            fileOS.close();
            System.out.println("Object List has been serialized");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private ArrayList<Feature> deserialize() {


        ArrayList<Feature> myList = new ArrayList<>();
        File file = new File(fileName);
        if(!file.exists()) {
            FeatureDaoFileJava fDFJ = new FeatureDaoFileJava();
            fDFJ.newFeatureFile();
        }
        try {
            FileInputStream fileOS = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(fileOS);
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

    }

    public ArrayList<Feature> getFeatures() throws Exception {

        ArrayList<Feature> list = new ArrayList<>();

        list = deserialize();

        return list;

    }


    public Feature getFeature(String name) throws Exception {
        FeatureDaoFileJava fDFJ = new FeatureDaoFileJava();
        ArrayList<Feature> myList = fDFJ.deserialize();
        Feature f = new Feature(name);

        for (int j = 0; j < myList.size(); j++) {

            if (myList.get(j).isEqualTo(f)) {

                Feature newFeature = new Feature(myList.get(j).getName()
                        , myList.get(j).getDescription());
                return newFeature;
            }else{
                f = null;
            }
        }
        return f;
    }
}
