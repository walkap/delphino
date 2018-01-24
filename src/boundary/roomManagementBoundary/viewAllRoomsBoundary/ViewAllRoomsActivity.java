package boundary.roomManagementBoundary.viewAllRoomsBoundary;

import boundary.roomManagementBoundary.viewRoomBoundary.ViewRoomActivity;
import control.RoomManagementController;
import entity.room.Room;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.util.Vector;

public class ViewAllRoomsActivity {

    @FXML
    private TableView<Room> roomTable;
    @FXML
    private TableColumn<Room, String> roomNameColumn;
    @FXML
    private TableColumn<Room, String> roomTypeColumn;
    @FXML
    private TableColumn<Room, Integer> roomBuilding;
    @FXML
    private Button returnButton;

    private ObservableList<Room> roomList = FXCollections.observableArrayList();

    /**
     * This method returns all rooms present in database
     *
     * @return Vector
     */
    private Vector<Room> getAllRooms() {
        RoomManagementController rmc = new RoomManagementController();
        return rmc.getAllRooms();
    }

    @FXML
    public void initialize() {
        //Get all rooms from database
        roomList.addAll(getAllRooms());
        //Define table columns
        roomNameColumn.setCellValueFactory(new PropertyValueFactory<Room, String>("Name"));
        roomTypeColumn.setCellValueFactory(new PropertyValueFactory<Room, String>("Type"));
        roomBuilding.setCellValueFactory(new PropertyValueFactory<Room, Integer>("Building"));
        //Attach the list to tableView
        roomTable.setItems(roomList);
        addButtonToTable();
    }

    /**
     * This method add new column to the table
     * that contains a button, clicking it get
     * through the view room activity
     */
    private void addButtonToTable() {
        TableColumn<Room, Void> viewButtonColumn = new TableColumn("View");
        Callback<TableColumn<Room, Void>, TableCell<Room, Void>> cellFactory = new Callback<TableColumn<Room, Void>, TableCell<Room, Void>>() {
            @Override
            public TableCell<Room, Void> call(final TableColumn<Room, Void> param) {
                final TableCell<Room, Void> cell = new TableCell<Room, Void>() {
                    private final Button btn = new Button("View Room");

                    {
                        btn.setOnAction((ActionEvent event) -> {
                            //Get the room object from selected in tableView
                            Room room = getTableView().getItems().get(getIndex());
                            try {
                                handleViewRoomButton(room, event);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            System.out.println("selectedData: " + room);
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
                return cell;
            }
        };
        viewButtonColumn.setCellFactory(cellFactory);
        roomTable.getColumns().add(viewButtonColumn);
    }

    /**
     * This method start new scene relative to the room selected
     *
     * @throws IOException
     */

    private void handleViewRoomButton(Room room, ActionEvent e) throws IOException {
        //Load the fxml file
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/activity/view_room_activity.fxml"));
        Parent root = loader.load();
        //Create new scene
        Scene scene = new Scene(root);
        //Invoke the right activity
        ViewRoomActivity viewRoomActivity = loader.getController();
        //Call method to pass the room object to the room detail scene
        viewRoomActivity.getRoomIdFromList(room);
        //Launch the scene
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    /**
     * This method handle the buttons
     *
     * @param e - ActionEvent
     * @throws IOException
     */
    @FXML
    private void handleButtonAction(ActionEvent e) throws IOException {
        Parent root;
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        //Check which button has been clicked
        if (e.getSource() == returnButton) {
            root = FXMLLoader.load(getClass().getResource("/activity/room_management_activity.fxml"));
        } else {
            root = FXMLLoader.load(getClass().getResource("/activity/add_new_room_activity.fxml"));
        }
        //Create and launch the scene
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}