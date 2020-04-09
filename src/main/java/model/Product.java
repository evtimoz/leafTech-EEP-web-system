package model;

/**
 * Created by arman 4/9/20.
 */
public class Product {
    private String Id;
    private String Type;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    private String Description;
    private double Price;
    private int Quantity;

    public Product(String id, String type, String description, double price, int quantity) {
        Id = id;
        Type = type;
        Description = description;
        Price = price;
        Quantity = quantity;
    }

    public Product(){}
}
