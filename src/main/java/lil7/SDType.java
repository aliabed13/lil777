package lil7;
import javafx.beans.property.SimpleStringProperty;

public class SDType {
    SimpleStringProperty type;
    SimpleStringProperty description;
    SimpleStringProperty dominant_color;
    int price;


    public SDType(String type, String description, String dominant_color) {
        this.type = new SimpleStringProperty(type);
        this.description = new SimpleStringProperty(description);
        this.dominant_color = new SimpleStringProperty(dominant_color);
    }
    public SDType(String type, String description) {
        this.type = new SimpleStringProperty(type);
        this.description = new SimpleStringProperty(description);
        this.dominant_color = new SimpleStringProperty(null);
    }
    public SDType(SDType another) {
        this.type = new SimpleStringProperty(another.getType());
        this.description = new SimpleStringProperty(another.getDescription());
        this.dominant_color = new SimpleStringProperty(another.getDominant_color());
    }
    public void setType(String type){
        this.type = new SimpleStringProperty(type);
    }
    public String getType() {
        return type.get();
    }
    public void setDescription(String description) {
        this.description = new SimpleStringProperty(description);
    }
    public String getDescription() {
        return description.get();
    }
    public void setDominantColor(String dominant_color) {
        this.dominant_color = new SimpleStringProperty(dominant_color);
    }
    public String getDominant_color() {
        return dominant_color.get();
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public int getPrice() {
        return price;
    }
}
