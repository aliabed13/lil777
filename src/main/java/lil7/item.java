package lil7;
import javafx.beans.property.SimpleStringProperty;

public class item{
    private SimpleStringProperty name;
    private SimpleStringProperty description;
    private float price;
    private int sale_percent;

    public item(String name, String description, float price, int sale_percent) {
        this.name = new SimpleStringProperty(name);
        this.description = new SimpleStringProperty(description);
        this.price = price;
        this.sale_percent = sale_percent;
    }

    public item(item Item) {
        this.name = new SimpleStringProperty(Item.getName());
        this.description = new SimpleStringProperty(Item.getDescription());
        this.price = Item.getPrice();
        this.sale_percent = Item.getSale_percent();
    }

    public boolean equals(item i) {
        if(name.equals(i.getName()) && description.equals(i.getDescription()) && price==i.getPrice() && sale_percent==i.getSale_percent()){
            return true;
        }
        return false;
    }
    public void setName(String name) {
        this.name = new SimpleStringProperty(name);
    }

    public void setDescription(String description) {
        this.description = new SimpleStringProperty(description);
    }

    public String getName() {
        return name.get();
    }

    public String getDescription() {
        return description.get();
    }
    public void setPrice(float price) {
        this.price = price;
    }

    public float getPrice() {
        return price;
    }
    public void setSale_percent(int sale_percent) {
        this.sale_percent = sale_percent;
    }

    public int getSale_percent() {
        return sale_percent;
    }
}