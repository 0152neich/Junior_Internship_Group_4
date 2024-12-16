package controller;

import java.util.ArrayList;

import dao.BillDetails;
import model.Bill;

public interface BillDetailsManagement {
	ArrayList<BillDetails> getAll(String idBill);
	public boolean getById(String idBill);
	
}
