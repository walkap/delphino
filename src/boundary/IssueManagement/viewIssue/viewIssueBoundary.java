package boundary.IssueManagement.viewIssue;

import bean.IssueBean;
import controller.IssueHandlerController;
import entity.Issue;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import util.IssueStates;
import util.Rooms;

import java.util.ArrayList;

public class viewIssueBoundary {

    @FXML
    private TableView<IssueBean> table;
    @FXML
    private TextArea description;
    @FXML
    private ComboBox<String> states;
    @FXML
    private Button confirmBtn;
    @FXML
    private TableColumn<Issue, String> titleColumn, areaColumn, roomColumn, bldColumn;
    @FXML
    private Label labelDesc, labelState;
    @FXML
    private Button deleteBtn;

    private ObservableList<IssueBean> items;
    private ArrayList<IssueBean> listIssues;


    @FXML
    public void initialize() {

        states.setVisible(false);
        confirmBtn.setVisible(false);
        description.setVisible(false);
        labelDesc.setVisible(false);
        labelState.setVisible(false);
        description.setEditable(false);
        deleteBtn.setVisible(false);


        IssueHandlerController controller = new IssueHandlerController();
        listIssues = controller.getIssueBeans();
        items = table.getItems();

        int len = listIssues.size();
        int i = 0;
        while (i < len) {
            items.add(listIssues.get(i));
            i++;
        }

        ObservableList<String> items1 = states.getItems();
        String[] issueStates = IssueStates.getSTATES();
        int l = issueStates.length;
        int j = 0;
        while (j < l) {
            items1.add(issueStates[j]);
            j++;
        }


        titleColumn.setCellValueFactory(new PropertyValueFactory<Issue, String>("Name"));
        roomColumn.setCellValueFactory(new PropertyValueFactory<Issue, String>("Room"));
        bldColumn.setCellValueFactory(new PropertyValueFactory<Issue, String>("Building"));
        areaColumn.setCellValueFactory(new PropertyValueFactory<Issue, String>("Area"));

        table.setItems(items);

    }

    public void onConfirm() {

        IssueBean bean = table.getSelectionModel().getSelectedItem();
        IssueHandlerController controller = new IssueHandlerController();
        String s = states.getValue();
        controller.updateIssue(bean, s);

        states.setVisible(false);
        confirmBtn.setVisible(false);
        description.setVisible(false);
        labelDesc.setVisible(false);
        labelState.setVisible(false);
        deleteBtn.setVisible(false);

        items.removeAll(items);
        listIssues = controller.getIssueBeans();

        int len = listIssues.size();
        int i = 0;
        while (i < len) {
            items.add(listIssues.get(i));
            i++;
        }

        table.setItems(items);

        states.setVisible(false);
        confirmBtn.setVisible(false);
        description.setVisible(false);
        labelDesc.setVisible(false);
        labelState.setVisible(false);
    }

    public void onIssueClicked() {

        confirmBtn.setVisible(true);
        description.setVisible(true);
        labelDesc.setVisible(true);
        labelState.setVisible(true);
        states.setVisible(true);
        deleteBtn.setVisible(true);

        IssueBean bean = table.getSelectionModel().getSelectedItem();
        description.setText(bean.getDescription());
        states.setValue(bean.getState());
    }

    public void onDeleteIssue() {


        IssueBean selectedItem = table.getSelectionModel().getSelectedItem();
        table.getItems().remove(selectedItem);
        IssueHandlerController ctrl = new IssueHandlerController();
        ctrl.deleteIssue(selectedItem);

        states.setVisible(false);
        confirmBtn.setVisible(false);
        description.setVisible(false);
        labelDesc.setVisible(false);
        labelState.setVisible(false);

    }
}
