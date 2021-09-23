package com.renova.project.service;

import com.renova.project.model.Product;

import java.util.ArrayList;

public interface ProductOperationService {
    void createSomeProduct();
    void listProducts();
    ArrayList<Product> getProductArrayList();
    boolean isThisProductPreselected(ArrayList<Product> productArrayList, int productId);
    void printProductsInArray(ArrayList<Product> productArrayList);
}
