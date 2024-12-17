package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.BillDetails;

public class BillDetailsDAO {

    private final String URL = "jdbc:mysql://localhost:3306/phone_shop?useSSL=false";
    private final String USER = "root";
    private final String PASSWORD = "luongthaison";

    // Kết nối đến cơ sở dữ liệu MySQL
    private Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Thêm chi tiết hóa đơn mới
    public boolean add(BillDetails billDetails) throws SQLException {
        String query = "INSERT INTO CHI_TIET_HOA_DON (SAN_PHAMid, HOA_DONid, date, count) VALUES (?, ?, ?, ?)";
        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, billDetails.getIdProduct()); // ID sản phẩm
            preparedStatement.setString(2, billDetails.getIdBill());    // ID hóa đơn
            preparedStatement.setString(3, billDetails.getDate());      // Ngày tạo chi tiết hóa đơn
            preparedStatement.setInt(4, billDetails.getCount());        // Số lượng sản phẩm
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        }
    }

    // Lấy tất cả chi tiết hóa đơn
    public List<BillDetails> getAll() throws SQLException {
        List<BillDetails> billDetailsList = new ArrayList<>();
        String query = "SELECT * FROM CHI_TIET_HOA_DON";
        try (Connection connection = connect();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                BillDetails billDetails = new BillDetails(
                    resultSet.getString("idProduct"),    // ID sản phẩm
                    resultSet.getString("idBill"),       // ID hóa đơn
                    resultSet.getString("date"),         // Ngày tạo chi tiết hóa đơn
                    resultSet.getInt("count")            // Số lượng sản phẩm
                );
                billDetailsList.add(billDetails);
            }
        }
        return billDetailsList;
    }

    // Lọc chi tiết hóa đơn theo kiểu thời gian (ngày, tháng, năm)
    public List<BillDetails> findByDate(String filterType, int value) throws SQLException {
        List<BillDetails> billDetailsList = new ArrayList<>();
        String query = "";

        // Xác định kiểu lọc (ngày, tháng, năm)
        switch (filterType.toLowerCase()) {
            case "day":
                query = "SELECT * FROM CHI_TIET_HOA_DON WHERE DAY(date) = ?";
                break;
            case "month":
                query = "SELECT * FROM CHI_TIET_HOA_DON WHERE MONTH(date) = ?";
                break;
            case "year":
                query = "SELECT * FROM CHI_TIET_HOA_DON WHERE YEAR(date) = ?";
                break;
            default:
                throw new IllegalArgumentException("Filter type must be 'day', 'month', or 'year'.");
        }

        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, value);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                BillDetails billDetails = new BillDetails(
                    resultSet.getString("idProduct"),
                    resultSet.getString("idBill"),
                    resultSet.getString("date"),
                    resultSet.getInt("count")
                );
                billDetailsList.add(billDetails);
            }
        }
        return billDetailsList;
    }

 // Lấy một chi tiết hóa đơn theo idBill
    public BillDetails getByIdBill(String idBill) throws SQLException {
        String query = "SELECT * FROM CHI_TIET_HOA_DON WHERE idBill = ?";
        BillDetails billDetails = null;

        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, idBill);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                billDetails = new BillDetails(
                    resultSet.getString("SAN_PHAMid"), // ID sản phẩm
                    resultSet.getString("HOA_DONid"),    // ID hóa đơn
                    resultSet.getString("date"),      // Ngày tạo hóa đơn
                    resultSet.getInt("count")         // Số lượng sản phẩm
                );
            }
        }
        return billDetails; // Trả về null nếu không tìm thấy
    }


}
