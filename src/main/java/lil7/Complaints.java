package lil7;

import javafx.beans.property.SimpleStringProperty;

public class Complaints{
    private SimpleStringProperty complaintid;
    private SimpleStringProperty user_name;
    private SimpleStringProperty store_id;
    private SimpleStringProperty orderid;
    private SimpleStringProperty complaint;
    private SimpleStringProperty answered;
    private SimpleStringProperty answer=null;
    private SimpleStringProperty dateandtime;

    public Complaints(String complaintid, String orderid, String text1,String date1) {
        this.complaintid=new SimpleStringProperty(complaintid);
        this.orderid=new SimpleStringProperty(orderid);
        this.complaint=new SimpleStringProperty(text1);
        this.dateandtime=new SimpleStringProperty(date1);

    }

    public Complaints(String complaintid, String orderid, String text1,String date1,String answer1) {
        this.complaintid=new SimpleStringProperty(complaintid);
        this.orderid=new SimpleStringProperty(orderid);
        this.complaint=new SimpleStringProperty(text1);
        this.dateandtime=new SimpleStringProperty(date1);
        this.answer=new SimpleStringProperty(answer1);

    }

    public Complaints(String complaintid,String username , String storeid, String orderid , String text1 , String answered1,String answer1 , String date1) {
        this.complaintid=new SimpleStringProperty(complaintid);
        this.user_name=new SimpleStringProperty(username);
        this.store_id=new SimpleStringProperty(storeid);
        this.orderid=new SimpleStringProperty(orderid);
        this.complaint=new SimpleStringProperty(text1);
        this.answered=new SimpleStringProperty(answered1);
        this.answer=new SimpleStringProperty(answer1);
        this.dateandtime=new SimpleStringProperty(date1);
    }

    public Complaints(Complaints Comp1) {
        this.complaintid=new SimpleStringProperty(Comp1.getComplaintid());
        this.orderid=new SimpleStringProperty(Comp1.getOrderid());
        this.complaint=new SimpleStringProperty(Comp1.getComplaint());
        this.dateandtime=new SimpleStringProperty(Comp1.getDateandtime());
        if(Comp1.getAnswer()!=null)
        this.answer=new SimpleStringProperty(Comp1.getAnswer());
    }


    public void setComplaintid(String complaintId) {
        this.complaintid = new SimpleStringProperty(complaintId);
    }
    public void setUser_name(String username) {
        this.user_name = new SimpleStringProperty(username);
    }
    public void setStore_id(String storeId) {
        this.store_id = new SimpleStringProperty(storeId);
    }
    public void setOrderid(String storeId) {
        this.orderid = new SimpleStringProperty(storeId);
    }
    public void setComplaint(String text1) {
        this.complaint = new SimpleStringProperty(text1);
    }
    public void setAnswered(String answered1) {
        this.answered = new SimpleStringProperty(answered1);
    }
    public void setAnswer(String answer1) {
        this.answer = new SimpleStringProperty(answer1);
    }
    public void setDateandtime(String date1) {
        this.dateandtime = new SimpleStringProperty(date1);
    }


    public String getComplaintid() {
        return complaintid.get();
    }
    public String getOrderid() {
        return orderid.get();
    }
    public String getUser_name() {
        return user_name.get();
    }
    public String getStore_id() {
        return store_id.get();
    }
    public String getComplaint() {
        return complaint.get();
    }
    public String getAnswered() {
        return answered.get();
    }
    public String getAnswer() {
        return answer.get();
    }
    public String getDateandtime() {
        return dateandtime.get();
    }

}