package lil7;

import javafx.beans.property.SimpleStringProperty;
import java.lang.String;
import java.util.ArrayList;
public class Order {
    private SimpleStringProperty orderID;
    ArrayList<item> itemList = new ArrayList<item>();
    ArrayList<SDType> selfDesignList = new ArrayList<SDType>();
    private SimpleStringProperty totalprice;
    private SimpleStringProperty cardTxt;
    private SimpleStringProperty dateAndtime;
    private SimpleStringProperty userID;
    private SimpleStringProperty address;
    private SimpleStringProperty status;

    public Order(String totalp, String cardtxt, String dateAndTime , String userID , String address , String status)
    {
        this.totalprice=new SimpleStringProperty(totalp);
        this.cardTxt=new SimpleStringProperty(cardtxt);
        this.dateAndtime=new SimpleStringProperty(dateAndTime);
        this.userID=new SimpleStringProperty(userID);
        this.address=new SimpleStringProperty(address);
        this.status=new SimpleStringProperty(status);
    }
    public Order(String userid,String orderid)
    {
        this.orderID=new SimpleStringProperty(orderid);
        this.totalprice=new SimpleStringProperty("0");
        this.cardTxt=new SimpleStringProperty("no msg");
        this.dateAndtime=new SimpleStringProperty("no date");
        this.userID=new SimpleStringProperty(userid);
        this.address=new SimpleStringProperty("no address yet");
        this.status=new SimpleStringProperty("not delivered");
    }

    public String getAddress() {
        return address.get();
    }

    public String getCardTxt() {
        return cardTxt.get();
    }

    public String getDateAndtime() {
        return dateAndtime.get();
    }

    public String getOrderID() {
        return orderID.get();
    }

    public String getTotalprice() {
        return totalprice.get();
    }

    public String getUserID() {
        return userID.get();
    }

    public String getStatus() {
        return status.get();
    }

    public void setAddress(String address) {
        this.address=new SimpleStringProperty(address);
    }

    public void setCardTxt(String cardTxt) {
        this.cardTxt=new SimpleStringProperty(cardTxt);
    }

    public void setDateAndtime(String dateAndtime) {
        this.dateAndtime=new SimpleStringProperty(dateAndtime);
    }

   /* public void setItemList(ArrayList<item> itemList) {
        this.itemList = itemList;
    }
*/
    public void setOrderID(String orderID) {
        this.orderID=new SimpleStringProperty(orderID);
    }

 /*   public void setSelfDesignList(ArrayList<SDType> selfDesignList) {
        this.selfDesignList = selfDesignList;
    }
*/
    public void setTotalprice(String totalprice) {
        this.totalprice=new SimpleStringProperty(totalprice);
    }

    public void setUserID(String userID) {
        this.userID=new SimpleStringProperty(userID);
    }

    public void setStatus(String status) {
        this.status=new SimpleStringProperty(status);
    }
}
