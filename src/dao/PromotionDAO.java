package dao;

import java.sql.*;
import java.util.*;
import model.*;


public class PromotionDAO {
	
    private final String URL = "jdbc:mysql://localhost:3306/phone_shop?autoReconnect=true&useSSL=false";
    private final String USER = "root";
    private final String PASSWORD = "Wh0@m1?!";
    
    public List<Promotion> getAllPromotions() {
        List<Promotion> promotions = new ArrayList<>();
        String sql = "SELECT * FROM KHUYEN_MAI";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                promotions.add(new Promotion(
                        resultSet.getString("idofpromotion"),
                        resultSet.getDate("start"),
                        resultSet.getDate("end"),
                        resultSet.getString("dieukien"),
                        resultSet.getString("description")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return promotions;
    }

    public boolean addPromotion(Promotion promotion) {
        String sql = "INSERT INTO KHUYEN_MAI (idofpromotion, start, end, dieukien, description) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, promotion.getIdofpromotion());
            statement.setDate(2, new java.sql.Date(promotion.getStart().getTime()));
            statement.setDate(3, new java.sql.Date(promotion.getEnd().getTime()));
            statement.setString(4, promotion.getCondition());
            statement.setString(5, promotion.getDescription());

            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updatePromotion(Promotion promotion) {
        String sql = "UPDATE KHUYENMAI SET start = ?, end = ?, dieukien = ?, description = ? WHERE idofpromotion = ?";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setDate(1, new java.sql.Date(promotion.getStart().getTime()));
            statement.setDate(2, new java.sql.Date(promotion.getEnd().getTime()));
            statement.setString(3, promotion.getCondition());
            statement.setString(4, promotion.getDescription());
            statement.setString(5, promotion.getIdofpromotion());

            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deletePromotion(String promotionId) {
        String sql = "DELETE FROM KHUYENMAI WHERE idofpromotion = ?";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, promotionId);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Promotion findPromotionById(String promotionId) {
        String sql = "SELECT * FROM KHUYENMAI WHERE idofpromotion = ?";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, promotionId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Promotion(
                            resultSet.getString("idofpromotion"),
                            resultSet.getDate("start"),
                            resultSet.getDate("end"),
                            resultSet.getString("dieukien"),
                            resultSet.getString("description")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
