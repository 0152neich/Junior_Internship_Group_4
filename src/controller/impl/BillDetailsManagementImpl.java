package controller.impl;

import java.sql.SQLException;
import java.util.List;

import controller.BillDetailsManagement;
import dao.BillDetailsDAO;
import model.BillDetails;

public class BillDetailsManagementImpl implements BillDetailsManagement {

    // Tạo thể hiện của BillDetailsDAO
    private final BillDetailsDAO billDetailsDAO = new BillDetailsDAO();
    

    public BillDetailsManagementImpl() {
    	
	}


	@Override
    public boolean add(BillDetails billDetails) throws SQLException {
        // Gọi đến phương thức add từ DAO
        return billDetailsDAO.add(billDetails);
    }


    @Override
    public List<BillDetails> getAll() throws SQLException {
        // Gọi đến phương thức getAll từ DAO
        return billDetailsDAO.getAll();
    }

    @Override
    public BillDetails getByIdBill(String idBill) throws SQLException {
        // Gọi đến phương thức getByIdBill từ DAO
        return billDetailsDAO.getByIdBill(idBill);
    }



}
