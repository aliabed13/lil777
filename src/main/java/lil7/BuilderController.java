package lil7;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class BuilderController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private Label vaseLbl;

    @FXML
    private Label roseLbl;

    @FXML
    private Label bridalLbl;

    @FXML
    private Label bouquetLbl;

    @FXML
    private Button BackBtn;


    private List<SDType> list;

    private SDType t;

    @FXML
    public void type1Chosen(MouseEvent event) {
        App.SelfDes = new SDType("Vase","A beautiful flower in a vase");
        App.SelfDes.setPrice(5);
        cont();
    }
    public void type2Chosen(MouseEvent event) {
        App.SelfDes = new SDType("Rose","One rose for your lover");
        App.SelfDes.setPrice(2);
        cont();
    }
    public void type3Chosen(MouseEvent event) {
        App.SelfDes = new SDType("Bridal","Bridal Flower Bouquet");
        App.SelfDes.setPrice(45);
        cont();
    }
    public void type4Chosen(MouseEvent event) {
        App.SelfDes = new SDType("Bouquet","Casual Mixed Bouquet");
        App.SelfDes.setPrice(20);
        cont();
    }

    public void cont() {
        URL url = getClass().getResource("builder2View.fxml");
        AnchorPane pane;
        try {
            pane = FXMLLoader.load(url);
            rootPane.getChildren().setAll(pane);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void BackAction(ActionEvent event) {
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

    @FXML
    public void initialize() {
        assert rootPane != null : "fx:id=\"rootPane\" was not injected: check your FXML file 'builderView.fxml'.";
        assert vaseLbl != null : "fx:id=\"vaseLbl\" was not injected: check your FXML file 'builderView.fxml'.";
        assert roseLbl != null : "fx:id=\"roseLbl\" was not injected: check your FXML file 'builderView.fxml'.";
        assert bridalLbl != null : "fx:id=\"bridalLbl\" was not injected: check your FXML file 'builderView.fxml'.";
        assert bouquetLbl != null : "fx:id=\"bouquetLbl\" was not injected: check your FXML file 'builderView.fxml'.";

        App.SelfDes = new SDType(null,null);
    }

}
