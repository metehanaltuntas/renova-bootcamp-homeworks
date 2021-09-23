package com.renova.project.model;

import com.renova.project.interfaces.Taxable;

/**
 * her bir siparişin içerisindeki farklı item' ları tanımlayan sınıf
 */
public class OrderItem {
    private int lineNbr;
    private Product product;
    private int quantity;

    private final Taxable taxable = new Hardware();

    public OrderItem() {
    }

    public OrderItem(int lineNbr, Product product, int quantity) {
        this.lineNbr = lineNbr;
        this.product = product;
        this.quantity = quantity;
    }

    public int getLineNbr() {
        return lineNbr;
    }

    public void setLineNbr(int lineNbr) {
        this.lineNbr = lineNbr;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTax(){
        return this.taxable.getTax();
    }

    public double getUnitPrice(){
        return Double.parseDouble(product.getRetailPrice());
    }

    @Override
    public String toString() {
        return "Order Item{" +
                "Line Number: " + lineNbr +
                " | Product: " + product +
                " | Quantity: " + quantity +
                '}';
    }
}
