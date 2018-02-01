package bean;


import dao.feature.FeatureDaoFile;
import entity.Feature;

import java.util.List;

public class FeatureBean {

    private String name;
    private String description;
    private FeatureDaoFile fDFJ = new FeatureDaoFile();



    public FeatureBean() {

    }

    public List<Feature> getAllFeatures() {
        List<Feature> features = null;
        try {
            features = fDFJ.getFeatures();
        } catch (NullPointerException n) {
            n.printStackTrace();
        }
        return features;
    }

    public Feature getFeature(String name) throws NullPointerException{
        return fDFJ.getFeature(name);
    }


    /**
     * Get the Feature's name
     *
     * @return String
     */
    public String getName() {
        return name;
    }


    /**
     * Set the feature's name
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * Get the feature's description
     *
     * @return String
     */
    public String getDescription() {
        return description;
    }


    /**
     * Set the feature's description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    public static void main(String[] args){
        FeatureBean fB = new FeatureBean();
        String f = fB.getFeature("AAA").getName();
        System.out.println(fB.getFeature(f));
        System.out.println(fB.getAllFeatures());
    }

}

