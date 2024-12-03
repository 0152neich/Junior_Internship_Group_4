package controller;

import model.Bill;

public interface BillManagement {
    public boolean add(Bill bill);
    public boolean showAllBills();
    public boolean search(String id);
}
