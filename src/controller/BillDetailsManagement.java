package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BillDetailsDAO;
import model.*;

public interface BillDetailsManagement {
	  // Thêm một chi tiết hóa đơn
    boolean add(BillDetails billDetails) throws SQLException;


    // Lấy tất cả chi tiết hóa đơn
    List<BillDetails> getAll() throws SQLException;

    // Lấy một chi tiết hóa đơn theo idBill
    BillDetails getByIdBill(String idBill) throws SQLException;


	
}
 