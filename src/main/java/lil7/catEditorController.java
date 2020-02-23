package lil7;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class catEditorController	{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private Button refresh;

    @FXML
    private Label dialog;

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
    private TextField nameToEditTxt;

    @FXML
    private TextField newPriceTxt;

    @FXML
    private Button changePriceBtn;

    @FXML
    private TextField newNameTxt;

    @FXML
    private Button changeNameBtn;

    @FXML
    private TextField newDescriptionTxt;

    @FXML
    private Button changeDescBtn;

    @FXML
    private TextField newSaleTxt;

    @FXML
    private Button applySaleBtn;

    @FXML
    private Button removeItemBtn;

    @FXML
    private TextField newItemNameTxt;

    @FXML
    private TextField newItemPriceTxt;

    @FXML
    private TextField newItemDescriptionTxt;

    @FXML
    private TextField newItemSaleTxt;

    @FXML
    private Button AddItemBtn;

    @FXML
    private Button applySaleToAllBtn;

    private item NEWItem;

    private LinkedList<item> catItems;

    @FXML
    void initialize() {
        assert rootPane != null : "fx:id=\"rootPane\" was not injected: check your FXML file 'catalogEditorNWorker.fxml'.";
        assert refresh != null : "fx:id=\"refresh\" was not injected: check your FXML file 'catalogEditorNWorker.fxml'.";
        assert dialog != null : "fx:id=\"dialog\" was not injected: check your FXML file 'catalogEditorNWorker.fxml'.";
        assert catalogTableView != null : "fx:id=\"catalogTableView\" was not injected: check your FXML file 'catalogEditorNWorker.fxml'.";
        assert nameCol != null : "fx:id=\"nameCol\" was not injected: check your FXML file 'catalogEditorNWorker.fxml'.";
        assert descriptionCol != null : "fx:id=\"descriptionCol\" was not injected: check your FXML file 'catalogEditorNWorker.fxml'.";
        assert priceCol != null : "fx:id=\"priceCol\" was not injected: check your FXML file 'catalogEditorNWorker.fxml'.";
        assert sale_percentCol != null : "fx:id=\"sale_percentCol\" was not injected: check your FXML file 'catalogEditorNWorker.fxml'.";
        assert nameToEditTxt != null : "fx:id=\"nameToEditTxt\" was not injected: check your FXML file 'catalogEditorNWorker.fxml'.";
        assert newPriceTxt != null : "fx:id=\"newPriceTxt\" was not injected: check your FXML file 'catalogEditorNWorker.fxml'.";
        assert changePriceBtn != null : "fx:id=\"changePriceBtn\" was not injected: check your FXML file 'catalogEditorNWorker.fxml'.";
        assert newNameTxt != null : "fx:id=\"newNameTxt\" was not injected: check your FXML file 'catalogEditorNWorker.fxml'.";
        assert changeNameBtn != null : "fx:id=\"changeNameBtn\" was not injected: check your FXML file 'catalogEditorNWorker.fxml'.";
        assert newDescriptionTxt != null : "fx:id=\"newDescriptionTxt\" was not injected: check your FXML file 'catalogEditorNWorker.fxml'.";
        assert changeDescBtn != null : "fx:id=\"changeDescBtn\" was not injected: check your FXML file 'catalogEditorNWorker.fxml'.";
        assert newSaleTxt != null : "fx:id=\"newSaleTxt\" was not injected: check your FXML file 'catalogEditorNWorker.fxml'.";
        assert applySaleBtn != null : "fx:id=\"applySaleBtn\" was not injected: check your FXML file 'catalogEditorNWorker.fxml'.";
        assert removeItemBtn != null : "fx:id=\"removeItemBtn\" was not injected: check your FXML file 'catalogEditorNWorker.fxml'.";
        assert newItemNameTxt != null : "fx:id=\"newItemNameTxt\" was not injected: check your FXML file 'catalogEditorNWorker.fxml'.";
        assert newItemPriceTxt != null : "fx:id=\"newItemPriceTxt\" was not injected: check your FXML file 'catalogEditorNWorker.fxml'.";
        assert newItemDescriptionTxt != null : "fx:id=\"newItemDescriptionTxt\" was not injected: check your FXML file 'catalogEditorNWorker.fxml'.";
        assert newItemSaleTxt != null : "fx:id=\"newItemSaleTxt\" was not injected: check your FXML file 'catalogEditorNWorker.fxml'.";
        assert AddItemBtn != null : "fx:id=\"AddItemBtn\" was not injected: check your FXML file 'catalogEditorNWorker.fxml'.";
        assert applySaleToAllBtn != null : "fx:id=\"applySaleToAllBtn\" was not injected: check your FXML file 'catalogEditorNWorker.fxml'.";

        nameCol.setCellValueFactory(new PropertyValueFactory<item, String>("name"));
        descriptionCol.setCellValueFactory(new PropertyValueFactory<item, String>("description"));
        priceCol.setCellValueFactory(new PropertyValueFactory<item, String>("price"));
        sale_percentCol.setCellValueFactory(new PropertyValueFactory<item, String>("sale_percent"));

        NEWItem = new item(null, null, 0, 0);

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
            item Item = new item(iName, iDescription, Integer.valueOf(iPrice), Integer.valueOf(iSale_percent));
            catItems.add(Item);
            Items.add(Item);
        }
        return Items;
    }

    public ObservableList<item> getCatItems() {
        // TODO
        String msg = "";
        MyChat.sendMSG(msg);
        String  items = new String(MyChat.getMSG());
        return getItemsFromString(items);
    }

    public item getItemByName(String name) {
        for(item i : catItems) {
            if(name.equals(i.getName())) {
                return new item(i);
            }
        }
        return new item(null, null, 0, 0);
    }

    @FXML
    public void applyToAllAction(ActionEvent event) {
        String sale = newSaleTxt.getText();
        if(sale.equals("")) {
            dialog.setText("Type in the sale percentage to apply");
        }
        else {
            String toEdit = new String(nameToEditTxt.getText());
            if(toEdit.equals("")) {
                dialog.setText("Type item name to edit");
            }
        }
    }

    @FXML
    public void EditAction(ActionEvent event) {
        String toEdit = new String(nameToEditTxt.getText());
        if(toEdit.equals("")) {
            dialog.setText("Type item name to edit");
        }
        else {
            String newName = newNameTxt.getText(), newPrice = newPriceTxt.getText(), newDescription = newDescriptionTxt.getText(), newSale = newSaleTxt.getText();
            if(newName.equals("") || newPrice.equals("") || newDescription.equals("") || newSale.contentEquals("")) {
                dialog.setText("Choose atleast one feature to change");
            }
            else {
                item itToEdit = getItemByName(toEdit);
                if(itToEdit.getName() == null) {
                    dialog.setText("Item was not found, try another name");
                }
                else {
                    if(toEdit.equals(newName)) {
                        dialog.setText("New item name must be different");
                    }
                    else {
                        if(newPrice.equals(Float.toString(itToEdit.getPrice())) && newSale.equals(Integer.toString(itToEdit.getSale_percent())) && newName.equals(toEdit) && newDescription.equals(itToEdit.getDescription())){
                            dialog.setText("The parameters entered are not different from the current ones");
                        }
                        else {
                            if(newPrice.equals("")) {
                                newPrice = new String(Float.toString(itToEdit.getPrice()));
                            }
                            if(newName.contentEquals("")) {
                                newName = new String(itToEdit.getName());
                            }
                            if(newDescription.contentEquals("")) {
                                newDescription = new String(itToEdit.getDescription());
                            }
                            if(newSale.equals("")) {
                                newSale = new String(Integer.toString(itToEdit.getSale_percent()));
                            }
                            MyChat.sendMSG("updateitem#"+App.shopID+"#"+newName+"#"+newDescription+"#"+newPrice+"#"+newSale);
                            String ans = MyChat.getMSG();
                            if(ans.equals("updated")) {
                                dialog.setText("The item was modified successfully");
                            }
                        }
                    }
                }
            }
        }
    }

    @FXML
    public void refreshAction(ActionEvent event) {
        while(catItems.isEmpty()) {
            catItems.removeFirst();
        }
        catalogTableView.setItems(getCatItems());
    }
}
