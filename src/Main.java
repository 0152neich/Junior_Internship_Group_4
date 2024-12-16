import controller.ProductManagement;
import controller.UserManagement;
import controller.impl.ProductManagementImpl;
import controller.impl.UserManagementImpl;
import dao.UserDAO;
import model.User;
import model.Production;
import model.Role;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        // Khởi tạo UserDAO (giả sử bạn đã hoàn thiện UserDAO với các phương thức liên quan đến CSDL)

        // Khởi tạo UserManagementImpl và truyền UserDAO vào
        UserManagement userManagement = new UserManagementImpl();

        // Gọi phương thức showUser để hiển thị danh sách người dùng

        // Gọi phương thức addUser để thêm người dùng mới
        boolean result = userManagement.addUser(newUser);
        // Kiểm tra kết quả
        if (result) {
            System.out.println("them nguoi dùng thành công.");
        } else {
            System.out.println("Không thể them");
        }
        
//        ProductManagement productManagement = new ProductManagementImpl();
//        Production production = new Production("3", "Iphone", 200000.0, 3, "Apple");
//        
//        boolean result = productManagement.addProduct(production);
//        if (result) {
//            System.out.println("them nguoi dùng thành công.");
//        } else {
//            System.out.println("Không thể them");
//        }
        
    }
}
