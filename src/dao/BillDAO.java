package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Bill;

public class BillDAO {

    private final String URL = "jdbc:mysql://localhost:3306/phone_shop?useSSL=false";
    private final String USER = "root";
    private final String PASSWORD = "luongthaison";

    // Kết nối đến cơ sở dữ liệu MySQL
    private Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Thêm hóa đơn mới
    public boolean add(Bill bill) throws SQLException {
        String query = "INSERT INTO HOA_DON (id, amount, date, Customer, quantity, USERid) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, bill.getId()); // ID hóa đơn
            preparedStatement.setBigDecimal(2, bill.getAmount()); // Số tiền
            preparedStatement.setDate(3, new java.sql.Date(bill.getDate().getTime())); // Ngày lập hóa đơn
            preparedStatement.setString(4, bill.getCustomer()); // Tên khách hàng
            preparedStatement.setInt(5, bill.getQuantity()); // Số lượng sản phẩm
            preparedStatement.setString(6, bill.getUserid()); // ID người dùng
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        }
    }

    // Lấy tất cả hóa đơn
    public List<Bill> getAll() throws SQLException {
        List<Bill> bills = new ArrayList<>();
        String query = "SELECT * FROM HOA_DON";
        try (Connection connection = connect();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                Bill bill = new Bill(
                    resultSet.getString("id"),                      // ID hóa đơn
                    resultSet.getDate("date"),                      // Ngày lập hóa đơn
                    resultSet.getBigDecimal("amount"),              // Số tiền
                    resultSet.getString("Customer"),                // Tên khách hàng
                    resultSet.getInt("quantity"),                   // Số lượng sản phẩm
                    resultSet.getString("USERid")                   // ID người dùng
                );
                bills.add(bill);
            }
        }
        return bills;
    }

 // Lọc hóa đơn theo kiểu thời gian (ngày, tháng, năm)
    public List<Bill> findByDate(String filterType, int value) throws SQLException {
        List<Bill> bills = new ArrayList<>();
        String query = "";

        // Xác định kiểu lọc (ngày, tháng, năm)
        switch (filterType.toLowerCase()) {
            case "day":
                query = "SELECT * FROM HOA_DON WHERE DAY(date) = ?";
                break;
            case "month":
                query = "SELECT * FROM HOA_DON WHERE MONTH(date) = ?";
                break;
            case "year":
                query = "SELECT * FROM HOA_DON WHERE YEAR(date) = ?";
                break;
            default:
                throw new IllegalArgumentException("Filter type must be 'day', 'month', or 'year'.");
        }

        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, value);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Bill bill = new Bill(
                    resultSet.getString("id"),
                    resultSet.getDate("date"),
                    resultSet.getBigDecimal("amount"),
                    resultSet.getString("Customer"),
                    resultSet.getInt("quantity"),
                    resultSet.getString("USERid")
                );
                bills.add(bill);
            }
        }
        return bills;
    }


}
