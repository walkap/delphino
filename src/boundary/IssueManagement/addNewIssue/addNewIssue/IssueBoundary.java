package boundary.IssueManagement.addNewIssue.addNewIssue;

import bean.IssueBean;
import controller.BuildingController;
import controller.IssueHandlerController;
import dao.BuildingDao;
import entity.Issue;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import util.Area;
import util.Rooms;
import java.util.ArrayList;

public class IssueBoundary{

    @FXML
    private ComboBox<String> listAreas;
    @FXML
    private ComboBox<String> listBuildings;
    @FXML
    private ComboBox<String> listRooms;
    @FXML
    private TextField name;
    @FXML
    private TextArea description;

    @FXML
    public void initialize(){

        listBuildings.setVisible(false);
        listRooms.setVisible(false);

        ObservableList<String> items = listAreas.getItems();
        ObservableList<String> items2 = listRooms.getItems();
        String[] areas = Area.getAreas();
        String[] rooms = Rooms.getRooms();
        int len = areas.length;
        int i = 0;
        while (i < len) {
            items.add(areas[i]);
            i++;
        }
        i = 0;
        len = rooms.length;
        while (i < len) {
            items2.add(rooms[i]);
            i++;
        }


        listAreas.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

                ObservableList<String> items3 = listBuildings.getItems();
                items3.clear();

                listBuildings.setVisible(true);

                String area = listAreas.getValue();

                BuildingController ctrl = new BuildingController();
                ArrayList<String> list = ctrl.getAreaBuildings(area);

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

                listRooms.setVisible(true);


            }
        });


    }

    public void onCreateIssue(){

        String nameIssue = name.getText();
        String descr = description.getText();
        String bld = listBuildings.getValue();
        String areaIssue = listAreas.getValue();
        String roomIssue = listRooms.getValue();

        IssueBean bean = new IssueBean(nameIssue, areaIssue, bld, roomIssue, descr);

        IssueHandlerController cntrl = new IssueHandlerController();
        cntrl.addNewIssue(bean);

        name.clear();
        description.clear();
        listBuildings.setValue("Building");
        listAreas.setValue("Macroarea");
        listRooms.setValue("Room");

    }
}
