package com.renova.project.model;

import java.util.ArrayList;
import java.util.Date;

/**
 * müşterinin verdiği siparişleri tanımlayan sınıf
 */
public class Order {
    private int id;
    private Customer customer;
    private  ArrayList<OrderItem> orderItems = new ArrayList<>();
    private Date orderDate;
    private double orderTotal;

    public Order() {
    }

    public Order(int id, Customer customer, ArrayList<OrderItem> orderItems, Date orderDate, double orderTotal) {
        this.id = id;
        this.customer = customer;
        this.orderItems = orderItems;
        this.orderDate = orderDate;
        this.orderTotal = orderTotal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ArrayList<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(ArrayList<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;
    }

    public void addOrderItem(OrderItem orderItem){
        orderItems.add(orderItem);
    }

    @Override
    public String toString() {
        return "Order{" +
                "Order ID: " + id +
                " | Customer: " + customer +
                " | Order Date: " + orderDate +
                " | Order Total: " + orderTotal +
                '}';
    }
}
