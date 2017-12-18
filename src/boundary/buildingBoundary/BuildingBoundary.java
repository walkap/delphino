package buildingBoundary;

import controller.BuildingController;
import dao.BuildingDao;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import util.Area;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class BuildingBoundary implements Initializable {

    @FXML
    private TextField name;
    @FXML
    private TextField modifyArea;
    @FXML
    private TextField modifyName;
    @FXML
    private ComboBox<String> listAreas;
    @FXML
    private ComboBox<String> listAreas2;
    @FXML
    private ComboBox<String> listBuildings;

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        //initialization combobox
        ObservableList<String> items = listAreas.getItems();
        ObservableList<String> items2 = listAreas2.getItems();
        String[] areas = Area.getAreas();
        int len = areas.length;
        int i = 0;
        while (i < len) {
            items.add(areas[i]);
            items2.add(areas[i]);
            i++;
        }

        listBuildings.setVisible(false);
        modifyName.setVisible(false);
        modifyArea.setVisible(false);



        listAreas2.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

                ObservableList<String> items3 = listBuildings.getItems();
                items3.clear();

                listBuildings.setVisible(true);

                String area = listAreas2.getValue();
                    modifyArea.setText(area);
                    modifyArea.setVisible(true);
                BuildingDao buildingDao = new BuildingDao();
                ArrayList <String> list = buildingDao.getAreaBuildings(area);

                int len = list.size();
                int i = 0;
                while (i < len) {
                    items3.add(list.get(i));
                    i++;
                }

                list.clear();
            }
        });

        listBuildings.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

                String area = listBuildings.getValue();
                modifyName.setText(area);
                modifyName.setVisible(true);


            }
        });


    }

    public void onCreateBuilding() {

        String area = listAreas.getValue();
        String nameBuilding = name.getText();

        BuildingController controller = new BuildingController();
        controller.createNewBuilding(nameBuilding, area);


        listAreas.setValue("");
        name.clear();
    }

    public void onModifyBuilding(){

        String oldArea = listAreas2.getValue();
        String oldName = listBuildings.getValue();
        String newName = modifyName.getText();
        String newArea = modifyArea.getText();

        BuildingController controller = new BuildingController();
        controller.modifyBuilding(oldName, oldArea, newName, newArea);

        listAreas2.setValue("Macroarea");
        listBuildings.setValue("Edificio");
        listBuildings.setVisible(false);
        modifyArea.clear();
        modifyName.clear();
        modifyName.setVisible(false);
        modifyArea.setVisible(false);
    }

    public void onDeleteBuilding() {
        String name = modifyName.getText();
        String area = modifyArea.getText();

        BuildingController controller = new BuildingController();
        controller.deleteBuilding(name, area);

        listAreas2.setValue("Macroarea");
        listBuildings.setValue("Edificio");
        listBuildings.setVisible(false);
        modifyArea.clear();
        modifyName.clear();
        modifyName.setVisible(false);
        modifyArea.setVisible(false);

    }



}

