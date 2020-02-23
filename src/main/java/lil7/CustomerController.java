package lil7;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class CustomerController {

    @FXML
    private AnchorPane rootPane;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ViewCatalogbtn;

    @FXML
    private Button SignOut;

    @FXML
    private Button SeeOrdersbtn;

    @FXML
    private Button CheckComplaintBtn;

    @FXML
    private Button MakeComplaintBtn;

    @FXML
    private Button MakeOrderbtn;

    @FXML
    private Label NameLabel;

    @FXML
    private Label BalanceLabel;



    @FXML
    void GoToCatalog(ActionEvent event) throws Exception {
        AnchorPane pane= FXMLLoader.load(getClass().getResource("CatalogViewOnly.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    @FXML
    void GoToMakeComplaint(ActionEvent event) throws Exception {
        AnchorPane pane= FXMLLoader.load(getClass().getResource("SubmitComplaint.fxml"));
        rootPane.getChildren().setAll(pane);

    }

    @FXML
    void GoToMakeOrder(ActionEvent event) throws Exception {
        App.catItems = new item[100];
        App.catItsSz=0;
        App.SDItsSz=0;
        App.SDItems = new SDType[100];
        App.b=true;
        App.selectedItem = new item(null,null,0,0);
        App.SelfDes = new SDType(null,null,null);

        AnchorPane pane= FXMLLoader.load(getClass().getResource("OrderView.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    @FXML
    void GoToSignIn(ActionEvent event) throws Exception {
        AnchorPane pane= FXMLLoader.load(getClass().getResource("Login.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    @FXML
    void GoToUserComplaints(ActionEvent event) throws Exception {
        App.go_back_to="Customer.fxml";
        AnchorPane pane= FXMLLoader.load(getClass().getResource("SeeComplaints.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    @FXML
    void GoToorderspage(ActionEvent event) throws Exception {
        App.go_back_to="Customer.fxml";
        AnchorPane pane= FXMLLoader.load(getClass().getResource("SeeOrders.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    @FXML
    void initialize() {
        assert ViewCatalogbtn != null : "fx:id=\"ViewCatalogbtn\" was not injected: check your FXML file 'Costumer.fxml'.";
        assert SignOut != null : "fx:id=\"SignOut\" was not injected: check your FXML file 'Costumer.fxml'.";
        assert SeeOrdersbtn != null : "fx:id=\"SeeOrdersbtn\" was not injected: check your FXML file 'Costumer.fxml'.";
        assert CheckComplaintBtn != null : "fx:id=\"CheckComplaintBtn\" was not injected: check your FXML file 'Costumer.fxml'.";
        assert MakeComplaintBtn != null : "fx:id=\"MakeComplaintBtn\" was not injected: check your FXML file 'Costumer.fxml'.";
        assert MakeOrderbtn != null : "fx:id=\"MakeOrderbtn\" was not injected: check your FXML file 'Costumer.fxml'.";
        assert NameLabel != null : "fx:id=\"NameLabel\" was not injected: check your FXML file 'Costumer.fxml'.";
        assert BalanceLabel != null : "fx:id=\"BalanceLabel\" was not injected: check your FXML file 'Costumer.fxml'.";

        String temp=App.user_name;
        NameLabel.setText(temp);
        temp=App.balance;
        BalanceLabel.setText(temp);
    }
}
