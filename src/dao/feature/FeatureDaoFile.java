package dao.feature;

import entity.Feature;

import java.io.*;
import java.util.ArrayList;

public class FeatureDaoFile implements FeatureDao{

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
                    if(list.get(j).getName().equals(f.getName())){
                        list.get(j).setName(nameF);
                        list.get(j).setDescription(descriptionF);
                        this.serialize(list);
                        return;
                    }
                }
            }else {
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isFeaturePresent(Feature f){

        ArrayList<Feature> myList = deserialize();

        for (int j = 0; j < myList.size(); j++) {
            if (myList.get(j).getName().equals(f.getName())) {
                return true;
            }
        }
        return false;
    }

    public void insertFeature(Feature f)  {

        ArrayList<Feature> myList = new ArrayList<>();

        try {
            if (!isFeaturePresent(f)) {

                myList = deserialize();
                myList.add(f);
                this.serialize(myList);
                return;
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void deleteFeature(Feature f) {
        ArrayList<Feature> myList = new ArrayList<>();
        File file = new File(fileName);
        if(!file.exists()) {
            FeatureDaoFile fDFJ = new FeatureDaoFile();
            fDFJ.newFeatureFile();
        }
        try {
            if (isFeaturePresent(f)) {
                myList = deserialize();
                for (int j = 0; j < myList.size(); j++) {
                    if (myList.get(j).isEqualTo(f)) {
                        myList.remove(j);
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
    }


    private void serialize(ArrayList<Feature> list) {
        try {
            File file = new File(fileName);
            if(!file.exists()) {
                FeatureDaoFile fDFJ = new FeatureDaoFile();
                fDFJ.newFeatureFile();
            }
            FileOutputStream fileOS = new FileOutputStream(fileName);
            ObjectOutputStream o = new ObjectOutputStream(fileOS);
            o.writeObject(list);
            o.close();
            fileOS.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private ArrayList<Feature> deserialize() {

        ArrayList<Feature> myList = new ArrayList<>();
        File file = new File(fileName);
        if(!file.exists()) {
            FeatureDaoFile fDFJ = new FeatureDaoFile();
            fDFJ.newFeatureFile();
        }
        try {
            FileInputStream fileOS = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(fileOS);
            myList = (ArrayList<Feature>) in.readObject();

        } catch (EOFException e){

            System.out.println("EOF reached!");
        }catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();

        }

        System.out.println("BEGIN LIST...");
        for (int j = 0; j < myList.size(); j++) {

            System.out.println(myList.get(j).getName());
            System.out.println(myList.get(j).getDescription());
        }
        System.out.println("...END LIST");

        return myList;

    }

    public ArrayList<Feature> getFeatures() {

        ArrayList<Feature> list = new ArrayList<>();

        list = deserialize();

        return list;

    }


    public Feature getFeature(String nameF) {
        FeatureDaoFile fDFJ = new FeatureDaoFile();
        ArrayList<Feature> myList = fDFJ.deserialize();
        for (int j = 0; j < myList.size(); j++) {

            if ((myList.get(j).getName()).equals(nameF)) {
                Feature newFeature = new Feature(myList.get(j).getName()
                        , myList.get(j).getDescription());
                return newFeature;
            }
        }
        return null;
    }
}
