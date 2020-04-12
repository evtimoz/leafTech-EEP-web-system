package model;

import java.util.List;

/**
 * Created by evtimoz 4/11/20.
 */
public class Order {

    private String Id;
    private String Date;
    private String Firstname;


    private String Lastname;
    private String Address;
    private String Phone;
    private Float Total;
    private Boolean Shipped;

    public Order() {
    }

    public Order(String dateTimeStamp, String firstName, String lastName, String customerAddress, String phoneNumber, float fCost, boolean shipped) {
        Date = dateTimeStamp;
        Firstname = firstName;
        Lastname = lastName;
        Address = customerAddress;
        Phone = phoneNumber;
        Total = fCost;
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

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

}
