package lil7;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class ReportsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private Label HeadLabel;

    @FXML
    private TableView<?> tablecompHAifa;

    @FXML
    private TableView<?> tableCompTel;

    @FXML
    private Label LabelHaifa;//slot1 (left)

    @FXML
    private Label LabelTelAviv;//slot2  (right)

    @FXML
    private TableView<?> tableOrdersHaifa;

    @FXML
    private TableColumn<?, ?> orsl1cl1;

    @FXML
    private TableView<?> tableOrdersTel;

    @FXML
    private TableColumn<?, ?> orsl2cl1;

    @FXML
    private TableColumn<?, ?> orsl2cl2;

    @FXML
    private SplitMenuButton choosingmenu;

    @FXML
    private MenuItem option1;

    @FXML
    private MenuItem option2;

    @FXML
    private SplitMenuButton monthslot1;

    @FXML
    private MenuItem m1;

    @FXML
    private MenuItem m2;

    @FXML
    private MenuItem m3;

    @FXML
    private MenuItem m4;

    @FXML
    private MenuItem m5;

    @FXML
    private MenuItem m6;

    @FXML
    private MenuItem m7;

    @FXML
    private MenuItem m8;

    @FXML
    private MenuItem m9;

    @FXML
    private MenuItem m10;

    @FXML
    private MenuItem m11;

    @FXML
    private MenuItem m12;

    @FXML
    private Label yearlabel;

    @FXML
    private TextField yearfield1;

    @FXML
    private Button gnrtbtn;

    @FXML
    private Button backbtn;

    @FXML
    private SplitMenuButton monthslot2;

    @FXML
    private MenuItem m21;

    @FXML
    private MenuItem m31;

    @FXML
    private MenuItem m41;

    @FXML
    private MenuItem m51;

    @FXML
    private MenuItem m61;

    @FXML
    private MenuItem m71;

    @FXML
    private MenuItem m81;

    @FXML
    private MenuItem m91;

    @FXML
    private MenuItem m101;

    @FXML
    private MenuItem m111;

    @FXML
    private MenuItem m121;

    @FXML
    private TextField yearfield2;

    @FXML
    private Label yearlabel1;

    @FXML
    private SplitMenuButton storeslot1;

    @FXML
    private MenuItem sl1sth;

    @FXML
    private MenuItem sl1stt;

    @FXML
    private SplitMenuButton storeslot2;

    @FXML
    private MenuItem sl2sth;

    @FXML
    private MenuItem sl2stt;

    @FXML
    private Label slot1l;

    @FXML
    private Label slot2l;

    String monthlot1;
    String monthlot2;
    String yearslot1;
    String yearslot2;
    String storeslot11;
    String storeslot21;
    String type;

    @FXML
    void BringReport(ActionEvent event) {
        if(App.go_back_to.equals("ManagerMain.fxml"))
        {
            String msg="getstoreordersbymonth#";
            String msg2="getstoreordersbymonth#";
            storeslot11=App.shopID;
            storeslot21=App.shopID;
            yearslot1=yearfield1.getText();
            yearslot2=yearfield2.getText();
            msg+=(storeslot11 + yearslot1 + monthlot1);
            msg2+=(storeslot21 + yearslot2 + monthlot2);
//    		MyChat.sendMSG(msg);
//    		String res=MyChat.getMSG();
//    		MyChat.sendMSG(msg2);
//    		String res2=MyChat.getMSG();
//    		view slot 1 on tableOrdersHaifa
//			view slot 2 on tableOrdersTel (el tasmeyat stam)

        }
    	else {
            String msg="getstoreordersbymonth#";
            String msg2="getstoreordersbymonth#";
            yearslot1=yearfield1.getText();
            yearslot2=yearfield2.getText();
            msg+=(storeslot11 + yearslot1 + monthlot1);
            msg2+=(storeslot21 + yearslot2 + monthlot2);
//    		MyChat.sendMSG(msg);
//    		String res=MyChat.getMSG();
//    		MyChat.sendMSG(msg2);
//    		String res2=MyChat.getMSG();
//    		view slot 1 on tableOrdersHaifa
//			view slot 2 on tableOrdersTel (el tasmeyat stam)
        }
        if(App.go_back_to.equals("ManagerMain.fxml"))
        {
            String msg="getstorecompbymonth#";
            String msg2="getstorecompbymonth#";
            storeslot11=App.shopID;
            storeslot21=App.shopID;
            yearslot1=yearfield1.getText();
            yearslot2=yearfield2.getText();
            msg+=(storeslot11 + yearslot1 + monthlot1);
            msg2+=(storeslot21 + yearslot2 + monthlot2);
//    		MyChat.sendMSG(msg);
//    		String res=MyChat.getMSG();
//    		MyChat.sendMSG(msg2);
//    		String res2=MyChat.getMSG();
//    		view slot 1 on tableOrdersHaifa
//			view slot 2 on tableOrdersTel (el tasmeyat stam)

        }
    	else {
            String msg="getstorecompbymonth#";
            String msg2="getstorecompbymonth#";
            yearslot1=yearfield1.getText();
            yearslot2=yearfield2.getText();
            msg+=(storeslot11 + yearslot1 + monthlot1);
            msg2+=(storeslot21 + yearslot2 + monthlot2);
//    		MyChat.sendMSG(msg);
//    		String res=MyChat.getMSG();
//    		MyChat.sendMSG(msg2);
//    		String res2=MyChat.getMSG();
//    		view slot 1 on tablecompHAifa
//			view slot 2 on tableCompTel (el tasmeyat stam)
        }

    }

    @FXML
    void ChooseMonth1(ActionEvent event) {
        monthlot2="01";
    }

    @FXML
    void ChooseMonth10(ActionEvent event) {
        monthlot2="10";
    }

    @FXML
    void ChooseMonth10s(ActionEvent event) {
        monthlot1="10";
    }

    @FXML
    void ChooseMonth11(ActionEvent event) {
        monthlot2="11";
    }

    @FXML
    void ChooseMonth11s(ActionEvent event) {
        monthlot1="11";
    }

    @FXML
    void ChooseMonth12(ActionEvent event) {
        monthlot2="12";
    }

    @FXML
    void ChooseMonth12s(ActionEvent event) {
        monthlot1="12";
    }

    @FXML
    void ChooseMonth1s(ActionEvent event) {
        monthlot1="01";
    }

    @FXML
    void ChooseMonth2(ActionEvent event) {
        monthlot2="02";
    }

    @FXML
    void ChooseMonth2s(ActionEvent event) {
        monthlot1="02";
    }

    @FXML
    void ChooseMonth3(ActionEvent event) {
        monthlot2="03";
    }

    @FXML
    void ChooseMonth3s(ActionEvent event) {
        monthlot1="03";
    }

    @FXML
    void ChooseMonth4(ActionEvent event) {
        monthlot2="04";
    }

    @FXML
    void ChooseMonth4s(ActionEvent event) {
        monthlot1="04";
    }

    @FXML
    void ChooseMonth5(ActionEvent event) {
        monthlot2="05";
    }

    @FXML
    void ChooseMonth5s(ActionEvent event) {
        monthlot1="05";
    }

    @FXML
    void ChooseMonth6(ActionEvent event) {
        monthlot2="06";
    }

    @FXML
    void ChooseMonth6s(ActionEvent event) {
        monthlot1="06";
    }

    @FXML
    void ChooseMonth7(ActionEvent event) {
        monthlot2="07";
    }

    @FXML
    void ChooseMonth7s(ActionEvent event) {
        monthlot1="07";
    }

    @FXML
    void ChooseMonth8(ActionEvent event) {
        monthlot2="08";
    }

    @FXML
    void ChooseMonth8s(ActionEvent event) {
        monthlot1="08";
    }

    @FXML
    void ChooseMonth9(ActionEvent event) {
        monthlot2="09";
    }

    @FXML
    void ChooseMonth9s(ActionEvent event) {
        monthlot1="09";
    }

    @FXML
    void ChooseReport1(ActionEvent event) {
        type="order";
    }

    @FXML
    void ChooseReport2(ActionEvent event) {
        type="complaint";
    }

    @FXML
    void GoBack(ActionEvent event) throws Exception {
        if(App.go_back_to.equals("GeneralManager.fxml")) {
            storeslot2.setVisible(false);
            storeslot1.setVisible(false);
        }
        AnchorPane pane= FXMLLoader.load(getClass().getResource(App.go_back_to));
        rootPane.getChildren().setAll(pane);
    }

    @FXML
    void SlotoneSelectHaifa(ActionEvent event) {
        storeslot11="haifa";
    }

    @FXML
    void SlotoneSelectTel(ActionEvent event) {
        storeslot11="telaviv";

    }

    @FXML
    void SlotowSelectHaifa(ActionEvent event) {
        storeslot21="haifa";
    }

    @FXML
    void SlottowSelectTel(ActionEvent event) {
        storeslot21="telaviv";
    }

    @FXML
    void initialize() {
        assert rootPane != null : "fx:id=\"rootPane\" was not injected: check your FXML file 'Reports.fxml'.";
        assert HeadLabel != null : "fx:id=\"HeadLabel\" was not injected: check your FXML file 'Reports.fxml'.";
        assert tablecompHAifa != null : "fx:id=\"tablecompHAifa\" was not injected: check your FXML file 'Reports.fxml'.";
        assert tableCompTel != null : "fx:id=\"tableCompTel\" was not injected: check your FXML file 'Reports.fxml'.";
        assert LabelHaifa != null : "fx:id=\"LabelHaifa\" was not injected: check your FXML file 'Reports.fxml'.";
        assert LabelTelAviv != null : "fx:id=\"LabelTelAviv\" was not injected: check your FXML file 'Reports.fxml'.";
        assert tableOrdersHaifa != null : "fx:id=\"tableOrdersHaifa\" was not injected: check your FXML file 'Reports.fxml'.";
        assert orsl1cl1 != null : "fx:id=\"orsl1cl1\" was not injected: check your FXML file 'Reports.fxml'.";
        assert tableOrdersTel != null : "fx:id=\"tableOrdersTel\" was not injected: check your FXML file 'Reports.fxml'.";
        assert orsl2cl1 != null : "fx:id=\"orsl2cl1\" was not injected: check your FXML file 'Reports.fxml'.";
        assert orsl2cl2 != null : "fx:id=\"orsl2cl2\" was not injected: check your FXML file 'Reports.fxml'.";
        assert choosingmenu != null : "fx:id=\"choosingmenu\" was not injected: check your FXML file 'Reports.fxml'.";
        assert option1 != null : "fx:id=\"option1\" was not injected: check your FXML file 'Reports.fxml'.";
        assert option2 != null : "fx:id=\"option2\" was not injected: check your FXML file 'Reports.fxml'.";
        assert monthslot1 != null : "fx:id=\"monthslot1\" was not injected: check your FXML file 'Reports.fxml'.";
        assert m1 != null : "fx:id=\"m1\" was not injected: check your FXML file 'Reports.fxml'.";
        assert m2 != null : "fx:id=\"m2\" was not injected: check your FXML file 'Reports.fxml'.";
        assert m3 != null : "fx:id=\"m3\" was not injected: check your FXML file 'Reports.fxml'.";
        assert m4 != null : "fx:id=\"m4\" was not injected: check your FXML file 'Reports.fxml'.";
        assert m5 != null : "fx:id=\"m5\" was not injected: check your FXML file 'Reports.fxml'.";
        assert m6 != null : "fx:id=\"m6\" was not injected: check your FXML file 'Reports.fxml'.";
        assert m7 != null : "fx:id=\"m7\" was not injected: check your FXML file 'Reports.fxml'.";
        assert m8 != null : "fx:id=\"m8\" was not injected: check your FXML file 'Reports.fxml'.";
        assert m9 != null : "fx:id=\"m9\" was not injected: check your FXML file 'Reports.fxml'.";
        assert m10 != null : "fx:id=\"m10\" was not injected: check your FXML file 'Reports.fxml'.";
        assert m11 != null : "fx:id=\"m11\" was not injected: check your FXML file 'Reports.fxml'.";
        assert m12 != null : "fx:id=\"m12\" was not injected: check your FXML file 'Reports.fxml'.";
        assert yearlabel != null : "fx:id=\"yearlabel\" was not injected: check your FXML file 'Reports.fxml'.";
        assert yearfield1 != null : "fx:id=\"yearfield1\" was not injected: check your FXML file 'Reports.fxml'.";
        assert gnrtbtn != null : "fx:id=\"gnrtbtn\" was not injected: check your FXML file 'Reports.fxml'.";
        assert backbtn != null : "fx:id=\"backbtn\" was not injected: check your FXML file 'Reports.fxml'.";
        assert monthslot2 != null : "fx:id=\"monthslot2\" was not injected: check your FXML file 'Reports.fxml'.";
        assert m21 != null : "fx:id=\"m21\" was not injected: check your FXML file 'Reports.fxml'.";
        assert m31 != null : "fx:id=\"m31\" was not injected: check your FXML file 'Reports.fxml'.";
        assert m41 != null : "fx:id=\"m41\" was not injected: check your FXML file 'Reports.fxml'.";
        assert m51 != null : "fx:id=\"m51\" was not injected: check your FXML file 'Reports.fxml'.";
        assert m61 != null : "fx:id=\"m61\" was not injected: check your FXML file 'Reports.fxml'.";
        assert m71 != null : "fx:id=\"m71\" was not injected: check your FXML file 'Reports.fxml'.";
        assert m81 != null : "fx:id=\"m81\" was not injected: check your FXML file 'Reports.fxml'.";
        assert m91 != null : "fx:id=\"m91\" was not injected: check your FXML file 'Reports.fxml'.";
        assert m101 != null : "fx:id=\"m101\" was not injected: check your FXML file 'Reports.fxml'.";
        assert m111 != null : "fx:id=\"m111\" was not injected: check your FXML file 'Reports.fxml'.";
        assert m121 != null : "fx:id=\"m121\" was not injected: check your FXML file 'Reports.fxml'.";
        assert yearfield2 != null : "fx:id=\"yearfield2\" was not injected: check your FXML file 'Reports.fxml'.";
        assert yearlabel1 != null : "fx:id=\"yearlabel1\" was not injected: check your FXML file 'Reports.fxml'.";
        assert storeslot1 != null : "fx:id=\"storeslot1\" was not injected: check your FXML file 'Reports.fxml'.";
        assert sl1sth != null : "fx:id=\"sl1sth\" was not injected: check your FXML file 'Reports.fxml'.";
        assert sl1stt != null : "fx:id=\"sl1stt\" was not injected: check your FXML file 'Reports.fxml'.";
        assert storeslot2 != null : "fx:id=\"storeslot2\" was not injected: check your FXML file 'Reports.fxml'.";
        assert sl2sth != null : "fx:id=\"sl2sth\" was not injected: check your FXML file 'Reports.fxml'.";
        assert sl2stt != null : "fx:id=\"sl2stt\" was not injected: check your FXML file 'Reports.fxml'.";
        assert slot1l != null : "fx:id=\"slot1l\" was not injected: check your FXML file 'Reports.fxml'.";
        assert slot2l != null : "fx:id=\"slot2l\" was not injected: check your FXML file 'Reports.fxml'.";
        if(App.go_back_to.equals("GeneralManager.fxml")) {
            storeslot2.setVisible(true);
            storeslot1.setVisible(true);
        }
    }
}
