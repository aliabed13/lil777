package lil7;
import java.io.IOException;
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
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class catController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button back;

    @FXML
    private Button pick;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private TableView<item> catalogTableView;

    @FXML
    private TableColumn<item, String> nameCol;

    @FXML
    private TableColumn<item, String> descriptionCol;

    @FXML
    private TableColumn<item, String> priceCol;

    @FXML
    private TableColumn<item, String> sale_percentCol;

    @FXML
    void rAct(ActionEvent event) {

    }

    @FXML
    private Label instr;


    private item selected;

    @FXML
    void initialize() {
        assert rootPane != null : "fx:id=\"rootPane\" was not injected: check your FXML file 'catalogView.fxml'.";
        assert back != null : "fx:id=\"back\" was not injected: check your FXML file 'catalogView.fxml'.";
        assert pick != null : "fx:id=\"pick\" was not injected: check your FXML file 'catalogView.fxml'.";
        assert catalogTableView != null : "fx:id=\"catalogTableView\" was not injected: check your FXML file 'catalogView.fxml'.";
        assert nameCol != null : "fx:id=\"nameCol\" was not injected: check your FXML file 'catalogView.fxml'.";
        assert descriptionCol != null : "fx:id=\"descriptionCol\" was not injected: check your FXML file 'catalogView.fxml'.";
        assert priceCol != null : "fx:id=\"priceCol\" was not injected: check your FXML file 'catalogView.fxml'.";
        assert sale_percentCol != null : "fx:id=\"sale_percentCol\" was not injected: check your FXML file 'catalogView.fxml'.";
        assert instr != null : "fx:id=\"instr\" was not injected: check your FXML file 'catalogView.fxml'.";

        nameCol.setCellValueFactory(new PropertyValueFactory<item, String>("name"));
        descriptionCol.setCellValueFactory(new PropertyValueFactory<item, String>("description"));
        priceCol.setCellValueFactory(new PropertyValueFactory<item, String>("price"));
        sale_percentCol.setCellValueFactory(new PropertyValueFactory<item, String>("sale_percent"));
        selected = new item(null,null,0,0);


        ObservableList<item> Items = getCatItems();
        catalogTableView.setItems(Items);

        //ObservableList<item> Items = getItemsFromString("shadi#malika#2#45/la#ilaha illa allah#2#0");
       // catalogTableView.setItems(Items);
    }

    public void select(MouseEvent event) {
        selected = new item(catalogTableView.getSelectionModel().getSelectedItem());
        instr.setText(selected.getName() + " is selected, click on pick to add it to the order");
    }
    public void back(ActionEvent event) {
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
    public void pickSelected(ActionEvent event) {
        if(selected.getName() == null) {
            instr.setText("You have to select an item first!");
        }
        else {
            App.selectedItem = new item(selected);
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

    public ObservableList<item> getItemsFromString(String items){
        ObservableList<item> Items = FXCollections.observableArrayList();
        String iName, iDescription, iPrice, iSale_percent;
        String[] rows = items.split("/");
        for(String row : rows) {
            String[] cols = row.split("#");
            iName = cols[0];
            iDescription = cols[1];
            iPrice = cols[2];
            iSale_percent = cols[3];
            item Item = new item(iName, iDescription, Float.valueOf(iPrice), Integer.valueOf(iSale_percent));
            Items.add(Item);
        }
        return Items;
    }
    public ObservableList<item> getCatItems() {
        String msg = "getitems#" + App.shopID;
        MyChat.sendMSG(msg);
        String  items = new String(MyChat.getMSG());
        return getItemsFromString(items);
    }
}
