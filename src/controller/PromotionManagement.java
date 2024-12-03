package controller;

import model.Promotion;

public interface PromotionManagement {
    public boolean addPromotion(Promotion promotion);
    public boolean deletePromotion(String id);
    public boolean updatePromotion(String id);
    public Promotion showPromotion();
}
