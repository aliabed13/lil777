package lil7;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SubmitComplaintController {

    @FXML
    private AnchorPane rootPane;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea TexAreacomp;

    @FXML
    private Label namelabelComp;

    @FXML
    private Button GoBackCompBtn;

    @FXML
    private Button SubmitCompBtn;

    @FXML
    private Label OrderNField;

    @FXML
    private Button OrderHisBtn;

    @FXML
    void GoBackToCostumer(ActionEvent event) throws Exception{
        AnchorPane pane= FXMLLoader.load(getClass().getResource("Customer.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    @FXML
    void GoToOrderHis(ActionEvent event) throws Exception {
        App.go_back_to="SubmitComplaint.fxml";
        AnchorPane pane= FXMLLoader.load(getClass().getResource("SeeOrders.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    @FXML
    void SubmitCompAndGoBack(ActionEvent event) throws Exception {
        String comp = TexAreacomp.getText();
        //MyChat.sendMSG(comp);
        //String Res=MyChat.getMSG();
        //add complaint to user conplaints in SeeComplaints.
        AnchorPane pane= FXMLLoader.load(getClass().getResource("Customer.fxml"));
        rootPane.getChildren().setAll(pane);

    }

    @FXML
    void initialize() {
        assert TexAreacomp != null : "fx:id=\"TexAreacomp\" was not injected: check your FXML file 'SubmitComplaint.fxml'.";
        assert namelabelComp != null : "fx:id=\"namelabelComp\" was not injected: check your FXML file 'SubmitComplaint.fxml'.";
        assert GoBackCompBtn != null : "fx:id=\"GoBackCompBtn\" was not injected: check your FXML file 'SubmitComplaint.fxml'.";
        assert SubmitCompBtn != null : "fx:id=\"SubmitCompBtn\" was not injected: check your FXML file 'SubmitComplaint.fxml'.";
        assert OrderNField != null : "fx:id=\"OrderNField\" was not injected: check your FXML file 'SubmitComplaint.fxml'.";
        assert OrderHisBtn != null : "fx:id=\"OrderHisBtn\" was not injected: check your FXML file 'SubmitComplaint.fxml'.";

    }
}
