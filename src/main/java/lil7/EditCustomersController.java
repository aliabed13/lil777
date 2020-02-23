package lil7;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.input.MouseEvent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class EditCustomersController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private TableView<User> tableview;

    @FXML
    private TableColumn<User, String> usernameCol;

    @FXML
    private TableColumn<User, String> emailCol;

    @FXML
    private TableColumn<User, String> phoneCol;

    @FXML
    private TableColumn<User, String> blockedCol;

    @FXML
    private TableColumn<User, String> authCol;

    @FXML
    private Label loba1;

    @FXML
    private Button BlockClientBtn;

    @FXML
    private Button BackBtn;

    @FXML
    void ChooseUser(MouseEvent event) throws Exception {
        App.selected_user_edit= new User(tableview.getSelectionModel().getSelectedItem());

    }

    @FXML
    void BlockpickedClient(ActionEvent event) throws Exception {
        AnchorPane pane= FXMLLoader.load(getClass().getResource("Specificuser.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    @FXML
    void GoToMain(ActionEvent event) throws Exception {
        AnchorPane pane= FXMLLoader.load(getClass().getResource("GeneralManager.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    @FXML
    void UnblockpickedClient(ActionEvent event) {
        //"block#username"
    }


    @FXML
    void initialize() {
        assert rootPane != null : "fx:id=\"rootPane\" was not injected: check your FXML file 'EditCustomers.fxml'.";
        assert tableview != null : "fx:id=\"tableview\" was not injected: check your FXML file 'EditCustomers.fxml'.";
        assert usernameCol != null : "fx:id=\"usernameCol\" was not injected: check your FXML file 'EditCustomers.fxml'.";
        assert emailCol != null : "fx:id=\"emailCol\" was not injected: check your FXML file 'EditCustomers.fxml'.";
        assert phoneCol != null : "fx:id=\"phoneCol\" was not injected: check your FXML file 'EditCustomers.fxml'.";
        assert blockedCol != null : "fx:id=\"blockedCol\" was not injected: check your FXML file 'EditCustomers.fxml'.";
        assert authCol != null : "fx:id=\"authCol\" was not injected: check your FXML file 'EditCustomers.fxml'.";
        assert loba1 != null : "fx:id=\"loba1\" was not injected: check your FXML file 'EditCustomers.fxml'.";
        assert BlockClientBtn != null : "fx:id=\"BlockClientBtn\" was not injected: check your FXML file 'EditCustomers.fxml'.";
        assert BackBtn != null : "fx:id=\"BackBtn\" was not injected: check your FXML file 'EditCustomers.fxml'.";

        usernameCol.setCellValueFactory(new PropertyValueFactory<User, String>("username"));
        emailCol.setCellValueFactory(new PropertyValueFactory<User, String>("email"));
        phoneCol.setCellValueFactory(new PropertyValueFactory<User, String>("phone"));
        blockedCol.setCellValueFactory(new PropertyValueFactory<User, String>("blocked"));
        authCol.setCellValueFactory(new PropertyValueFactory<User, String>("auth"));

        ObservableList<User> Users = get_all_users();
        tableview.setItems(Users);
    }


    public ObservableList<User> getUsersFromString(String Users){
        ObservableList<User> Users1 = FXCollections.observableArrayList();
        String iusername, iemail, iphone, istatus,istatus11;
        String[] rows = Users.split("/");
        for(String row : rows) {
            String[] cols = row.split("#");
            iusername = cols[0];
            iemail = cols[3];
            iphone = cols[4];
            istatus = cols[8];
            istatus11 = cols[9];
            User user=new User(iusername,cols[1],cols[2],cols[3],cols[4],cols[5],cols[6],cols[7],cols[8],cols[9]);
            Users1.add(user);
        }
        return Users1;
    }
    public ObservableList<User> get_all_users() {
    	MyChat.sendMSG("getallusers");
    	String res=MyChat.getMSG();
    	return getUsersFromString(res);
    }

}
