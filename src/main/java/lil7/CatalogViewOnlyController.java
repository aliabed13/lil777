package lil7;
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


public class CatalogViewOnlyController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private Button back;

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
    void select(MouseEvent event) {

    }
    @FXML
    void GoToCustomer(ActionEvent event)throws Exception {
        if(App.user_name.compareTo("") == 0)
        {
            AnchorPane pane= FXMLLoader.load(getClass().getResource("Login.fxml"));
            rootPane.getChildren().setAll(pane);

        }
        else
        {
            AnchorPane pane= FXMLLoader.load(getClass().getResource("Customer.fxml"));
            rootPane.getChildren().setAll(pane);
        }
    }

    @FXML
    void initialize() {
        assert rootPane != null : "fx:id=\"rootPane\" was not injected: check your FXML file 'catalogViewOnly.fxml'.";
        assert back != null : "fx:id=\"back\" was not injected: check your FXML file 'catalogViewOnly.fxml'.";
        assert catalogTableView != null : "fx:id=\"catalogTableView\" was not injected: check your FXML file 'catalogViewOnly.fxml'.";
        assert nameCol != null : "fx:id=\"nameCol\" was not injected: check your FXML file 'catalogViewOnly.fxml'.";
        assert descriptionCol != null : "fx:id=\"descriptionCol\" was not injected: check your FXML file 'catalogViewOnly.fxml'.";
        assert priceCol != null : "fx:id=\"priceCol\" was not injected: check your FXML file 'catalogViewOnly.fxml'.";
        assert sale_percentCol != null : "fx:id=\"sale_percentCol\" was not injected: check your FXML file 'catalogViewOnly.fxml'.";

        nameCol.setCellValueFactory(new PropertyValueFactory<item, String>("name"));
        descriptionCol.setCellValueFactory(new PropertyValueFactory<item, String>("description"));
        priceCol.setCellValueFactory(new PropertyValueFactory<item, String>("price"));
        sale_percentCol.setCellValueFactory(new PropertyValueFactory<item, String>("sale_percent"));


        ObservableList<item> Items = getCatItems();
        catalogTableView.setItems(Items);
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
