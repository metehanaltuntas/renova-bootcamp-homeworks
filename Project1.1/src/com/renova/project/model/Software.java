package com.renova.project.model;

/**
 * bir alt product
 */
public class Software extends Product {
    private String license;

    public Software() {
    }

    public Software(int id, String name, String description, String retailPrice) {
        super(id, name, description, retailPrice);
    }

    public Software(String license) {
        this.license = license;
    }

    public Software(int id, String name, String description, String retailPrice, String license) {
        super(id, name, description, retailPrice);
        this.license = license;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }
}
