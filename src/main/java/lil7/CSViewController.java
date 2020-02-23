package lil7;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.input.MouseEvent;

public class CSViewController {
    public Complaints selectedcomp;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private TableView<Complaints> tableview;

    @FXML
    private TableColumn<Complaints, String> complaintidCol;

    @FXML
    private TableColumn<Complaints, String> dateandtimeCol;

    @FXML
    private TableColumn<Complaints, String> complaintCol;

    @FXML
    private TableColumn<Complaints, String> orderidCol;

    @FXML
    private TextArea ReplyTF;

    @FXML
    private Button SubmitReply;

    @FXML
    private Label alabel;

    @FXML
    private TextField RefundTF;

    @FXML
    private Label refundlabel;

    @FXML
    private Button SignoutBtn;

    @FXML
    private Button RefreshBtn;

    @FXML
    void BackToLogin(ActionEvent event) throws Exception{
        AnchorPane pane= FXMLLoader.load(getClass().getResource("Login.fxml"));
        rootPane.getChildren().setAll(pane);

    }
    @FXML
    void Selected(MouseEvent event) {
        if(tableview.getSelectionModel().getSelectedItem() != null)
            selectedcomp = new Complaints(tableview.getSelectionModel().getSelectedItem());
    }
    @FXML
    void DeleteRowUpdateDB(ActionEvent event) {
        String Reply=ReplyTF.getText();
        String msg="answercomp#"+selectedcomp.getComplaintid()+"#"+Reply;
        MyChat.sendMSG(msg);
        String Rep=MyChat.getMSG();
        ObservableList<Complaints> comps = getDBcomplaints();
        tableview.setItems(comps);

    }

    @FXML
    void RefreshTable(ActionEvent event) {
        ObservableList<Complaints> comps = getDBcomplaints();
        tableview.setItems(comps);
    }

    @FXML
    void initialize() {
        assert rootPane != null : "fx:id=\"rootPane\" was not injected: check your FXML file 'CSView.fxml'.";
        assert tableview != null : "fx:id=\"tableview\" was not injected: check your FXML file 'CSView.fxml'.";
        assert complaintidCol != null : "fx:id=\"complaintidCol\" was not injected: check your FXML file 'CSView.fxml'.";
        assert dateandtimeCol != null : "fx:id=\"dateandtimeCol\" was not injected: check your FXML file 'CSView.fxml'.";
        assert complaintCol != null : "fx:id=\"complaintCol\" was not injected: check your FXML file 'CSView.fxml'.";
        assert orderidCol != null : "fx:id=\"orderidCol\" was not injected: check your FXML file 'CSView.fxml'.";
        assert ReplyTF != null : "fx:id=\"ReplyTF\" was not injected: check your FXML file 'CSView.fxml'.";
        assert SubmitReply != null : "fx:id=\"SubmitReply\" was not injected: check your FXML file 'CSView.fxml'.";
        assert alabel != null : "fx:id=\"alabel\" was not injected: check your FXML file 'CSView.fxml'.";
        assert RefundTF != null : "fx:id=\"RefundTF\" was not injected: check your FXML file 'CSView.fxml'.";
        assert refundlabel != null : "fx:id=\"refundlabel\" was not injected: check your FXML file 'CSView.fxml'.";
        assert SignoutBtn != null : "fx:id=\"SignoutBtn\" was not injected: check your FXML file 'CSView.fxml'.";
        assert RefreshBtn != null : "fx:id=\"RefreshBtn\" was not injected: check your FXML file 'CSView.fxml'.";



        complaintidCol.setCellValueFactory(new PropertyValueFactory<Complaints, String>("complaintid"));
        dateandtimeCol.setCellValueFactory(new PropertyValueFactory<Complaints, String>("dateandtime"));
        complaintCol.setCellValueFactory(new PropertyValueFactory<Complaints, String>("complaint"));
        orderidCol.setCellValueFactory(new PropertyValueFactory<Complaints, String>("orderid"));


        ObservableList<Complaints> complaints1 = getDBcomplaints();
        tableview.setItems(complaints1);

    }
        public ObservableList<Complaints> getComplaintsFromString(String complaints2)
        {
            ObservableList<Complaints> complaints4 = FXCollections.observableArrayList();
            String icomplaintID, idateAndTime, icomplaint, iorderID;
            String[] rows = complaints2.split("/");
            for(String row : rows)
            {
                String[] cols = row.split("#");
                icomplaintID = cols[0];
                idateAndTime = cols[1];
                icomplaint = cols[2];
                iorderID = cols[3];
                Complaints complaints3 = new Complaints(icomplaintID, iorderID, icomplaint, idateAndTime);
                complaints4.add(complaints3);
            }
            return complaints4;
        }
        public ObservableList<Complaints> getDBcomplaints(){
            MyChat.sendMSG("getunansweredcomp");
            String  complaints = MyChat.getMSG();
            return getComplaintsFromString(complaints);
        }
    }
