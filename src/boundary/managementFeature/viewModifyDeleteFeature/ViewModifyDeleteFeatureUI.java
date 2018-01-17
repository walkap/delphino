package boundary.managementFeature.viewModifyDeleteFeature;

import control.FeatureController;
import dao.FeatureDaoFileJava;
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

    private FeatureDaoFileJava fD = new FeatureDaoFileJava();
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

    public void chooseTemplateRoomAndFillTV(){

        listView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                List<String> list = listView.getSelectionModel().getSelectedItems();
                String item = list.get(0);
                Feature f = fC.getFeature(item);
                nameFeature.setText(f.getName());
                descriptionFeature.setText(f.getDescription());
                }
        });
    }

    public void mainTemplateRoomScene(){
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
        if (!nameF.isEmpty() && !descriptionF.isEmpty()){
            fC.deleteFeature(nameF, descriptionF);
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

    }

}
