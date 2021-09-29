package com.renova.bootcamp.designpatterns.structured.flyweight.withoutflyweight;


import com.renova.bootcamp.designpatterns.structured.flyweight.CoffeeFlavour;
import com.renova.bootcamp.designpatterns.structured.flyweight.CoffeeLatteArt;

// siparişleri alan sınıf.
public class Order {

    protected Coffee coffee;

    public Order(Coffee coffee) {
        this.coffee = coffee;
    }

    // geriye oluşturulmuş bir order döndürür
    public static Order of(CoffeeFlavour flavourName, CoffeeLatteArt latteArt, int tableNumber) {
        Coffee coffee = CoffeeFactory.makeCoffee(flavourName, latteArt);
        System.out.printf("Serving to table '%d'.\n", tableNumber);
        System.out.println("------------------------------------------------------");
        return new Order(coffee);
    }

    public Coffee getCoffee() {
        return coffee;
    }

}