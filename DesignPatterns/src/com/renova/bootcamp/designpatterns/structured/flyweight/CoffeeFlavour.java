package com.renova.bootcamp.designpatterns.structured.flyweight;

// kahve aromaları
public enum CoffeeFlavour {

    CAPPUCCINO("Cappuccino"),
    ESPRESSO("Espresso"),
    FRAPPUCCINO("Frappuccino"),
    AFFOGATO("Affogato"),
    LATTE("Latte");

    private String name;

    CoffeeFlavour(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
