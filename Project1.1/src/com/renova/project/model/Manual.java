package com.renova.project.model;

/**
 * bir product alt sınıfı
 */
public class Manual extends Product {
    private String publisher;

    public Manual() {
    }

    public Manual(int id, String name, String description, String retailPrice) {
        super(id, name, description, retailPrice);
    }

    public Manual(String publisher) {
        this.publisher = publisher;
    }

    public Manual(int id, String name, String description, String retailPrice, String publisher) {
        super(id, name, description, retailPrice);
        this.publisher = publisher;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}
