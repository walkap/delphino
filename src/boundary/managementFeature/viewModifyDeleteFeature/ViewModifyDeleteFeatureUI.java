package boundary.managementFeature.viewModifyDeleteFeature;

import boundary.managementFeature.MainManagementFeature;
import control.FeatureController;
import dao.feature.FeatureDaoFile;
import entity.Feature;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;

import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import main.Main;

import java.util.ArrayList;
import java.util.List;

public class ViewModifyDeleteFeatureUI {

    @FXML
    private Button exitBtn;
    @FXML
    private Button prevPageBtn;
    @FXML
    private Button homePageBtn;
    @FXML
    private Button confirmBtn;
    @FXML
    private Button deleteBtn;
    @FXML
    private TextField nameFeature;
    @FXML
    private TextField descriptionFeature;
    @FXML
    private ListView<String> listView;

    private FeatureDaoFile fD = new FeatureDaoFile();
    private FeatureController fC = new FeatureController();


    public void initialize() {
        ViewModifyDeleteFeatureUI vMDFUI = new ViewModifyDeleteFeatureUI();
        ObservableList<String> values = FXCollections.observableArrayList(vMDFUI.createListOfName());
        listView.setItems(values);
    }

    private ArrayList<String> createListOfName() {

        ArrayList<String> array = new ArrayList<>();
        int i = 0;
        try {
            List list = fD.getFeatures();
            int l = list.size();
            while (i < l) {
                Feature f = (Feature) list.get(i);
                String n = f.getName();
                i++;
                array.add(n);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(array);
        return array;
    }

    public void modifyFeature(){
        String nameF = nameFeature.getText();
        String descriptionF = descriptionFeature.getText();
        try {
            if(fC.getFeature(nameF) != null){
                fC.updateFeature(nameF, descriptionF);
            }
        }catch (NullPointerException n){
            n.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Error Name of feature");
            alert.setContentText("Sorry feature can't be update because name of feature dosen't match any feature in db!");
            alert.showAndWait();
            n.printStackTrace();
        }
    }

    public void chooseFeatureAndFillTV(){

        listView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                List<String> list = listView.getSelectionModel().getSelectedItems();
                String item = list.get(0);
                try {
                    Feature f = fC.getFeature(item);
                    nameFeature.setText(f.getName());
                    if(f.getDescription()!= null) {
                        descriptionFeature.setText(f.getDescription());
                    }else{
                        descriptionFeature.setText("NO DESCRIPTION");
                    }
                }catch (NullPointerException n){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Error");
                    alert.setHeaderText("Empty List");
                    alert.setContentText("Sorry list is empty!");
                    alert.showAndWait();
                    n.printStackTrace();
                }
            }
        });
    }

    /**
     * This method use a button for return Management Feature window;
     *
     */
    public void managementFeatureScene(){
        MainManagementFeature M = new MainManagementFeature();
        try {
            M.start(new Stage());
            Stage stage = (Stage) prevPageBtn.getScene().getWindow();
            stage.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method use a button for return Home Page window;
     *
     */

    public void mainScene(){
        Main M = new Main();
        try {
            M.start(new Stage());
            Stage stage = (Stage) homePageBtn.getScene().getWindow();
            stage.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void closeWindow(){
        Stage stage = (Stage) exitBtn.getScene().getWindow();
        stage.close();
    }

    public void deleteFeature() {

        String nameF = nameFeature.getText();
        String descriptionF = descriptionFeature.getText();
        try {
            if (!nameF.isEmpty() && !descriptionF.isEmpty()){
                fC.deleteFeature(nameF, descriptionF);
                nameFeature.setText("");
                descriptionFeature.setText("");
                listView.getItems().remove(nameF);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle(null);
                alert.setHeaderText(null);
                alert.setContentText("The feature has been deleted from database");
                alert.showAndWait();
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Error with name of Feature");
                alert.setContentText("You don't choose any Feature!");
                alert.showAndWait();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
