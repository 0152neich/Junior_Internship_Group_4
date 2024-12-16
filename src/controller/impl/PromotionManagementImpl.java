package controller.impl;

import controller.PromotionManagement;
import model.Promotion;

public class PromotionManagementImpl implements PromotionManagement {
	
	PromotionDAO promotionDAO;
	
    public UserManagementImpl() {
        promotionDAO = new PromotionDAO(); // Khởi tạo đối tượng PromotionDAO
    }

    public List<User> getAllUser() {
        List<User> result = null;
        try {
            result = userDAO.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
	
    @Override
    public boolean addPromotion(Promotion promotion) {
        return false;
    }

    @Override
    public boolean deletePromotion(String id) {
        return false;
    }

    @Override
    public boolean updatePromotion(String id) {
        return false;
    }

    @Override
    public Promotion showPromotion() {
        return null;
    }
}
