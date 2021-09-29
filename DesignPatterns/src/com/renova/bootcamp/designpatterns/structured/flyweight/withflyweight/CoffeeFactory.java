package com.renova.bootcamp.designpatterns.structured.flyweight.withflyweight;

import com.renova.bootcamp.designpatterns.structured.flyweight.CoffeeFlavour;
import com.renova.bootcamp.designpatterns.structured.flyweight.CoffeeLatteArt;

import java.util.WeakHashMap;


public class CoffeeFactory {

    protected static WeakHashMap<CoffeeFlavour, Coffee> coffeeMap = new WeakHashMap<>();

    public static Coffee makeCoffee(CoffeeFlavour flavourName, CoffeeLatteArt latteArt) {
        // belirtilen coffe ismiyle daha önceden bir ekleme yapılmış mı?
        Coffee coffee = coffeeMap.get(flavourName);
        if (coffee == null) {
            // ekleme yapılmadıysa bu kahve ilk defa sipariş veriliyordur listeye ekle
            // ekleme yapıldıysa ekleme tekrar ekleme çünkü bu coffee nesnesi zaten listede var
            coffee = new Coffee(flavourName);
            coffeeMap.put(flavourName, coffee);
        }
        System.out.printf("Making '%s' with Latte Art '%s'.\n", coffee.getFlavourName(),
                coffee.applyLatteArt(latteArt));
        return coffee;
    }

    public static int getNumberOfCoffee() {
        return coffeeMap.size();
    }

}
