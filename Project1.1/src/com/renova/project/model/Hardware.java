package com.renova.project.model;

import com.renova.project.interfaces.Taxable;

/**
 * bir product çeşidi
 */
public class Hardware extends Product implements Taxable {
    private int warrantyPeriod;

    public Hardware() {
    }

    public Hardware(int id, String name, String description, String retailPrice) {
        super(id, name, description, retailPrice);
    }

    public Hardware(int warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }

    public Hardware(int id, String name, String description, String retailPrice, int warrantyPeriod) {
        super(id, name, description, retailPrice);
        this.warrantyPeriod = warrantyPeriod;
    }

    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setWarrantyPeriod(int warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }

    @Override
    public double getTax() {
        return Double.parseDouble(this.getRetailPrice()) * 18 / 100;
    }
}
