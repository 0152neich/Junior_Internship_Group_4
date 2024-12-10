package dao;

import java.sql.*;


import java.util.ArrayList;
import java.util.List;
import model.User;
import model.*;  // Import Role enum
import common.HashPassword;

public class UserDAO {

    private final String URL = "jdbc:mysql://localhost:3306/phone_shop?useSSL=false";
    private final String USER = "root";
    private final String PASSWORD = "neihc5201";

    // Kết nối đến cơ sở dữ liệu MySQL
    private Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Thêm người dùng mới
    public boolean add(User user) throws SQLException {
        String query = "INSERT INTO USER (id, fullname, email, username, password, phone, role) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = connect();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        	String hashedPassword = HashPassword.hashPassword(user.getPassword());
            preparedStatement.setLong(1, user.getId());
            preparedStatement.setString(2, user.getFullname());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getUsername());
            preparedStatement.setString(5, hashedPassword);
            preparedStatement.setString(6, user.getPhone());
            preparedStatement.setString(7, user.getRole().name());  // Lưu role dưới dạng String
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        }
    }

    // Lấy tất cả người dùng
    public List<User> getAll() throws SQLException {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM USER";
        try (Connection connection = connect();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                User user = new User(
//                        resultSet.getLong("id"),
                        resultSet.getString("fullname"),
                        resultSet.getString("email"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getString("phone"),
                        Role.valueOf(resultSet.getString("role"))  // Chuyển đổi từ String thành Role
                );
                users.add(user);
            }
        }
        return users;
    }

    // Cập nhật thông tin người dùng
    public boolean update(User user) throws SQLException {
        String query = "UPDATE USER SET fullname = ?, email = ?, username = ?, password = ?, phone = ?, role = ? WHERE id = ?";
        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, user.getFullname());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getUsername());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getPhone());
            preparedStatement.setString(6, user.getRole().name());  // Lưu role dưới dạng String
            preparedStatement.setLong(7, user.getId());
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        }
    }

    // Xóa người dùng
    public boolean delete(String userId) throws SQLException {
        String query = "DELETE FROM USER WHERE id = ?";
        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, userId);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        }
    }
    
    // Check email đã tồn tại
    public boolean checkEmailExists(String email) {
        String query = "SELECT COUNT(*) FROM USER WHERE email = ?";
        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) { 

        	preparedStatement.setString(1, email);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
 // Check tên đăng nhập đã tồn tại
    public boolean checkUsernameExists(String username) {
        String query = "SELECT COUNT(*) FROM USER WHERE userName = ?";
        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) { 

        	preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
