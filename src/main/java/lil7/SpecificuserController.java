package lil7;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class SpecificuserController {
    public String[] cols;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane rootPane;

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
    private Label l6;

    @FXML
    private Label l7;

    @FXML
    private Label usernamelab;

    @FXML
    private Label lab;

    @FXML
    private Label phonelab;

    @FXML
    private Label storelab;

    @FXML
    private Label emailab;

    @FXML
    private Label passwordlab;

    @FXML
    private Label statuslab;

    @FXML
    private Label ad;

    @FXML
    private Label Addresslab;

    @FXML
    private Label filler;

    @FXML
    private Label ud;

    @FXML
    private Label em;

    @FXML
    private Label ph;

    @FXML
    private Label st;

    @FXML
    private Label sto;

    @FXML
    private Label adr;

    @FXML
    private Label pais;

    @FXML
    private TextField EmailTF;

    @FXML
    private TextField StatusTF;

    @FXML
    private TextField PassTF;

    @FXML
    private TextField StoreTF;

    @FXML
    private TextField AddressTF;

    @FXML
    private TextField PhoneTF;

    @FXML
    private Button BackBtn;

    @FXML
    private Button ChangeBtn;

    @FXML
    void BackToEditUsers(ActionEvent event) throws Exception {
        AnchorPane pane= FXMLLoader.load(getClass().getResource("EditCustomers.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    @FXML
    void ChangeInfoBtn(ActionEvent event) {

        String newmail=EmailTF.getText();
        if(EmailTF.getText().compareTo("")==0)
            newmail = cols[3];
        String newstatus=StatusTF.getText();
        if(newstatus.equals(""))
            newstatus = statuslab.getText();
        String newpass=PassTF.getText();
        if(newpass.equals(""))
            newpass = passwordlab.getText();
        String newstore=StoreTF.getText();
        if(newstore.equals(""))
            newstore = storelab.getText();
        String newadress=AddressTF.getText();
        if(newadress.equals(""))
            newadress = Addresslab.getText();

        String newphone=PhoneTF.getText();
        if(newphone.equals(""))
            newphone = phonelab.getText();

        String msg="updateuser#"+usernamelab.getText()+"#"+newpass+"#"+newadress+"#"+newmail+"#"+newphone+"#"+newstore+"#"+
        cols[8]+"#"+newstatus;

        MyChat.sendMSG(msg);
        String res=MyChat.getMSG();
        fixlab();
    }

    @FXML
    void initialize() {
        assert rootPane != null : "fx:id=\"rootPane\" was not injected: check your FXML file 'Specificuser.fxml'.";
        assert l1 != null : "fx:id=\"l1\" was not injected: check your FXML file 'Specificuser.fxml'.";
        assert l2 != null : "fx:id=\"l2\" was not injected: check your FXML file 'Specificuser.fxml'.";
        assert l3 != null : "fx:id=\"l3\" was not injected: check your FXML file 'Specificuser.fxml'.";
        assert l4 != null : "fx:id=\"l4\" was not injected: check your FXML file 'Specificuser.fxml'.";
        assert l5 != null : "fx:id=\"l5\" was not injected: check your FXML file 'Specificuser.fxml'.";
        assert l6 != null : "fx:id=\"l6\" was not injected: check your FXML file 'Specificuser.fxml'.";
        assert l7 != null : "fx:id=\"l7\" was not injected: check your FXML file 'Specificuser.fxml'.";
        assert usernamelab != null : "fx:id=\"usernamelab\" was not injected: check your FXML file 'Specificuser.fxml'.";
        assert lab != null : "fx:id=\"lab\" was not injected: check your FXML file 'Specificuser.fxml'.";
        assert phonelab != null : "fx:id=\"phonelab\" was not injected: check your FXML file 'Specificuser.fxml'.";
        assert storelab != null : "fx:id=\"storelab\" was not injected: check your FXML file 'Specificuser.fxml'.";
        assert emailab != null : "fx:id=\"emailab\" was not injected: check your FXML file 'Specificuser.fxml'.";
        assert passwordlab != null : "fx:id=\"passwordlab\" was not injected: check your FXML file 'Specificuser.fxml'.";
        assert statuslab != null : "fx:id=\"statuslab\" was not injected: check your FXML file 'Specificuser.fxml'.";
        assert ad != null : "fx:id=\"ad\" was not injected: check your FXML file 'Specificuser.fxml'.";
        assert Addresslab != null : "fx:id=\"Addresslab\" was not injected: check your FXML file 'Specificuser.fxml'.";
        assert filler != null : "fx:id=\"filler\" was not injected: check your FXML file 'Specificuser.fxml'.";
        assert ud != null : "fx:id=\"ud\" was not injected: check your FXML file 'Specificuser.fxml'.";
        assert em != null : "fx:id=\"em\" was not injected: check your FXML file 'Specificuser.fxml'.";
        assert ph != null : "fx:id=\"ph\" was not injected: check your FXML file 'Specificuser.fxml'.";
        assert st != null : "fx:id=\"st\" was not injected: check your FXML file 'Specificuser.fxml'.";
        assert sto != null : "fx:id=\"sto\" was not injected: check your FXML file 'Specificuser.fxml'.";
        assert adr != null : "fx:id=\"adr\" was not injected: check your FXML file 'Specificuser.fxml'.";
        assert pais != null : "fx:id=\"pais\" was not injected: check your FXML file 'Specificuser.fxml'.";
        assert EmailTF != null : "fx:id=\"EmailTF\" was not injected: check your FXML file 'Specificuser.fxml'.";
        assert StatusTF != null : "fx:id=\"StatusTF\" was not injected: check your FXML file 'Specificuser.fxml'.";
        assert PassTF != null : "fx:id=\"PassTF\" was not injected: check your FXML file 'Specificuser.fxml'.";
        assert StoreTF != null : "fx:id=\"StoreTF\" was not injected: check your FXML file 'Specificuser.fxml'.";
        assert AddressTF != null : "fx:id=\"AddressTF\" was not injected: check your FXML file 'Specificuser.fxml'.";
        assert PhoneTF != null : "fx:id=\"PhoneTF\" was not injected: check your FXML file 'Specificuser.fxml'.";
        assert BackBtn != null : "fx:id=\"BackBtn\" was not injected: check your FXML file 'Specificuser.fxml'.";
        assert ChangeBtn != null : "fx:id=\"ChangeBtn\" was not injected: check your FXML file 'Specificuser.fxml'.";


        fixlab();
        /*usernamelab.setText(App.selected_user_edit.getUsername());
        emailab.setText(App.selected_user_edit.getEmail());
        phonelab.setText(App.selected_user_edit.getPhone());
        statuslab.setText(App.selected_user_edit.getBlocked());
    //    storelab.setText(App.selected_user_edit.getStoreid());
        lab.setText(App.selected_user_edit.getAuth());
       // passwordlab.setText(App.selected_user_edit.getPassword());
      //  Addresslab.setText(App.selected_user_edit.getAddress());

        String msg="getuserinfo#"+App.selected_user_edit.getUsername();
        MyChat.sendMSG(msg);
        String row=MyChat.getMSG();
        cols = row.split("#");

        //User user=new User(iusername,cols[1],cols[2],cols[3],cols[4],cols[5],cols[6],cols[7],cols[8],cols[9]);
        passwordlab.setText(cols[2]);
        storelab.setText(cols[7]);
        Addresslab.setText(cols[3]);*/
    }
    public void fixlab()
    {
        usernamelab.setText(App.selected_user_edit.getUsername());
        emailab.setText(App.selected_user_edit.getEmail());
        phonelab.setText(App.selected_user_edit.getPhone());
        statuslab.setText(App.selected_user_edit.getBlocked());
        String msg="getuserinfo#"+App.selected_user_edit.getUsername();
        MyChat.sendMSG(msg);
        String row=MyChat.getMSG();
        cols = row.split("#");
        passwordlab.setText(cols[1]);
        storelab.setText(cols[7]);
        Addresslab.setText(cols[2]);
    }
}
