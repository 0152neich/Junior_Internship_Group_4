package controller;

import model.Production;


public interface ProductManagement {
    public boolean addProduct(Production production);
    public boolean updateProduct(Production production);
    public boolean deleteProduct(String id);
    public boolean showProduct();
}
