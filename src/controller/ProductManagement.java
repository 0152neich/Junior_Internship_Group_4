package controller;

import model.Production;

import java.util.ArrayList;

public interface ProductManagement {
    public boolean addProduct();
    public boolean updateProduct();
    public boolean deleteProduct();
    public ArrayList<Production> searchProductByName();
    public boolean showProduct();
}
