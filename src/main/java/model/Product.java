package model;

/**
 * Created by arman 4/9/20.
 */
public class Product {
    public String Id;
    public String Type;
    public String Description;
    public double Price;
    public int Quantity;

    public Product(String id, String type, String description, double price, int quantity) {
        Id = id;
        Type = type;
        Description = description;
        Price = price;
        Quantity = quantity;
    }
}
