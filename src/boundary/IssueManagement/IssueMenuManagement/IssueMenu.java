package boundary.IssueManagement.IssueMenuManagement;

import boundary.IssueManagement.addNewIssue.NewIssueMain;
import boundary.IssueManagement.viewIssue.viewIssueMain;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import main.Main;

public class IssueMenu extends Application {


    @FXML
    private Button issueCreate;
    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("IssueMenuUI.fxml"));

        primaryStage.setTitle("Building Management");
        primaryStage.setScene(new Scene(root, 800, 500));
        primaryStage.show();

    }

    public void onIssueCreate(){
        NewIssueMain M = new NewIssueMain();
        try {
            M.start(new Stage());
            Stage stage = (Stage) issueCreate.getScene().getWindow();
            stage.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onIssueManage(){

        viewIssueMain M = new viewIssueMain();
        try {
            M.start(new Stage());
            Stage stage = (Stage) issueCreate.getScene().getWindow();
            stage.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void onHomePage(){

        Main M = new Main();
        try {
            M.start(new Stage());
            Stage stage = (Stage) issueCreate.getScene().getWindow();
            stage.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}
