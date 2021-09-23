package com.renova.project.service.impl;

import com.renova.project.model.Hardware;
import com.renova.project.model.Manual;
import com.renova.project.model.Product;
import com.renova.project.model.Software;
import com.renova.project.service.ProductOperationService;

import java.util.ArrayList;

public class ProductOperationServiceImpl implements ProductOperationService {
    private static ArrayList<Product> productArrayList;

    public ProductOperationServiceImpl() {
        if (productArrayList == null) {
            productArrayList = new ArrayList<>();
        }
    }

    // product nesneleri oluşturur
    @Override
    public void createSomeProduct() {
        Product product1 = new Hardware(1, "Logitect K380", "Bluetooth Keyboard", "300", 3);
        Product product2 = new Manual(2, "Inca S1", "Wireless Mouse", "200", "Inca Tech");
        Product product3 = new Software(3, "Samsun Galaxy Note 10", "Samsung' s Android Phone", "8000", "License X");

        productArrayList.add(product1);
        productArrayList.add(product2);
        productArrayList.add(product3);
    }

    // mevcut product' ları listeler
    @Override
    public void listProducts() {
        for (Product product : productArrayList) {
            System.out.println(product.toString());
        }
    }

    // product' ları array olarak döndürür
    @Override
    public ArrayList<Product> getProductArrayList() {
        return productArrayList;
    }

    // bir product seçilip sipariş listesine eklenmiş mi kontrol eder
    @Override
    public boolean isThisProductPreselected(ArrayList<Product> productArrayList, int productId) {
        for (Product product : productArrayList) {
            if (product.getId() == productId) {
                return true;
            }
        }
        return false;
    }

    // dizideki product' ları yazdırır
    @Override
    public void printProductsInArray(ArrayList<Product> productArrayList) {
        System.out.println("İşleme alınacak ürünler:");

        for (int i = 0; i < productArrayList.size(); i++) {
            System.out.println((i + 1) + " - " + productArrayList.get(i).getName());
        }
    }
}
