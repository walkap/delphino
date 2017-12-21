package boundary.roomManagementBoundary.viewRoomBoundary;

import controller.RoomManagementController;
import entity.room.Room;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import util.Types;

public class ViewRoomActivity {

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
    //This variable is used to get object from tableView
    private Room selectedRoom;


    /**
     * This method get the room object from the room list
     *
     * @param room - Room
     */
    public void getRoomIdFromList(Room room) {
        selectedRoom = room;
        roomName.setText(selectedRoom.getName());
        roomType.setValue(selectedRoom.getType());
        roomBuilding.setValue(selectedRoom.getBuilding());
        roomSeats.setText(Integer.toString(selectedRoom.getSeats()));
        roomBoard.setText(selectedRoom.getBoard());
        roomProjectors.setText(Integer.toString(selectedRoom.getProjectors()));
        roomComputers.setText(Integer.toString(selectedRoom.getComputers()));
        roomTeacherDesk.setSelected(selectedRoom.hasTeacherDesk());
        System.out.println("ViewRoomActivity: getRoomIdFromList " + room.getId());
    }

    @FXML
    public void initialize() {
        //Initialize the types from util
        String[] types = Types.getTypes();
        //TODO we need controller to get all buildings
        //Initialize the buildings from stub
        Integer[] buildings = {1, 2, 3};

        //Initialize type combo
        typesList.addAll(types);
        roomType.setItems(typesList);

        //Initialize building combo
        buildingsList.addAll(buildings);
        roomBuilding.setItems(buildingsList);
        //Disable the user to modify the name field
        roomName.setDisable(true);
    }

    /**
     * This method update a room in database
     */
    public void updateRoom() {
        String name = roomName.getText();
        String type = roomType.getValue();
        int building = roomBuilding.getValue();
        int seats = Integer.parseInt(roomSeats.getText());
        String board = roomBoard.getText();
        int projectors = Integer.parseInt(roomProjectors.getText());
        int computers = Integer.parseInt(roomComputers.getText());
        Boolean desk = roomTeacherDesk.isSelected();
        //Call the controller and update the room
        RoomManagementController rhc = new RoomManagementController();
        rhc.updateRoom(name, type, building, board, desk, seats, projectors, computers);
    }

    public void deleteRoom() {
        RoomManagementController rhc = new RoomManagementController();
        rhc.deleteRoom(selectedRoom);
        //TODO close window or get to the previous page
    }


}
