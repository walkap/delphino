package boundary;

import dao.TemplateRoomDao;
import entity.TemplateRoom;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;


public class ModifyDeleteTemplateRoomUI {

    @FXML
    private ComboBox<String> comboTemplateRooms;


    private ArrayList<String> createListOfName() {

        ArrayList<String> array = new ArrayList<>();
        int i = 0;
        TemplateRoomDao tRD = new TemplateRoomDao();
        Vector vec = tRD.getAllTemplateRoom();
        int l = vec.size();
        List list = null;
        while (i < l) {
            TemplateRoom tR = (TemplateRoom) vec.elementAt(i);
            String n = tR.getNameTemplate();
            i++;
            array.add(n);

        }
        System.out.println(array);
        return array;
    }


    public void initialize() {

        ModifyDeleteTemplateRoomUI dTO = new ModifyDeleteTemplateRoomUI();
        ObservableList<String> values = FXCollections.observableArrayList(dTO.createListOfName());
        comboTemplateRooms.setItems(values);

    }
}
