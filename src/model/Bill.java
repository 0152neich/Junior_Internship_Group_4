package model;

import java.util.Date;

public class Bill {
    private int id;
    private Date date;
    private int amount;
    private Customer customer;
    private int quantity;


    public Bill() {
    	
    }

    public Bill(int id, Date date, int amount, Customer customer, int quantity) {
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.customer = customer;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

   
    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", date=" + date +
                ", amount=" + amount +
                ", customer=" + customer +
                '}';
    }
}
