package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BillDAO {

    private final String URL = "jdbc:mysql://localhost:3306/phone_shop?useSSL=false";
    private final String USER = "root";
    private final String PASSWORD = "neihc5201";

    // Kết nối đến cơ sở dữ liệu
    private Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Thống kê doanh thu theo tháng cho năm được chọn
    public List<RevenueData> getRevenueByMonth(int year) {
        List<RevenueData> revenueData = new ArrayList<>();
        String query = "SELECT MONTH(date) AS month, SUM(amount) AS total_revenue "
                     + "FROM HOA_DON WHERE YEAR(date) = ? GROUP BY MONTH(date) ORDER BY month";
        try (Connection conn = connect();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, year);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int month = rs.getInt("month");
                double totalRevenue = rs.getDouble("total_revenue");
                revenueData.add(new RevenueData(month, totalRevenue));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return revenueData;
    }

    // Thống kê doanh thu của 10 năm gần nhất
    public List<RevenueData> getRevenueByYear() {
        List<RevenueData> revenueData = new ArrayList<>();
        String query = "SELECT YEAR(date) AS year, SUM(amount) AS total_revenue "
                     + "FROM HOA_DON WHERE YEAR(date) >= YEAR(CURDATE()) - 9 "
                     + "GROUP BY YEAR(date) ORDER BY year";

        try (Connection conn = connect();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int year = rs.getInt("year");
                double totalRevenue = rs.getDouble("total_revenue");
                revenueData.add(new RevenueData(year, totalRevenue));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return revenueData;
    }
}
