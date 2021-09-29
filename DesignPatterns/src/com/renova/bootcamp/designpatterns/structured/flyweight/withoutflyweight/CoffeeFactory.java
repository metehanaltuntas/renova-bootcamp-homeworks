package com.renova.bootcamp.designpatterns.structured.flyweight.withoutflyweight;


import com.renova.bootcamp.designpatterns.structured.flyweight.CoffeeFlavour;
import com.renova.bootcamp.designpatterns.structured.flyweight.CoffeeLatteArt;

import java.util.ArrayList;
import java.util.List;

// kahve üretmek için bir fabrika sınıfı
public class CoffeeFactory {

	protected static List<Coffee> coffeeList = new ArrayList<>();

	public static Coffee makeCoffee(CoffeeFlavour flavourName, CoffeeLatteArt latteArt) {
		Coffee coffee = new Coffee(flavourName, latteArt);
		System.out.printf("Making '%s' with Latte Art '%s'.\n", coffee.getFlavourName(), coffee.getLatteArt());
		coffeeList.add(coffee);
		return coffee;
	}

	public static int getNumberOfCoffee() {
		return coffeeList.size();
	}
}
