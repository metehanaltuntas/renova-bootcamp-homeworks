package com.renova.project.model;

/**
 * şirket olarak bir müşteriyi temsil eder
 */
public class Company extends Customer {
    private String contact;
    private int discount;

    public Company() {
    }

    public Company(int id, String name, String phone, String address) {
        super(id, name, phone, address);
    }

    public Company(String contact, int discount) {
        this.contact = contact;
        this.discount = discount;
    }

    public Company(int id, String name, String phone, String address, String contact, int discount) {
        super(id, name, phone, address);
        this.contact = contact;
        this.discount = discount;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}
