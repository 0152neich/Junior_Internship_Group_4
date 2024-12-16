package controller;

import java.util.ArrayList;
import model.Production;

public interface ProductManagement {
    // Phương thức thêm một sản phẩm
    public boolean addProduct(Production production);
    
    // Phương thức cập nhật thông tin sản phẩm
    public boolean updateProduct(Production production);
    
    // Phương thức xóa sản phẩm theo ID
    public boolean deleteProduct(String productId);
    
    // Phương thức tìm kiếm sản phẩm theo tên
    public ArrayList<Production> searchProductByName(String name);
    
    // Phương thức để hiển thị sản phẩm (có thể cần thay đổi nếu yêu cầu hiển thị cụ thể)
    public boolean showProduct();
    
    // Lấy danh sách tất cả sản phẩm
    public ArrayList<Production> getAllProducts();
}
