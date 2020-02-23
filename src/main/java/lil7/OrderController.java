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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class OrderController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private Button CatalogBtn;

    @FXML
    private Button DesignBtn;

    @FXML
    private Label PriceLabel;

    @FXML
    private TextField DeliveryAddress;

    @FXML
    private TextField DeliveryTime;

    @FXML
    private SplitMenuButton PaymentMethodDrop;

    @FXML
    private MenuItem CreditCard;

    @FXML
    private MenuItem Balance;

    @FXML
    private TextArea CardTF;

    @FXML
    private Label CardLabel;

    @FXML
    private Button CancelOrderBtn;

    @FXML
    private Button SubmitOrderBtn;

    @FXML
    private TextField Blessing;

    @FXML
    private TextField day;

    @FXML
    private TextField month;

    @FXML
    private TextField year;

    @FXML
    private Label dialog;

    @FXML
    private Label priceTillNow;

    @FXML
    void CancelOrder(ActionEvent event) throws IOException {
        AnchorPane pane= FXMLLoader.load(getClass().getResource(App.go_back_to));
        rootPane.getChildren().setAll(pane);
    }


    @FXML
    void GoToCatalog(ActionEvent event) {
        URL url = getClass().getResource("catalogView.fxml");
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
    void GoToDesign(ActionEvent event) {
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

    @FXML
    void SendBalanceText(ActionEvent event) {
        App.paymentWay = new String("balance");
    }

    @FXML
    void SetCreditCardtxt(ActionEvent event) {
        App.paymentWay = new String("card");
    }

    boolean numberOrNot(String input, int low, int high){
        int i=0;
        try
        {
            i = Integer.parseInt(input);
        }
        catch(NumberFormatException ex)
        {
            return	false;
        }
        if(i > high || i < low) {
            return false;
        }
        return	true;
    }

    @FXML
    void SubmitOrder(ActionEvent event) {
        String d = day.getText(), m = month.getText(), y = year.getText();
        String bless = Blessing.getText();
        String addr = DeliveryAddress.getText();
        String time = DeliveryTime.getText();
        if(!numberOrNot(d,1,31)) {
            dialog.setText("the day has to be a number between 1 and 31");
        }
        else if(!numberOrNot(m,1,12)) {
            dialog.setText("the month has to be a number between 1 and 12");
        }
        else if(!numberOrNot(y,2020,2022)) {
            dialog.setText("the day has to be a number between 2020 and 2022");
        }
        else if(App.paymentWay == null) {
            dialog.setText("Please choose the payment method");
        }
        else {
            String msg = "addorder#"+App.user_name+"#"+App.shopID+"#"+getPrices()+"#"+addr+"#"+d+"-"+m+"-"+y+"#"+time;
            if(!bless.equals("")) {
                msg += bless;
            }
            MyChat.sendMSG(msg);
            MyChat.getMSG();
            App.b = false;
        }
        URL url = getClass().getResource("Customer.fxml");
       // AnchorPane pane;
        try {
            AnchorPane pane = FXMLLoader.load(url);
            rootPane.getChildren().setAll(pane);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public String getPrices() {
        int prices = 0;
        for(int i=0; i<App.catItsSz; i++) {
            prices += App.catItems[i].getPrice();
        }
        for(int sdi=0; sdi<App.SDItsSz; sdi++) {
            prices += App.SDItems[sdi].getPrice();
        }
        return Integer.toString(prices);
    }

    @FXML
    void ViewLabelAndField(ActionEvent event) {
        PaymentMethodDrop.setText(App.paymentWay);
    }

    public void addItem() {
        item i = new item(App.selectedItem) ;
        App.catItems[App.catItsSz] = i;
        App.catItsSz++;
        App.selectedItem = new item(null,null,0,0);
    }

    public void addSDItem() {
        SDType sdi = new SDType(App.SelfDes);
        App.SDItems[App.SDItsSz] = sdi;
        App.SDItsSz++;
        App.SelfDes = new SDType(null,null,null);
    }

    @FXML
    void initialize() {
        assert rootPane != null : "fx:id=\"rootPane\" was not injected: check your FXML file 'OrderView.fxml'.";
        assert CatalogBtn != null : "fx:id=\"CatalogBtn\" was not injected: check your FXML file 'OrderView.fxml'.";
        assert DesignBtn != null : "fx:id=\"DesignBtn\" was not injected: check your FXML file 'OrderView.fxml'.";
        assert PriceLabel != null : "fx:id=\"PriceLabel\" was not injected: check your FXML file 'OrderView.fxml'.";
        assert DeliveryAddress != null : "fx:id=\"DeliveryAddress\" was not injected: check your FXML file 'OrderView.fxml'.";
        assert DeliveryTime != null : "fx:id=\"DeliveryTime\" was not injected: check your FXML file 'OrderView.fxml'.";
        assert PaymentMethodDrop != null : "fx:id=\"PaymentMethodDrop\" was not injected: check your FXML file 'OrderView.fxml'.";
        assert CreditCard != null : "fx:id=\"CreditCard\" was not injected: check your FXML file 'OrderView.fxml'.";
        assert Balance != null : "fx:id=\"Balance\" was not injected: check your FXML file 'OrderView.fxml'.";
        assert CardTF != null : "fx:id=\"CardTF\" was not injected: check your FXML file 'OrderView.fxml'.";
        assert CardLabel != null : "fx:id=\"CardLabel\" was not injected: check your FXML file 'OrderView.fxml'.";
        assert CancelOrderBtn != null : "fx:id=\"CancelOrderBtn\" was not injected: check your FXML file 'OrderView.fxml'.";
        assert SubmitOrderBtn != null : "fx:id=\"SubmitOrderBtn\" was not injected: check your FXML file 'OrderView.fxml'.";
        assert Blessing != null : "fx:id=\"Blessing\" was not injected: check your FXML file 'OrderView.fxml'.";
        assert day != null : "fx:id=\"day\" was not injected: check your FXML file 'OrderView.fxml'.";
        assert month != null : "fx:id=\"month\" was not injected: check your FXML file 'OrderView.fxml'.";
        assert year != null : "fx:id=\"year\" was not injected: check your FXML file 'OrderView.fxml'.";
        assert dialog != null : "fx:id=\"dialog\" was not injected: check your FXML file 'OrderView.fxml'.";
        assert priceTillNow != null : "fx:id=\"priceTillNow\" was not injected: check your FXML file 'OrderView.fxml'.";

        App.b = true;
        if(!(App.selectedItem.getName() == null)) {
            addItem();
        }
        if(!(App.SelfDes.getType() == null)) {
            addSDItem();
        }
        // priceTillNow.setText(getPrices());
    }
}
