package control;

import dao.feature.FeatureDaoFile;
import entity.Feature;

import java.util.List;


public class FeatureController {

    private FeatureDaoFile fDFJ = new FeatureDaoFile();

    public void updateFeature(String nameFeature, String descriptionFeature){
        Feature f = new Feature(nameFeature, descriptionFeature);
        try {
            fDFJ.updateFeature(f);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void createFeature(String nameFeature, String descriptionFeature){

        Feature f = new Feature(nameFeature, descriptionFeature);
        try {
            fDFJ.insertFeature(f);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void deleteFeature(String nameFeature, String descriptionFeature){

        Feature feature = new Feature(nameFeature, descriptionFeature);
        try {
            fDFJ.deleteFeature(feature);
        } catch (Exception e){
        e.printStackTrace();
    }
    }

    public Feature getFeature(String name) throws NullPointerException{
        try {
            Feature f = fDFJ.getFeature(name);
            return f;
        } catch (NullPointerException n){
        n.printStackTrace();
        }
        return null;
    }

    public List<Feature> getAllFeatures(){
        List<Feature> features = null;
        try {
            features = fDFJ.getFeatures();
        }catch (NullPointerException n){
            n.printStackTrace();
        }return features;
    }
    public static void main(String[] args){
        FeatureController fC = new FeatureController();
        fC.deleteFeature("Nuova","AltraProva");
        fC.createFeature("Nuova", "Prova");
        System.out.println(fC.getFeature("Nuova").getDescription());
        fC.updateFeature("Nuova", "AltraProva");
        System.out.println(fC.getFeature("Nuova").getDescription());



    }
}
