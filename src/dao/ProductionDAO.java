package dao ;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Production;

public class ProductionDAO {
    private Connection connection;

    // Constructor để thiết lập kết nối đến cơ sở dữ liệu
    public ProductionDAO() {
        try {
            // Thay đổi URL, username và password cho phù hợp với cấu hình cơ sở dữ liệu của bạn
        	String url = "jdbc:mysql://localhost:3306/phone_shop?useSSL=false";
            String user = "root";
            String password = "luongthaison";
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Lấy tất cả sản phẩm từ bảng SAN_PHAM
    public List<Production> getAllSanPham() {
        List<Production> sanPhams = new ArrayList<>();
        String query = "SELECT * FROM SAN_PHAM";
        
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            
            while (resultSet.next()) {
                Production sanPham = new Production(
                        resultSet.getString("id"),
                        resultSet.getString("name"),
                        resultSet.getDouble("price"), // Đổi BigDecimal thành Double
                        resultSet.getInt("quantity"),
                        resultSet.getString("brand"),
                        resultSet.getString("KHUYEN_MAIid"),
                        resultSet.getString("USERid")
                );
                sanPhams.add(sanPham);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sanPhams;
    }

    // Thêm mới một sản phẩm vào bảng SAN_PHAM
    public boolean addSanPham(Production sanPham) {
        String query = "INSERT INTO SAN_PHAM (id, name, price, quantity, brand, KHUYEN_MAIid, USERid) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, sanPham.getId());
            preparedStatement.setString(2, sanPham.getName());
            preparedStatement.setDouble(3, sanPham.getPrice());
            preparedStatement.setInt(4, sanPham.getQuantity());
            preparedStatement.setString(5, sanPham.getBrand());
            preparedStatement.setString(6, sanPham.getKhuyenMaiId());
            preparedStatement.setString(7, sanPham.getUserId());
            
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Sửa thông tin một sản phẩm
    public boolean updateSanPham(Production sanPham) {
        String query = "UPDATE SAN_PHAM SET name = ?, price = ?, quantity = ?, brand = ?, KHUYEN_MAIid = ?, USERid = ? WHERE id = ?";
        
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, sanPham.getName());
            preparedStatement.setDouble(2, sanPham.getPrice()); // Đổi BigDecimal thành Double
            preparedStatement.setInt(3, sanPham.getQuantity());
            preparedStatement.setString(4, sanPham.getBrand());
            preparedStatement.setString(5, sanPham.getKhuyenMaiId());
            preparedStatement.setString(6, sanPham.getUserId());
            preparedStatement.setString(7, sanPham.getId());
            
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Xóa một sản phẩm theo ID
    public boolean deleteSanPham(String sanPhamId) {
        String query = "DELETE FROM SAN_PHAM WHERE id = ?";
        
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, sanPhamId);
            
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Đóng kết nối sau khi hoàn thành công việc
    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
