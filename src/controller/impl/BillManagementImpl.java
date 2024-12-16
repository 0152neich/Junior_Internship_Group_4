package controller.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controller.BillManagement;
import dao.BillDAO;
import model.Bill;

public class BillManagementImpl implements BillManagement {
	
	public BillDAO billManager = new BillDAO() ; 
    public BillManagementImpl() {
		
	}

	@Override
    public boolean add(Bill bill) {
		try {
			billManager.add(bill);
			return true ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return false;
    }

	@Override
	public ArrayList<Bill> getAllBills() {
	    ArrayList<Bill> bills = new ArrayList<>(); // Khởi tạo danh sách rỗng để tránh trả về null
	    try {
	        bills = (ArrayList<Bill>) billManager.getAll();
	    } catch (SQLException e) {
	        System.err.println("Error fetching bills: " + e.getMessage());
	        e.printStackTrace(); // Ghi log lỗi để dễ dàng kiểm tra
	    }
	    return bills; // Trả về danh sách, dù có thể rỗng nếu xảy ra lỗi
	}


    @Override
    public List<Bill> search(String type , int value) {
    	try {
			List<Bill> bills = billManager.findByDate(type, value);
			return bills;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
        return null;
    }
}
