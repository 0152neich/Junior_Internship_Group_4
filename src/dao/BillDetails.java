package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BillDetails {
	private final String URL = "jdbc:mysql://localhost:3306/phone_shop?autoReconnect=true&useSSL=false";
	private final String USER = "root";
	private final String PASSWORD = "Wh0@m1?!";

	// Kết nối đến cơ sở dữ liệu MySQL
	public  Connection connect() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
	
	// Phương thức lấy sản phẩm bán chạy nhất trong khoảng thời gian (ngày, tuần, tháng)
	public List<Object[]> getTopProductsSoldInPeriod(String periodType) {
	    List<Object[]> topProducts = new ArrayList<>();
	    
	    String query = "SELECT sp.id, sp.name, SUM(ct.count) AS total_count " +
	                   "FROM HOA_DON h " +
	                   "JOIN CHI_TIET_HOA_DON ct ON h.id = ct.HOA_DONid " +
	                   "JOIN SAN_PHAM sp ON ct.SAN_PHAMid = sp.id " +
	                   "WHERE ";

	    switch (periodType.toLowerCase()) {
	        case "day":
	            query += "h.date = CURDATE() ";  // Lọc hóa đơn trong ngày hiện tại
	            break;
	        case "week":
	            query += "h.date >= CURDATE() - INTERVAL 7 DAY ";  // Lọc hóa đơn trong tuần qua
	            break;
	        case "month":
	            query += "h.date >= CURDATE() - INTERVAL 1 MONTH ";  // Lọc hóa đơn trong tháng qua
	            break;
	        default:
	            throw new IllegalArgumentException("Khoảng thời gian không hợp lệ. Chọn 'day', 'week', hoặc 'month'.");
	    }

	    query += "GROUP BY sp.id, sp.name ORDER BY total_count DESC LIMIT 5";  // Lọc 5 sản phẩm bán chạy nhất

	    try (Connection conn = connect();
	         PreparedStatement ps = conn.prepareStatement(query);
	         ResultSet rs = ps.executeQuery()) {

	        // Lặp qua kết quả trả về để lấy thông tin sản phẩm
	        while (rs.next()) {
	            String productId = rs.getString("id");
	            String productName = rs.getString("name");
	            int totalSold = rs.getInt("total_count");

	            topProducts.add(new Object[]{productId, productName, totalSold});
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	        // Thêm thông báo lỗi nếu có lỗi trong việc kết nối hoặc truy vấn
	        throw new RuntimeException("Không thể kết nối đến cơ sở dữ liệu hoặc có lỗi trong quá trình truy vấn.", e);
	    }

	    return topProducts;
	}
}