package control;

import dao.FeatureDaoFileJava;
import entity.Feature;


public class FeatureController {

    private FeatureDaoFileJava fDFJ = new FeatureDaoFileJava();

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
            fDFJ.addFeature(f);
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
}
