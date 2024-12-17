package controller.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import controller.BillDetailsManagement;
import dao.BillDetails;
import dao.ProductionDAO;
import model.Bill;

public class BillDetailsImpl implements BillDetailsManagement {
	
	private BillDetails billDetails;

	public BillDetailsImpl() {
		// TODO Auto-generated constructor stub
		billDetails = new BillDetails();
	}
	
	@Override
	public ArrayList<BillDetails> getAll(String idBill) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public boolean getById(String idBill) {
		// TODO Auto-generated method stub
		return false;
	}
	
    // Phương thức trả về danh sách sản phẩm bán chạy nhất
    public List<Object[]> getTopSoldProducts(String time) {
        return billDetails.getTopProductsSoldInPeriod(time);
    }
	
}
