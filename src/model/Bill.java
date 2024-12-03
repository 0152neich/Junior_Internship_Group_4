package model;

import java.util.Date;

public class Bill {
    private int id;
    private Date date;
    private int amount;
    private Customer customer;
    private String maSanPham ;
    private int quantity;
    private String maKhuyenMai ;


    public Bill() {
    }

    public Bill(int id, Date date, int amount, Customer customer, String maSanPham, int quantity, String maKhuyenMai) {
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.customer = customer;
        this.maSanPham = maSanPham;
        this.quantity = quantity;
        this.maKhuyenMai = maKhuyenMai;
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

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getMaKhuyenMai() {
        return maKhuyenMai;
    }

    public void setMaKhuyenMai(String maKhuyenMai) {
        this.maKhuyenMai = maKhuyenMai;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", date=" + date +
                ", amount=" + amount +
                ", customer=" + customer +
                ", maSanPham='" + maSanPham + '\'' +
                ", quantity=" + quantity +
                ", maKhuyenMai='" + maKhuyenMai + '\'' +
                '}';
    }
}
