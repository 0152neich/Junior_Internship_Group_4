package model;

import java.math.BigDecimal;
import java.util.Date;

public class Bill {
    private String id;
    private Date date;
    private BigDecimal amount;
    private String customer; // Tên khách hàng
    private int quantity;
    private String userid; // ID người dùng

    // Constructor mặc định
    public Bill() {
    }
    
    

    // Constructor đầy đủ
    public Bill(String id, Date date, BigDecimal amount, String customer, int quantity, String userid) {
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.customer = customer;
        this.quantity = quantity;
        this.userid = userid;
    }

    // Getters và Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id='" + id + '\'' +
                ", date=" + date +
                ", amount=" + amount +
                ", customer='" + customer + '\'' +
                ", quantity=" + quantity +
                ", userid='" + userid + '\'' +
                '}';
    }
}
