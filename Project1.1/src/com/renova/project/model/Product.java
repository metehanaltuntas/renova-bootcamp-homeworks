package com.renova.project.model;

/**
 * sipariş verilebilecek ürünleri tanımlayan sınıf
 */
public class Product {

    private int id;
    private String name;
    private String description;
    private String retailPrice;

    public Product() {
    }

    public Product(int id, String name, String description, String retailPrice) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.retailPrice = retailPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(String retailPrice) {
        this.retailPrice = retailPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                " Product ID: '" + id + '\'' +
                " | Product Name: '" + name + '\'' +
                " | Product Description: '" + description + '\'' +
                " | Product Retail Price: '" + retailPrice + '\'' +
                '}';
    }
}
