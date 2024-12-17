package dao;

import java.sql.*;
import java.util.*;
import model.*;

public class ProductionDAO {

	private final String URL = "jdbc:mysql://localhost:3306/phone_shop?autoReconnect=true&useSSL=false";
	private final String USER = "root";
	private final String PASSWORD = "Wh0@m1?!";

	PreparedStatement ps;
	Statement st;
	ResultSet rs;

	// Kết nối đến cơ sở dữ liệu MySQL
	public  Connection connect() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}

	// Add
	public boolean add(Production production) throws SQLException {
		String sql = "INSERT INTO SAN_PHAM (id, name, price, quantity, brand) VALUES (?,?,?,?,?);";
		ps = connect().prepareStatement(sql);
		ps.setString(1, production.getId());
		ps.setString(2, production.getName());
		ps.setDouble(3, production.getPrice());
		ps.setInt(4, production.getQuantity());
		ps.setString(5, production.getBrand());

		int rowsAffected = ps.executeUpdate();
		return rowsAffected > 0;
	}

	// show list
	public List<Production> getAll() throws SQLException {
		List<Production> productions = new ArrayList<>();

		String sql = "SELECT * FROM SAN_PHAM";
		ps = connect().prepareStatement(sql);

		// executeQuery => sd để select, truy vấn csdl từ db
		// trả về 1 Resultset => tập kết quả
		rs = ps.executeQuery(sql);

		// để đọc được dữ liệu mà resultset trả về => sd while(res.next())
		// mỗi làn next thì vòng while sẽ duyệt qua 1 dòng trong resultset
		// sd getString để lấy ra từng cột được đánh stt từ 1
		while (rs.next()) {
			Production production = new Production(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getInt(4),
					rs.getString(5));
			productions.add(production);
		}
		return productions;
	}

	// Update
	public boolean update(Production production) throws SQLException {
		String sql = "UPDATE SAN_PHAM SET name=?, price=?, quantity=?, brand=? WHERE id =?";
		ps = connect().prepareStatement(sql);
		ps.setString(1, production.getName());
		ps.setDouble(2, production.getPrice());
		ps.setInt(3, production.getQuantity());
		ps.setString(4, production.getBrand());
		ps.setString(5, production.getId());

		int rowsAffected = ps.executeUpdate();
		return rowsAffected > 0;
	}

	// delete
	public boolean delete(String productionId) throws SQLException {
		String sql = "DELETE FROM SAN_PHAM WHERE id = ?";
		ps = connect().prepareStatement(sql);
		ps.setString(1, productionId);
		int rowsAffected = ps.executeUpdate();
		return rowsAffected > 0;
	}

}
