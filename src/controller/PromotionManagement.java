package controller;

import model.Promotion;

public interface PromotionManagement {
    public boolean addPromotion(Promotion promotion);
    public boolean deletePromotion(String id);
    public boolean updatePromotion(Promotion promotion);
    public Promotion showPromotion(String id);
}
