package lil7;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class SeeComplaintsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private TableView<Complaints> tableview;

    @FXML
    private TableColumn<Complaints,String> complaintidCol;

    @FXML
    private TableColumn<Complaints,String> complaintCol;

    @FXML
    private TableColumn<Complaints,String> answerCol;

    @FXML
    private TableColumn<Complaints,String> dateandtimeCol;

    @FXML
    private TableColumn<Complaints,String> orderidCol;

    @FXML
    private Button GoBackBtn;


    @FXML
    void BackToMain(ActionEvent event) throws Exception{
        AnchorPane pane= FXMLLoader.load(getClass().getResource("Customer.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    @FXML
    void initialize() {
        assert rootPane != null : "fx:id=\"rootPane\" was not injected: check your FXML file 'SeeComplaints.fxml'.";
        assert tableview != null : "fx:id=\"tableview\" was not injected: check your FXML file 'SeeComplaints.fxml'.";
        assert complaintidCol != null : "fx:id=\"complaintidCol\" was not injected: check your FXML file 'SeeComplaints.fxml'.";
        assert complaintCol != null : "fx:id=\"complaintCol\" was not injected: check your FXML file 'SeeComplaints.fxml'.";
        assert answerCol != null : "fx:id=\"answerCol\" was not injected: check your FXML file 'SeeComplaints.fxml'.";
        assert dateandtimeCol != null : "fx:id=\"dateandtimeCol\" was not injected: check your FXML file 'SeeComplaints.fxml'.";
        assert orderidCol != null : "fx:id=\"orderidCol\" was not injected: check your FXML file 'SeeComplaints.fxml'.";
        assert GoBackBtn != null : "fx:id=\"GoBackBtn\" was not injected: check your FXML file 'SeeComplaints.fxml'.";


        MyChat.sendMSG("getusercomp#"+ App.user_name);
        String  complaints = MyChat.getMSG();
        if(complaints.compareTo("NULL") != 0) {

            complaintidCol.setCellValueFactory(new PropertyValueFactory<Complaints, String>("complaintid"));
            dateandtimeCol.setCellValueFactory(new PropertyValueFactory<Complaints, String>("dateandtime"));
            complaintCol.setCellValueFactory(new PropertyValueFactory<Complaints, String>("complaint"));
            orderidCol.setCellValueFactory(new PropertyValueFactory<Complaints, String>("orderid"));
            answerCol.setCellValueFactory(new PropertyValueFactory<Complaints, String>("answer"));


            ObservableList<Complaints> complaints1 = getDBcomplaints();
            tableview.setItems(complaints1);
        }
    }

    public ObservableList<Complaints> getComplaintsFromString(String complaints2)
    {
        ObservableList<Complaints> complaints4 = FXCollections.observableArrayList();
        String icomplaintID, idateAndTime, icomplaint, iorderID,ianswer;
        String[] rows = complaints2.split("/");
        for(String row : rows)
        {
            String[] cols = row.split("#");

//            System.out.println(row);

            icomplaintID = cols[0];
            idateAndTime = cols[3];
            icomplaint = cols[1];
            iorderID = cols[4];
            ianswer=cols[2];

            Complaints complaints3 = new Complaints(icomplaintID, iorderID, icomplaint, idateAndTime,ianswer);
            complaints4.add(complaints3);
        }
        return complaints4;
    }
    public ObservableList<Complaints> getDBcomplaints(){
        MyChat.sendMSG("getusercomp#"+ App.user_name);
        String  complaints = MyChat.getMSG();
        return getComplaintsFromString(complaints);
    }

}
