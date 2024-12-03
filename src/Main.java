import controller.UserManagement;
import controller.impl.UserManagementImpl;
import dao.UserDAO;
import model.User;
import model.Role;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        // Khởi tạo UserDAO (giả sử bạn đã hoàn thiện UserDAO với các phương thức liên quan đến CSDL)

        // Khởi tạo UserManagementImpl và truyền UserDAO vào
        UserManagement userManagement = new UserManagementImpl();

        // Gọi phương thức showUser để hiển thị danh sách người dùng
        User newUser = new User("123", "Nguyen Van A", "nguyenvana@gmail.com", "nguyenvana", "password123", "0123456789", Role.USER);

        // Gọi phương thức addUser để thêm người dùng mới
        boolean result = userManagement.addUser(newUser);
        // Kiểm tra kết quả
        if (result) {
            System.out.println("them nguoi dùng thành công.");
        } else {
            System.out.println("Không thể them");
        }
    }
}
