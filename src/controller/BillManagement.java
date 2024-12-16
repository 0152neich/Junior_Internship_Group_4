package controller;

import java.util.ArrayList;
import java.util.List;

import model.Bill;

public interface BillManagement {
    public boolean add(Bill bill);
    public ArrayList<Bill> getAllBills();
    public List<Bill> search(String type , int value);
}
