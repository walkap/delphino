package control;

import dao.FeatureDaoFileJava;
import entity.Feature;

import java.io.IOException;
import java.util.ArrayList;

public class FeatureController {

    private FeatureDaoFileJava fDFJ = new FeatureDaoFileJava();
    private String nameFeature;
    private String descriptionFeature;

    public void createFeature(String nameFeature, String descriptionFeature){

        Feature f = new Feature(nameFeature, descriptionFeature);
        fDFJ.addFeature(f);
    }

    public void deleteFeature(String nameFeature, String descriptionFeature){

        Feature feature = new Feature(nameFeature, descriptionFeature);
        fDFJ.deleteFeature(feature);
    }

    public Feature getFeatureController(String name){
        return fDFJ.getFeature(name);

    }



}
