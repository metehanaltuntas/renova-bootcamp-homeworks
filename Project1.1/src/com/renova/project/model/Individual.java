package com.renova.project.model;

/**
 * bireysel olarak bir müşteri
 */
public class Individual extends Customer {
    private String licNumber;

    public Individual() {
    }

    public Individual(int id, String name, String phone, String address) {
        super(id, name, phone, address);
    }

    public Individual(String licNumber) {
        this.licNumber = licNumber;
    }

    public Individual(int id, String name, String phone, String address, String licNumber) {
        super(id, name, phone, address);
        this.licNumber = licNumber;
    }

    public String getLicNumber() {
        return licNumber;
    }

    public void setLicNumber(String licNumber) {
        this.licNumber = licNumber;
    }
}
