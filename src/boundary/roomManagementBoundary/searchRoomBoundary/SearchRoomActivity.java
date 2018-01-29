package boundary.roomManagementBoundary.searchRoomBoundary;

import control.HandleRoom;
import entity.room.Room;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class SearchRoomActivity {

    @FXML
    private TextField tfRoomName;
    @FXML
    private Button searchButton;
    @FXML
    private Button returnButton;
    @FXML
    private Label roomName, roomBuilding, roomBoard, roomComputers,
            roomType, roomSeats, roomProjectors, roomDesk;

    @FXML
    public void initialize() {
        roomName.setVisible(false);
        roomBuilding.setVisible(false);
        roomBoard.setVisible(false);
        roomComputers.setVisible(false);
        roomType.setVisible(false);
        roomSeats.setVisible(false);
        roomProjectors.setVisible(false);
        roomDesk.setVisible(false);
    }

    /**
     * This method search the room using the string
     * typed in the text field
     */
    public void searchRoom() {
        String name = tfRoomName.getText();
        HandleRoom rmc = new HandleRoom();
        Room room = rmc.getRoomByName(name);

        if (room != null) {
            roomName.setText(room.getName());
            roomBuilding.setText(room.getBuilding().getName());
            roomBoard.setText(room.getBoard());
            roomComputers.setText(Integer.toString(room.getComputers()));
            roomType.setText(room.getType());
            roomSeats.setText(Integer.toString(room.getSeats()));
            roomProjectors.setText(Integer.toString(room.getProjectors()));
            if (room.hasTeacherDesk()) {
                roomDesk.setText("The has the desk inside");
            } else {
                roomDesk.setText("The room has not the desk inside");
            }
            roomName.setVisible(true);
            roomBuilding.setVisible(true);
            roomBoard.setVisible(true);
            roomComputers.setVisible(true);
            roomType.setVisible(true);
            roomSeats.setVisible(true);
            roomProjectors.setVisible(true);
            roomDesk.setVisible(true);
        }

    }

    /**
     * This method is to get to the previous scene
     *
     * @throws IOException
     */
    public void returnButton() throws IOException {
        Parent root;
        Stage stage = (Stage) returnButton.getScene().getWindow();
        //Check which button has been clicked
        root = FXMLLoader.load(getClass().getResource("/activity/room_management_activity.fxml"));

        //Create and launch the scene
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
