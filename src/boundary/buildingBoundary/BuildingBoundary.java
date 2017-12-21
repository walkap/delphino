package boundary.buildingBoundary;

import controller.BuildingController;
import dao.BuildingDao;
import exception.BuildingException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.Main;
import util.Area;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class BuildingBoundary  {

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

    @FXML
    public void initialize() {


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

        listAreas.setValue("Macroarea");
        listBuildings.setVisible(false);
        modifyName.setVisible(false);
        modifyArea.setVisible(false);
        modifyName.setVisible(false);



        listAreas2.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

                ObservableList<String> items3 = listBuildings.getItems();
                items3.clear();

                listBuildings.setVisible(true);

                String area = listAreas2.getValue();
                modifyArea.setText(area);
                modifyArea.setVisible(true);

                BuildingController contrl = new BuildingController();
                ArrayList <String> list = contrl.getAreaBuildings(area);

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

        String nameBuilding = name.getText();
        String area = listAreas.getValue();

        if (area.equals("Macroarea") || area.isEmpty() || nameBuilding.isEmpty() || nameBuilding.length() > 20) {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText("Invalid input, building not created");
            alert.showAndWait();
            return;
        }

        try {

            BuildingController controller = new BuildingController();
            controller.createNewBuilding(nameBuilding, area);

        } catch (BuildingException e) {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("This building has been already created");
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.showAndWait();

        }

        listAreas.setValue("Macroarea");
        name.clear();

    }
    public void onModifyBuilding(){

        String oldArea = listAreas2.getValue();
        String oldName = listBuildings.getValue();
        String newName = modifyName.getText();
        String newArea = modifyArea.getText();

        if (newName.isEmpty() || newArea.isEmpty() || newName.length() > 20 || newArea.length() > 20) {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText("Invalid input");
            alert.show();
            return;
     }

      try {

          BuildingController controller = new BuildingController();
          controller.modifyBuilding(oldName, oldArea, newName, newArea);

      } catch (BuildingException e) {

          Alert alert = new Alert(Alert.AlertType.INFORMATION);
          alert.setTitle(null);
          alert.setHeaderText(null);
          alert.setContentText("Select a building created");
          return;

      }

        listAreas2.setValue("Macroarea");
        listBuildings.setValue("Building");
        listBuildings.setVisible(false);
        modifyArea.clear();
        modifyName.clear();
        modifyName.setVisible(false);
        modifyArea.setVisible(false);
    }

    public void onDeleteBuilding() {

        String area = listAreas2.getValue();
        String name = listBuildings.getValue();

        System.out.println(name);
        if (name == null || area == null ) return;

        BuildingController controller = new BuildingController();
        controller.deleteBuilding(name, area);


        listAreas2.setValue("Macroarea");
        listBuildings.setValue("Building");
        listBuildings.setVisible(false);
        modifyArea.clear();
        modifyName.clear();
        modifyName.setVisible(false);
        modifyArea.setVisible(false);

    }

    public void closeWindow() {

        Stage stage = (Stage) modifyName.getScene().getWindow();
        stage.close();
    }

    public void getHomePage() {
        Main c = new Main();
        try {
            c.start(new Stage());
            Stage stage = (Stage) modifyName.getScene().getWindow();
            stage.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}

