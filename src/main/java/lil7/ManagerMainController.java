package lil7;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class ManagerMainController {

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
    private Button signoutBtn;

    @FXML
    private Button EditW;
    @FXML
    void BackToLogin(ActionEvent event) throws Exception{
        AnchorPane pane= FXMLLoader.load(getClass().getResource("Login.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    @FXML
    void GetMonthlyReport(ActionEvent event) {

    }

    @FXML
    void GoToWorkersList(ActionEvent event) throws Exception {
        App.go_back_to="ManagerMain.fxml";
        AnchorPane pane= FXMLLoader.load(getClass().getResource("EditWorkers.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    @FXML
    void GoToEditCat(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert rootPane != null : "fx:id=\"rootPane\" was not injected: check your FXML file 'ManagerMain.fxml'.";
        assert EditCatBtn != null : "fx:id=\"EditCatBtn\" was not injected: check your FXML file 'ManagerMain.fxml'.";
        assert ViewReportsBtn != null : "fx:id=\"ViewReportsBtn\" was not injected: check your FXML file 'ManagerMain.fxml'.";
        assert signoutBtn != null : "fx:id=\"signoutBtn\" was not injected: check your FXML file 'ManagerMain.fxml'.";
        assert EditW != null : "fx:id=\"EditW\" was not injected: check your FXML file 'ManagerMain.fxml'.";

    }
}
