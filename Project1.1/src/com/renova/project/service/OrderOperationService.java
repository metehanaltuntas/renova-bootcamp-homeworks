package com.renova.project.service;

import com.renova.project.model.OrderItem;
import com.renova.project.model.Product;

import java.util.ArrayList;

public interface OrderOperationService {
    void selectUserForOrder();
    void getProductsToOrder();
    void getOrderQuantities(ArrayList<Product> productArrayList);
    void completeTheOrder();
    double calculateTheOrderTotal(OrderItem orderItem);
    void printTheOrdersOfTheLastCustomerWhoPlacedAnOrdee();
    void printAllOrdersAndDetails();
}
