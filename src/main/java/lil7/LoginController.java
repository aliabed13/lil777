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
import javafx.scene.text.Text;

public class LoginController {
    public String t2="Please fill all fields!!!!!!";
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private TextField useridField;

    @FXML
    private TextField passwordfield;

    @FXML
    private Button loginbtn;

    @FXML
    private Button gosignup;

    @FXML
    private Label labelo;

    @FXML
    private Button viewcatalog;

    @FXML
    void PassToString(ActionEvent event) {

    }

    @FXML
    void SignUpPage(ActionEvent event) throws Exception {
        AnchorPane pane= FXMLLoader.load(getClass().getResource("Signup.fxml"));
        rootPane.getChildren().setAll(pane);

    }

    @FXML
    void UserToString(ActionEvent event) {

    }

    @FXML
    void login(ActionEvent event) throws Exception {
        if((!useridField.getText().isEmpty())&&(!passwordfield.getText().isEmpty()))
        {
            boolean access = false;
            String user_type = null;
            String user_id = useridField.getText();
            String pass = passwordfield.getText();
            String msg = "login#" + user_id + "#" + pass;
            MyChat.sendMSG(msg);
            String Res = MyChat.getMSG();

            System.out.println(msg);

            System.out.println(Res);


            switch (Res) {
                case "SM":
                    user_type = "ManagerMain.fxml";
                    access = true;
                    break;
                case "C":
                    user_type = "Customer.fxml";
                    access = true;
                    break;
                case "CS":
                    user_type = "CSView.fxml";
                    access = true;
                    break;
                case "W":
                    user_type = "Worker.fxml";
                    access = true;
                    break;
                case "GM":
                    user_type = "GeneralManager.fxml";
                    access = true;
                    break;
            }
            String t = null;
            if (access) {
                App.user_name = new String(user_id);
                MyChat.sendMSG("getuserinfo#"+user_id);
                String str = MyChat.getMSG();
                String[] m = ((String) str).split("#");
                App.shopID = m[7];
                App.balance = m[6];

                AnchorPane pane = FXMLLoader.load(getClass().getResource(user_type));
                rootPane.getChildren().setAll(pane);
            } else {
                switch (Res) {
                    case "wrongpass":
                        t = "WRONG PASSWORD, PLEASE TRY AGAIN!";
                        labelo.setText(t);
                        break;
                    case "accessdenied":
                        t = "USER IS BLOCKED! PLEASE CONTACT MANAGMENT.";
                        labelo.setText(t);
                        break;
                    case "nosuchuser":
                        t = "NO SUCH USER PLEASE CREATE NEW ACCOUNT.";
                        labelo.setText(t);
                        break;
                }
            }
        }
        else
        {
            labelo.setText(t2);
        }

    }

    @FXML
    void ViewCatalog(ActionEvent event) {
        try {
            App.shopID = "haifa";
            App.user_name = "";
            AnchorPane pane= FXMLLoader.load(getClass().getResource("catalogViewOnly.fxml"));
            rootPane.getChildren().setAll(pane);
        }
        catch (IOException e) {}

    }

    @FXML
    void initialize() {
        assert rootPane != null : "fx:id=\"rootPane\" was not injected: check your FXML file 'Login.fxml'.";
        assert useridField != null : "fx:id=\"useridField\" was not injected: check your FXML file 'Login.fxml'.";
        assert passwordfield != null : "fx:id=\"passwordfield\" was not injected: check your FXML file 'Login.fxml'.";
        assert loginbtn != null : "fx:id=\"loginbtn\" was not injected: check your FXML file 'Login.fxml'.";
        assert gosignup != null : "fx:id=\"gosignup\" was not injected: check your FXML file 'Login.fxml'.";
        assert labelo != null : "fx:id=\"labelo\" was not injected: check your FXML file 'Login.fxml'.";
        assert viewcatalog != null : "fx:id=\"viewcatalog\" was not injected: check your FXML file 'Login.fxml'.";

    }
}
