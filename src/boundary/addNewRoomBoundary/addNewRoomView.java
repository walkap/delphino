package boundary.addNewRoomBoundary;

import controller.RoomHandlerController;
import entity.TemplateRoom;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.StringConverter;
import util.Types;

public class addNewRoomView {

    @FXML
    private TextField roomName;
    @FXML
    private ComboBox<String> roomType;
    private ObservableList<String> typesList = FXCollections.observableArrayList();
    @FXML
    private ComboBox<Integer> roomBuilding;
    private ObservableList<Integer> buildingsList = FXCollections.observableArrayList();

    @FXML
    private ComboBox<TemplateRoom> roomTemplate;
    private ObservableList<TemplateRoom> roomTemplateList = FXCollections.observableArrayList();

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

        //Initialize template combo
        roomTemplateList.add(new TemplateRoom("ciccio", 200, "nera", 2, 20, true));
        roomTemplate.setItems(roomTemplateList);

        //Convert type from template to string, where string is the template name
        roomTemplate.setConverter(new StringConverter<TemplateRoom>() {
            @Override
            public String toString(TemplateRoom object) {
                if(object == null){
                    return null;
                }else{
                    return object.getNameTemplate();
                }
            }
            @Override
            public TemplateRoom fromString(String string) {
                return null;
            }
        });

        //Initialize type combo
        typesList.addAll(types);
        roomType.setItems(typesList);

        //Initialize building combo
        buildingsList.addAll(buildings);
        roomBuilding.setItems(buildingsList);
    }

    /**
     * This template fill most fields
     * to simplify the insert
     */
    public void fillFromTemplate(){
        TemplateRoom template = roomTemplate.getValue();
        roomSeats.setText(Integer.toString(template.getSeats()));
        roomBoard.setText(template.getBoard());
        roomProjectors.setText(Integer.toString(template.getProjectors()));
        roomComputers.setText(Integer.toString(template.getComputers()));
        roomTeacherDesk.setSelected(template.getDesk());
    }

    /**
     * This method add new room to the database
     */
    public void insertRoom(){
        String name = roomName.getText();
        String type = roomType.getValue();
        int building = roomBuilding.getValue();
        int seats = Integer.parseInt(roomSeats.getText());
        String board = roomBoard.getText();
        int projectors = Integer.parseInt(roomProjectors.getText());
        int computers = Integer.parseInt(roomComputers.getText());
        Boolean desk = roomTeacherDesk.isSelected();

        RoomHandlerController roomHandlerController = new RoomHandlerController();
        roomHandlerController.addNewRoom(name, type, building, board, desk, seats, projectors, computers);
    }

}
