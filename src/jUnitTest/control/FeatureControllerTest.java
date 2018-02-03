package control;

import dao.feature.FeatureDaoFile;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FeatureControllerTest {

    private FeatureDaoFile fDFJ = new FeatureDaoFile();
    FeatureController fC = new FeatureController();

    @Test
    void updateFeature() {
        fC.deleteFeature("Nuova","AltraProva");
        fC.createFeature("Nuova", "Prova");
        fC.updateFeature("Nuova", "AltraProva");
        String d = fC.getFeature("Nuova").getDescription();
        assertEquals(d, "AltraProva");
    }

    @Test
    void createFeature() {
        fC.deleteFeature("Nuova","AltraProva");
        fC.createFeature("Nuova", "Prova");
        assertEquals(fC.getFeature("Nuova").getName(),"Nuova");
        assertEquals(fC.getFeature("Nuova").getDescription(),"Prova");
    }

    @Test
    void deleteFeature() {
        fC.createFeature("TestDelete", "Delete");
        fC.deleteFeature("TestDelete", "Delete");
        assertEquals(fC.getFeature("TestDelete"),null);
    }
}