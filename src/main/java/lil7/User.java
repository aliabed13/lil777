package lil7;

import javafx.beans.property.SimpleStringProperty;
import java.lang.String;

public class User {
    private SimpleStringProperty username;
    private SimpleStringProperty password;
    private SimpleStringProperty address;
    private SimpleStringProperty email;
    private SimpleStringProperty phone;
    private SimpleStringProperty creditCard;
    private SimpleStringProperty credit;
    private SimpleStringProperty storeId;
    private SimpleStringProperty auth;
    private SimpleStringProperty blocked;

    public User(String username,String password,String adress,String email,String phone,String creditcard,String credit,String storeid,String auth,String blocked) {
        this.username=new SimpleStringProperty(username);
        this.password=new SimpleStringProperty(password);
        this.address=new SimpleStringProperty(adress);
        this.email=new SimpleStringProperty(email);
        this.phone=new SimpleStringProperty(phone);
        this.creditCard=new SimpleStringProperty(creditcard);
        this.credit=new SimpleStringProperty(credit);
        this.storeId=new SimpleStringProperty(storeid);
        this.auth=new SimpleStringProperty(auth);
        this.blocked=new SimpleStringProperty(blocked);
    }
    public User(String username,String adress,String email,String phone,String auth,String blocked) {
        this.username=new SimpleStringProperty(username);
        this.address=new SimpleStringProperty(adress);
        this.email=new SimpleStringProperty(email);
        this.auth=new SimpleStringProperty(auth);
        this.blocked=new SimpleStringProperty(blocked);
    }
    public User(User user) {
        this.username=new SimpleStringProperty(user.getUsername());
        this.email=new SimpleStringProperty(user.getEmail());
        this.phone=new SimpleStringProperty(user.getPhone());
        this.auth=new SimpleStringProperty(user.getAuth());
        this.blocked=new SimpleStringProperty(user.getBlocked());

    }

    public void set_username(String user) {
        this.username=new SimpleStringProperty(user);
    }
    public void set_password(String password) {
        this.password=new SimpleStringProperty(password);
    }
    public void set_adress(String address) {
        this.address=new SimpleStringProperty(address);
    }
    public void set_email(String email) {
        this.email=new SimpleStringProperty(email);
    }
    public void set_phone(String phone) {
        this.phone=new SimpleStringProperty(phone);
    }
    public void set_creditcard(String creditCard) {
        this.creditCard=new SimpleStringProperty(creditCard);
    }
    public void set_credit(String credit) {
        this.credit=new SimpleStringProperty(credit);
    }
    public void set_storeid(String storeId) {
        this.storeId=new SimpleStringProperty(storeId);
    }
    public void set_auth(String auth) {
        this.auth=new SimpleStringProperty(auth);
    }
    public void set_blocked(String blocked) {
        this.blocked=new SimpleStringProperty(blocked);
    }


    public String getUsername() {
        return this.username.get();
    }
    public String getPassword() {
        return this.password.get();
    }
    public String getAddress() {
        return this.address.get();
    }
    public String getEmail() {
        return this.email.get();
    }
    public String getPhone() {
        return this.phone.get();
    }
    public String getCreditCard() {
        return this.creditCard.get();
    }
    public String get_credit() {
        return this.credit.get();
    }
    public String getStoreid() {
            return this.storeId.get();
    }
    public String getAuth() {
        return this.auth.get();
    }
    public String getBlocked() {
        return this.blocked.get();
    }

}
