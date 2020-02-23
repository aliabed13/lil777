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
import javafx.scene.layout.AnchorPane;

public class  Builder2Controller{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    @FXML
    private AnchorPane rootPane;

    @FXML
    private SplitMenuButton colorName;

    @FXML
    private MenuItem pic1;

    @FXML
    private MenuItem pic2;

    @FXML
    private MenuItem pic3;

    @FXML
    private MenuItem pic4;

    @FXML
    private MenuItem pic5;

    @FXML
    private Button BackBtn;

    @FXML
    private Button FinishBtn;

    @FXML
    private Label itemTypeToBuild;

    private String clr;


    @FXML
    void initialize() {
        assert rootPane != null : "fx:id=\"rootPane\" was not injected: check your FXML file 'builder2view.fxml'.";
        assert colorName != null : "fx:id=\"colorName\" was not injected: check your FXML file 'builder2view.fxml'.";
        assert pic1 != null : "fx:id=\"pic1\" was not injected: check your FXML file 'builder2view.fxml'.";
        assert pic2 != null : "fx:id=\"pic2\" was not injected: check your FXML file 'builder2view.fxml'.";
        assert pic3 != null : "fx:id=\"pic3\" was not injected: check your FXML file 'builder2view.fxml'.";
        assert pic4 != null : "fx:id=\"pic4\" was not injected: check your FXML file 'builder2view.fxml'.";
        assert pic5 != null : "fx:id=\"pic5\" was not injected: check your FXML file 'builder2view.fxml'.";
        assert BackBtn != null : "fx:id=\"BackBtn\" was not injected: check your FXML file 'builder2view.fxml'.";
        assert FinishBtn != null : "fx:id=\"FinishBtn\" was not injected: check your FXML file 'builder2view.fxml'.";
        assert itemTypeToBuild != null : "fx:id=\"itemTypeToBuild\" was not injected: check your FXML file 'builder2view.fxml'.";

        App.SelfDes.setDominantColor("red");

    }
    @FXML
    public void BackAction(ActionEvent event) {
        URL url = getClass().getResource("builderView.fxml");
        AnchorPane pane;
        try {
            pane = FXMLLoader.load(url);
            rootPane.getChildren().setAll(pane);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void pick1(ActionEvent event) {
        clr = new String("Yellow");
    }

    public void pick2(ActionEvent event) {
        clr = new String("Red");
    }

    public void pick3(ActionEvent event) {
        clr = new String("Sky");
    }

    public void pick4(ActionEvent event) {
        clr = new String("Tourques");
    }

    public void pick5(ActionEvent event) {
        clr = new String("White");
    }


    public void FinishAction(ActionEvent event) {
        App.SelfDes.setDominantColor(clr);
        URL url = getClass().getResource("OrderView.fxml");
        AnchorPane pane;
        try {
            pane = FXMLLoader.load(url);
            rootPane.getChildren().setAll(pane);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}