package lil7;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

public class SeeOrderController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private TableView<?> OrderHisTable;

    @FXML
    private TableColumn<?, ?> ComplaintNum;

    @FXML
    private TableColumn<?, ?> Comp;

    @FXML
    private TableColumn<?, ?> ComplaintReply;

    @FXML
    private TableColumn<?, ?> ComplaintReply1;

    @FXML
    private TableColumn<?, ?> ComplaintReply11;

    @FXML
    private TableColumn<?, ?> ComplaintReply111;

    @FXML
    private Button GoBackBtn;

    @FXML
    private Button CancelOrderBtn;

    @FXML
    private TextArea ReplyTF;

    @FXML
    void BackToMain(ActionEvent event) throws Exception{
        AnchorPane pane= FXMLLoader.load(getClass().getResource(App.go_back_to));
        rootPane.getChildren().setAll(pane);
    }

    @FXML
    void CancelThisOrder(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert rootPane != null : "fx:id=\"rootPane\" was not injected: check your FXML file 'SeeOrders.fxml'.";
        assert OrderHisTable != null : "fx:id=\"OrderHisTable\" was not injected: check your FXML file 'SeeOrders.fxml'.";
        assert ComplaintNum != null : "fx:id=\"ComplaintNum\" was not injected: check your FXML file 'SeeOrders.fxml'.";
        assert Comp != null : "fx:id=\"Comp\" was not injected: check your FXML file 'SeeOrders.fxml'.";
        assert ComplaintReply != null : "fx:id=\"ComplaintReply\" was not injected: check your FXML file 'SeeOrders.fxml'.";
        assert ComplaintReply1 != null : "fx:id=\"ComplaintReply1\" was not injected: check your FXML file 'SeeOrders.fxml'.";
        assert ComplaintReply11 != null : "fx:id=\"ComplaintReply11\" was not injected: check your FXML file 'SeeOrders.fxml'.";
        assert ComplaintReply111 != null : "fx:id=\"ComplaintReply111\" was not injected: check your FXML file 'SeeOrders.fxml'.";
        assert GoBackBtn != null : "fx:id=\"GoBackBtn\" was not injected: check your FXML file 'SeeOrders.fxml'.";
        assert CancelOrderBtn != null : "fx:id=\"CancelOrderBtn\" was not injected: check your FXML file 'SeeOrders.fxml'.";
        assert ReplyTF != null : "fx:id=\"ReplyTF\" was not injected: check your FXML file 'SeeOrders.fxml'.";

    }
}