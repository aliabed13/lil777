package lil7;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class EditWorkersControllers {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private TableView<?> tabeblon;

    @FXML
    private TableColumn<?, ?> workername;

    @FXML
    private TableColumn<?, ?> ComplaintReply;

    @FXML
    private TableColumn<?, ?> Comp;

    @FXML
    private TableColumn<?, ?> Comp1;

    @FXML
    private Button GoBackBtn;

    @FXML
    private Button AddBtnWorker;

    @FXML
    private Label l1;

    @FXML
    private Label l2;

    @FXML
    private Label l3;

    @FXML
    private Label l4;

    @FXML
    private Label l5;

    @FXML
    private TextField WorkerNameTF;

    @FXML
    private TextField PasswordTF;

    @FXML
    private TextField EmailAddressTF;

    @FXML
    private TextField AddressTF;

    @FXML
    private Label Phone;

    @FXML
    private TextField PhoneTF;

    @FXML
    private Button DeleteWorkerBtn;

    @FXML
    private Label l6;

    @FXML
    private TextField StoreTF;

    @FXML
    void AddWorker(ActionEvent event) {

    }

    @FXML
    void BackToMain(ActionEvent event) throws Exception {
        AnchorPane pane= FXMLLoader.load(getClass().getResource(App.go_back_to));
        rootPane.getChildren().setAll(pane);


    }

    @FXML
    void DeleteWorker(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert rootPane != null : "fx:id=\"rootPane\" was not injected: check your FXML file 'EditWorkers.fxml'.";
        assert tabeblon != null : "fx:id=\"tabeblon\" was not injected: check your FXML file 'EditWorkers.fxml'.";
        assert workername != null : "fx:id=\"workername\" was not injected: check your FXML file 'EditWorkers.fxml'.";
        assert ComplaintReply != null : "fx:id=\"ComplaintReply\" was not injected: check your FXML file 'EditWorkers.fxml'.";
        assert Comp != null : "fx:id=\"Comp\" was not injected: check your FXML file 'EditWorkers.fxml'.";
        assert Comp1 != null : "fx:id=\"Comp1\" was not injected: check your FXML file 'EditWorkers.fxml'.";
        assert GoBackBtn != null : "fx:id=\"GoBackBtn\" was not injected: check your FXML file 'EditWorkers.fxml'.";
        assert AddBtnWorker != null : "fx:id=\"AddBtnWorker\" was not injected: check your FXML file 'EditWorkers.fxml'.";
        assert l1 != null : "fx:id=\"l1\" was not injected: check your FXML file 'EditWorkers.fxml'.";
        assert l2 != null : "fx:id=\"l2\" was not injected: check your FXML file 'EditWorkers.fxml'.";
        assert l3 != null : "fx:id=\"l3\" was not injected: check your FXML file 'EditWorkers.fxml'.";
        assert l4 != null : "fx:id=\"l4\" was not injected: check your FXML file 'EditWorkers.fxml'.";
        assert l5 != null : "fx:id=\"l5\" was not injected: check your FXML file 'EditWorkers.fxml'.";
        assert WorkerNameTF != null : "fx:id=\"WorkerNameTF\" was not injected: check your FXML file 'EditWorkers.fxml'.";
        assert PasswordTF != null : "fx:id=\"PasswordTF\" was not injected: check your FXML file 'EditWorkers.fxml'.";
        assert EmailAddressTF != null : "fx:id=\"EmailAddressTF\" was not injected: check your FXML file 'EditWorkers.fxml'.";
        assert AddressTF != null : "fx:id=\"AddressTF\" was not injected: check your FXML file 'EditWorkers.fxml'.";
        assert Phone != null : "fx:id=\"Phone\" was not injected: check your FXML file 'EditWorkers.fxml'.";
        assert PhoneTF != null : "fx:id=\"PhoneTF\" was not injected: check your FXML file 'EditWorkers.fxml'.";
        assert DeleteWorkerBtn != null : "fx:id=\"DeleteWorkerBtn\" was not injected: check your FXML file 'EditWorkers.fxml'.";
        assert l6 != null : "fx:id=\"l6\" was not injected: check your FXML file 'EditWorkers.fxml'.";
        assert StoreTF != null : "fx:id=\"StoreTF\" was not injected: check your FXML file 'EditWorkers.fxml'.";

    }
}
