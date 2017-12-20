package boundary.roomManagementBoundary.viewAllRoomsBoundary;

import controller.RoomHandlerController;
import entity.room.Room;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

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

    private ObservableList<Room> roomList = FXCollections.observableArrayList();

    /**
     * This method returns all rooms present in database
     *
     * @return Vector
     */
    private Vector<Room> getAllRooms() {
        RoomHandlerController rhc = new RoomHandlerController();
        return rhc.getAllRooms();
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
                            Room room = getTableView().getItems().get(getIndex());
                            //TODO find a way to get to the room activity
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

}