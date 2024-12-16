package controller.impl;

import controller.ProductManagement;
import dao.ProductionDAO;
import model.Production;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductManagementImpl implements ProductManagement {

	private ProductionDAO productionDAO;

	public ProductManagementImpl() {
		productionDAO = new ProductionDAO();
	}

	@Override
	public boolean addProduct(Production production) {
		try {
			return productionDAO.add(production);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateProduct(Production production) {
		try {
			return productionDAO.update(production);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteProduct(String id) {
		try {
			return productionDAO.delete(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean showProduct() {
		try {
			// Gọi phương thức getAll() của productionDAO để lấy danh sách
			List<Production> productions = productionDAO.getAll();

			// Kiểm tra roongx
			if (productions.isEmpty()) {
				System.out.println("Không có người dùng nào.");
				return false; // Trả về false nếu không có người dùng
			}

			// Hiển thị thông tin
			for (Production production : productions) {
				System.out.println(production);
			}

			return true; // Trả về true nếu hiển thị thành công
		} catch (SQLException e) {
			e.printStackTrace(); // In thông báo lỗi nếu có lỗi xảy ra
			return false; // Trả về false nếu gặp lỗi
		}
	}
	
	public List<Production> getAllProduction(){

			List<Production> list = new ArrayList<>();
			if (showProduct()) {
				try {
					list = productionDAO.getAll();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return list;
	}
		
}
