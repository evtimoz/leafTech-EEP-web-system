package model;
/**
 * Created by evtimoz 4/11/20.
 */
public class Order {

    private String Date;
    private String Firstname;
    private String Lastname;
    private String Address;
    private String Phone;
    private Float Total;
    private Boolean Shipped;

    public Order(String date, String firstname, String lastname, String address, String phone, Float total, Boolean shipped) {
        Date = date;
        Firstname = firstname;
        Lastname = lastname;
        Address = address;
        Phone = phone;
        Total = total;
        Shipped = shipped;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String firstname) {
        Firstname = firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public Float getTotal() {
        return Total;
    }

    public void setTotal(Float total) {
        Total = total;
    }

    public Boolean getShipped() {
        return Shipped;
    }

    public void setShipped(Boolean shipped) {
        Shipped = shipped;
    }

}
