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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class SignupController {

    public String store=null;
    public String labMsg="Username already used , please select another one";
    public String labMsg2="Please fill in all the fields";
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private Label BGUserID;

    @FXML
    private Label BGPhone;

    @FXML
    private Label BGEmail;

    @FXML
    private Label BGPassword;

    @FXML
    private Label BGAddress;

    @FXML
    private TextField TFBG1;

    @FXML
    private TextField TFBG11;

    @FXML
    private TextField TFBG13;

    @FXML
    private TextField TFBG14;

    @FXML
    private TextField TFBG15;

    @FXML
    private Label headlabel;

    @FXML
    private Button back;

    @FXML
    private Button FinishSignup;

    @FXML
    private Label BGCC;

    @FXML
    private TextField TFBG141;

    @FXML
    private Label BGCC1;

    @FXML
    private VBox v1;

    @FXML
    private SplitMenuButton splitStore;

    @FXML
    private MenuItem haifa;

    @FXML
    private MenuItem telaviv;

    @FXML
    private Label la;

    @FXML
    void ChooseHaifa(ActionEvent event) {
        splitStore.setText("Haifa");
        store="haifa";

    }

    @FXML
    void ChooseTelAviv(ActionEvent event) {
        splitStore.setText("Tel Aviv");
        store="telaviv";
    }

    @FXML
    void SendSignupinfo(ActionEvent event) throws Exception {
        //TODO: update SendSigUpInfo to send the info of new user to the db and then opens the right user gui.
        if((!TFBG11.getText().isEmpty())&&(!TFBG15.getText().isEmpty())&&(!TFBG13.getText().isEmpty())&&(!TFBG14.getText().isEmpty())&&(!TFBG141.getText().isEmpty())&&(store!=null))
        {
            String user_id=TFBG1.getText();
            String check="getuserinfo#"+user_id;
            MyChat.sendMSG(check);
            String Exists=MyChat.getMSG();
            if(Exists.compareTo("nouser")==0)
            {
                String email = TFBG15.getText();
                String pass = TFBG11.getText();
                String phone_num = TFBG13.getText();
                String address = TFBG14.getText();
                String credit_card = TFBG141.getText();
                String sign_up_msg = "adduser#" + user_id + "#" + pass + "#" + address + "#" + email + "#" + phone_num + "#" + store + "#C#"+credit_card;
                MyChat.sendMSG(sign_up_msg);
                String ans = MyChat.getMSG();
                System.out.println(ans);
                AnchorPane pane = FXMLLoader.load(getClass().getResource("AddedView.fxml"));
                rootPane.getChildren().setAll(pane);
            }
            else
                la.setText(labMsg);
        }
        else
            la.setText(labMsg2);
            //ChatC.send(sign_up_msg);
            //String new_user_ok=ChatC.get();
            //add if to know weather the registration is OK.



    }


    @FXML
    void gobacktomain(ActionEvent event)throws Exception {
        AnchorPane pane= FXMLLoader.load(getClass().getResource("Login.fxml"));
        rootPane.getChildren().setAll(pane);
    }
    @FXML
    void initialize() {
        assert rootPane != null : "fx:id=\"rootPane\" was not injected: check your FXML file 'Signup.fxml'.";
        assert BGUserID != null : "fx:id=\"BGUserID\" was not injected: check your FXML file 'Signup.fxml'.";
        assert BGPhone != null : "fx:id=\"BGPhone\" was not injected: check your FXML file 'Signup.fxml'.";
        assert BGEmail != null : "fx:id=\"BGEmail\" was not injected: check your FXML file 'Signup.fxml'.";
        assert BGPassword != null : "fx:id=\"BGPassword\" was not injected: check your FXML file 'Signup.fxml'.";
        assert BGAddress != null : "fx:id=\"BGAddress\" was not injected: check your FXML file 'Signup.fxml'.";
        assert TFBG1 != null : "fx:id=\"TFBG1\" was not injected: check your FXML file 'Signup.fxml'.";
        assert TFBG11 != null : "fx:id=\"TFBG11\" was not injected: check your FXML file 'Signup.fxml'.";
        assert TFBG13 != null : "fx:id=\"TFBG13\" was not injected: check your FXML file 'Signup.fxml'.";
        assert TFBG14 != null : "fx:id=\"TFBG14\" was not injected: check your FXML file 'Signup.fxml'.";
        assert TFBG15 != null : "fx:id=\"TFBG15\" was not injected: check your FXML file 'Signup.fxml'.";
        assert headlabel != null : "fx:id=\"headlabel\" was not injected: check your FXML file 'Signup.fxml'.";
        assert back != null : "fx:id=\"back\" was not injected: check your FXML file 'Signup.fxml'.";
        assert FinishSignup != null : "fx:id=\"FinishSignup\" was not injected: check your FXML file 'Signup.fxml'.";
        assert BGCC != null : "fx:id=\"BGCC\" was not injected: check your FXML file 'Signup.fxml'.";
        assert TFBG141 != null : "fx:id=\"TFBG141\" was not injected: check your FXML file 'Signup.fxml'.";
        assert BGCC1 != null : "fx:id=\"BGCC1\" was not injected: check your FXML file 'Signup.fxml'.";
        assert v1 != null : "fx:id=\"v1\" was not injected: check your FXML file 'Signup.fxml'.";
        assert splitStore != null : "fx:id=\"splitStore\" was not injected: check your FXML file 'Signup.fxml'.";
        assert haifa != null : "fx:id=\"haifa\" was not injected: check your FXML file 'Signup.fxml'.";
        assert telaviv != null : "fx:id=\"telaviv\" was not injected: check your FXML file 'Signup.fxml'.";
        assert la != null : "fx:id=\"la\" was not injected: check your FXML file 'Signup.fxml'.";

    }
}
