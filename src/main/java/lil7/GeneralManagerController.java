package lil7;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class GeneralManagerController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private Button EditCatBtn;

    @FXML
    private Button ViewReportsBtn;

    @FXML
    private Button BlockBtn;

    @FXML
    private Button UpdateWorkersBtn;

    @FXML
    private Button signoutBtn;

    @FXML
    private Label headlabel;

    @FXML
    private Button CompReportsBtn1;

    @FXML
    void BackToLogin(ActionEvent event) throws Exception{
        AnchorPane pane= FXMLLoader.load(getClass().getResource("Login.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    @FXML
    void GoToChooseReports(ActionEvent event) {

    }

    @FXML
    void GetMonthlyReport(ActionEvent event) {

    }


    @FXML
    void GoToCostumerList(ActionEvent event) throws Exception {
        App.go_back_to="GeneralManager.fxml";
        AnchorPane pane= FXMLLoader.load(getClass().getResource("EditCustomers.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    @FXML
    void GoToEditCat(ActionEvent event) {

    }

    @FXML
    void GoToWorkersList(ActionEvent event) throws Exception{
        App.go_back_to="GeneralManager.fxml";
        AnchorPane pane= FXMLLoader.load(getClass().getResource("EditWorkers.fxml"));
        rootPane.getChildren().setAll(pane);

    }

    @FXML
    void initialize() {
        assert rootPane != null : "fx:id=\"rootPane\" was not injected: check your FXML file 'GeneralManager.fxml'.";
        assert EditCatBtn != null : "fx:id=\"EditCatBtn\" was not injected: check your FXML file 'GeneralManager.fxml'.";
        assert ViewReportsBtn != null : "fx:id=\"ViewReportsBtn\" was not injected: check your FXML file 'GeneralManager.fxml'.";
        assert BlockBtn != null : "fx:id=\"BlockBtn\" was not injected: check your FXML file 'GeneralManager.fxml'.";
        assert UpdateWorkersBtn != null : "fx:id=\"UpdateWorkersBtn\" was not injected: check your FXML file 'GeneralManager.fxml'.";
        assert signoutBtn != null : "fx:id=\"signoutBtn\" was not injected: check your FXML file 'GeneralManager.fxml'.";
        assert headlabel != null : "fx:id=\"headlabel\" was not injected: check your FXML file 'GeneralManager.fxml'.";
        assert CompReportsBtn1 != null : "fx:id=\"CompReportsBtn1\" was not injected: check your FXML file 'GeneralManager.fxml'.";

    }
}
