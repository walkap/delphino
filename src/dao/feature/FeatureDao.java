package dao.feature;

import entity.Feature;

import java.util.ArrayList;

public interface FeatureDao {


    void insertFeature(Feature f);

    void deleteFeature(Feature f);

    void updateFeature(Feature f);

    boolean isFeaturePresent(Feature f);

    Feature getFeature(String name);

    ArrayList<Feature> getFeatures();



    }
