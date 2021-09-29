package com.renova.bootcamp.designpatterns.structured.flyweight.withoutflyweight;


import com.renova.bootcamp.designpatterns.structured.flyweight.CoffeeFlavour;
import com.renova.bootcamp.designpatterns.structured.flyweight.CoffeeLatteArt;

// coffee sınıfı hem kahve aromasını hem de kahvenin üstündeki sanatı içerecek
public class Coffee {

    protected final CoffeeFlavour flavourName;
    protected final CoffeeLatteArt latteArt;

    protected Coffee(CoffeeFlavour flavourName, CoffeeLatteArt latteArt) {
        this.flavourName = flavourName;
        this.latteArt = latteArt;
    }

    public CoffeeFlavour getFlavourName() {
        return flavourName;
    }

    public CoffeeLatteArt getLatteArt() {
        return latteArt;
    }

}