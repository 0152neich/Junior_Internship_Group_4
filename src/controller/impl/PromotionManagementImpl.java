//package controller.impl;
//
//import dao.PromotionDAO;
//import controller.PromotionManagement;
//import model.Promotion;
//
//public class PromotionManagementImpl implements PromotionManagement {
//
//    private PromotionDAO promotionDAO;
//
//    // Constructor khởi tạo DAO
//    public PromotionManagementImpl() {
//        this.promotionDAO = new PromotionDAO();
//    }
//
//    // Thêm khuyến mãi
//    @Override
//    public boolean addPromotion(Promotion promotion) {
//        return promotionDAO.add(promotion);
//    }
//
//    // Xóa khuyến mãi theo id
//    @Override
//    public boolean deletePromotion(String id) {
//        return promotionDAO.delete(id);
//    }
//
//    // Cập nhật khuyến mãi theo id
//    @Override
//    public boolean updatePromotion(Promotion promotion) {
//        return promotionDAO.update(promotion);
//    }
//
//    // Hiển thị khuyến mãi theo id
//    @Override
//    public Promotion showPromotion(String id) {
//        return promotionDAO.getById(id);
//    }
//}
