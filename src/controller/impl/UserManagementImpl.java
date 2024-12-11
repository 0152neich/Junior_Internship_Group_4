package controller.impl;

import controller.UserManagement;
import model.User;
import dao.UserDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserManagementImpl implements UserManagement {

	private UserDAO userDAO;

	public UserManagementImpl() {
		userDAO = new UserDAO(); // Khởi tạo đối tượng UserDAO
	}

	@Override
	public boolean addUser(User user) {
		try {
			// Gọi phương thức add() của UserDAO để thêm người dùng vào cơ sở dữ liệu
			return userDAO.add(user);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateUser(User user) {
		try {
			// Gọi phương thức update() của UserDAO để cập nhật thông tin người dùng

			return userDAO.update(user);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteUser(String id) {
		try {
			// Gọi phương thức delete() của UserDAO để xóa người dùng khỏi cơ sở dữ liệu
			return userDAO.delete(id);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean showUser() {
		try {
			// Gọi phương thức getAll() của UserDAO để lấy danh sách người dùng
			List<User> users = userDAO.getAll();

			// Kiểm tra nếu không có người dùng nào
			if (users.isEmpty()) {
				System.out.println("Không có người dùng nào.");
				return false; // Trả về false nếu không có người dùng
			}

			// Hiển thị thông tin người dùng
			for (User user : users) {
				System.out.println(user);
			}

			return true; // Trả về true nếu hiển thị thành công
		} catch (SQLException e) {
			e.printStackTrace(); // In thông báo lỗi nếu có lỗi xảy ra
			return false; // Trả về false nếu gặp lỗi
		}
	}

}
