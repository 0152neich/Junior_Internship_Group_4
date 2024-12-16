package controller.impl;

import controller.ProductManagement;
import dao.ProductionDAO; // Import ProductionDAO
import model.Production;
import java.util.ArrayList;

public class ProductManagementImpl implements ProductManagement {

    private ProductionDAO productionDAO;

    public ProductManagementImpl() {
        // Khởi tạo đối tượng ProductionDAO
        productionDAO = new ProductionDAO();
    }

    @Override
    public boolean addProduct(Production production) {
        // Gọi phương thức addSanPham từ DAO để thêm sản phẩm
        return productionDAO.addSanPham(production);
    }

    @Override
    public boolean updateProduct(Production production) {
        // Gọi phương thức updateSanPham từ DAO để cập nhật sản phẩm
        return productionDAO.updateSanPham(production);
    }

    @Override
    public boolean deleteProduct(String productId) {
        // Gọi phương thức deleteSanPham từ DAO để xóa sản phẩm
        return productionDAO.deleteSanPham(productId);
    }

    @Override
    public ArrayList<Production> searchProductByName(String name) {
        // Thực hiện tìm kiếm sản phẩm theo tên (cần có phương thức tìm kiếm trong DAO)
        return null;
    }

    @Override
    public boolean showProduct() {
        // Hiển thị sản phẩm hoặc thông tin sản phẩm (ví dụ: in ra màn hình hoặc giao diện)
        return false;
    }

    @Override
    public ArrayList<Production> getAllProducts() {
        // Gọi phương thức getAllSanPham từ DAO để lấy danh sách tất cả sản phẩm
        return (ArrayList<Production>) productionDAO.getAllSanPham();
    }
}
