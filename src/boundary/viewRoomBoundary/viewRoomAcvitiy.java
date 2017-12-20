package boundary.viewRoomBoundary;

import controller.RoomHandlerController;
import entity.room.Room;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import util.Types;

public class viewRoomAcvitiy {

    @FXML
    private TextField roomName;
    @FXML
    private ComboBox<String> roomType;
    private ObservableList<String> typesList = FXCollections.observableArrayList();
    @FXML
    private ComboBox<Integer> roomBuilding;
    private ObservableList<Integer> buildingsList = FXCollections.observableArrayList();
    @FXML
    private TextField roomSeats;
    @FXML
    private TextField roomBoard;
    @FXML
    private TextField roomProjectors;
    @FXML
    private TextField roomComputers;
    @FXML
    private CheckBox roomTeacherDesk;

    @FXML
    public void initialize(){

        String[] types = Types.getTypes();
        Integer[] buildings = {1,2,3};

        //Initialize type combo
        typesList.addAll(types);
        roomType.setItems(typesList);

        //Initialize building combo
        buildingsList.addAll(buildings);
        roomBuilding.setItems(buildingsList);

        RoomHandlerController rhc = new RoomHandlerController();
        Room room = rhc.getRoom(6);

        roomName.setText(room.getName());
        roomType.setValue(room.getType());
        roomBuilding.setValue(room.getBuilding());
        roomSeats.setText(Integer.toString(room.getSeats()));
        roomBoard.setText(room.getBoard());
        roomProjectors.setText(Integer.toString(room.getProjectors()));
        roomComputers.setText(Integer.toString(room.getComputers()));
        roomTeacherDesk.setSelected(room.hasTeacherDesk());

        roomName.setDisable(true);
    }

    /**
     * This method update a room in database
     */
    public void updateRoom(){
        String name = roomName.getText();
        String type = roomType.getValue();
        int building = roomBuilding.getValue();
        int seats = Integer.parseInt(roomSeats.getText());
        String board = roomBoard.getText();
        int projectors = Integer.parseInt(roomProjectors.getText());
        int computers = Integer.parseInt(roomComputers.getText());
        Boolean desk = roomTeacherDesk.isSelected();

        RoomHandlerController rhc = new RoomHandlerController();
        rhc.updateRoom(name, type, building, board, desk, seats, projectors, computers);
    }

    public void deleteRoom(){

    }

}
