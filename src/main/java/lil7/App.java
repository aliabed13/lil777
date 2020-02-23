package lil7;

import Chat.ClientConsole;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import javafx.scene.layout.AnchorPane;


/**
 * JavaFX App
 */
public class App extends Application {
    final public static int DEFAULT_PORT = 5555;
    public static String balance;
    private static Scene scene;
    public static  User selected_user_edit;
    static String go_back_to;
    public static String user_name;
    public static item selectedItem;
    public static String shopID;
    public static  User selected_user;

    public static SDType SelfDes;

    public static int shopId;

    public static String username;


    public static item[] catItems;
    public static int catItsSz;

    public static SDType[] SDItems;
    public static int SDItsSz;

    public static String paymentWay;
    public static boolean b;

    @Override
    public void start(Stage primaryStage) throws IOException {

        URL url =getClass().getResource("Login.fxml");
        AnchorPane pane = FXMLLoader.load(url);
        Scene scene = new Scene( pane );

        primaryStage.setScene( scene );
        primaryStage.setTitle("Lilach");
        primaryStage.show();
    }
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        String host = "";
        int port = 0;  //The port number
        String loginID = "";
        try
        {
            loginID = args[0];
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println("usage: java ClientConsole loginID [host [port]]");
            System.exit(1);
        }
        try
        {
            host = args[1];
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            host = "localhost";
        }
        try {
            port = Integer.parseInt(args[2]);
        } catch (ArrayIndexOutOfBoundsException e){
            port = DEFAULT_PORT;
        }
        MyChat.chat = new ClientConsole(loginID, host, port);
        MyChat.lastMSG = new String();

        launch();
    }

}
