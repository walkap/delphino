package boundary.roomManagementBoundary.viewRoomBoundary;

import control.HandleRoom;
import entity.room.Room;
import exception.room.MandatoryFieldsExceptions;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import util.RoomTypes;

import java.io.IOException;

public class ViewRoomActivity {

    @FXML
    private TextField roomName;
    @FXML
    private ComboBox<String> roomType;
    private ObservableList<String> typesList = FXCollections.observableArrayList();
    @FXML
    private ComboBox<String> roomBuilding;
    private ObservableList<String> buildingsList = FXCollections.observableArrayList();
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
    private Button deleteButton;
    @FXML
    private Button returnButton;
    //This variable is used to get object from tableView
    private Room selectedRoom;

    private String name;
    private String type;
    private String building;
    private int seats;
    private String board;
    private int projectors;
    private int computers;
    private Boolean desk;

    /**
     * This method get the room object from the room list
     *
     * @param room - Room
     */
    public void getRoomIdFromList(Room room) {
        selectedRoom = room;
        roomName.setText(selectedRoom.getName());
        roomType.setValue(selectedRoom.getType());
        roomBuilding.setValue(selectedRoom.getBuilding().getName());
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
        String[] types = RoomTypes.getTypes();
        //TODO we need control to get all buildings
        //Initialize the buildings from stub
        String[] buildings = {"Didattica", "Informazione", "Civile"};

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
        if(!roomName.getText().isEmpty()){
            name = roomName.getText().toUpperCase();
        }

        if(roomType.getValue() != null){
            type = roomType.getValue();
        }

        type = roomType.getValue();

        if (roomBuilding.getValue() != null) {
            building = roomBuilding.getValue();
        }

        if (!roomSeats.getText().isEmpty()) {
            seats = Integer.parseInt(roomSeats.getText());
        }

        if (!roomBoard.getText().isEmpty()) {
            board = roomBoard.getText();
        }

        if (!roomProjectors.getText().isEmpty()) {
            projectors = Integer.parseInt(roomProjectors.getText());
        }

        if (!roomComputers.getText().isEmpty()) {
            computers = Integer.parseInt(roomComputers.getText());
        }

        desk = roomTeacherDesk.isSelected();

        HandleRoom rmc = new HandleRoom();
        try {
            rmc.updateRoom(name, type, building, "area", board, desk, seats, projectors, computers);
        }catch (MandatoryFieldsExceptions e){
            e.printStackTrace();
        }
    }

    /**
     * This method is used to delete a room
     * and get to the previous scene
     */
    public void deleteRoom() throws IOException {
        HandleRoom rmc = new HandleRoom();
        //Call the method to delete the room
        rmc.deleteRoom(selectedRoom);
        //Get back to the table view
        Parent root;
        Stage stage = (Stage) deleteButton.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("/activity/view_all_rooms_activity.fxml"));
        //Create and launch the scene
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * This method is called from return button,
     * to get back to the previous scene
     *
     * @throws IOException
     */
    public void returnButton() throws IOException {
        Parent root;
        Stage stage = (Stage) returnButton.getScene().getWindow();
        //Check which button has been clicked
        root = FXMLLoader.load(getClass().getResource("/activity/view_all_rooms_activity.fxml"));
        //Create and launch the scene
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
