package controller.impl;

import controller.PromotionManagement;
import dao.PromotionDAO;
import model.Promotion;
import java.sql.SQLException;
import java.util.*;

public class PromotionManagementImpl implements PromotionManagement {
	
	PromotionDAO promotionDAO;
	
    public PromotionManagementImpl() {
        promotionDAO = new PromotionDAO(); // Khởi tạo đối tượng PromotionDAO
    }

    public List<Promotion> getAllPromotions() {
        List<Promotion> result = null;
        result = promotionDAO.getAllPromotions();
        return result;
    }
	
    @Override
    public boolean addPromotion(Promotion promotion) {
        return promotionDAO.addPromotion(promotion);
    }

    @Override
    public boolean deletePromotion(String id) {
        return promotionDAO.deletePromotion(id);
    }

    @Override
    public boolean updatePromotion(Promotion promotion) {
        return promotionDAO.updatePromotion(promotion);
    }

    @Override
    public Promotion showPromotion(String id) {
        return promotionDAO.findPromotionById(id);
    }
}
