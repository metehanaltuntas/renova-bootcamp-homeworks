package com.renova.bootcamp.designpatterns.structured.flyweight.withflyweight;

import com.renova.bootcamp.designpatterns.structured.flyweight.CoffeeFlavour;
import com.renova.bootcamp.designpatterns.structured.flyweight.CoffeeLatteArt;

public class Test {
	public static void main(String[] args) {
		// kahve sipariş verebilmek için bir coffeShop nesnesi yaratılır
		CoffeeShop shop = new CoffeeShop();

		shop.takeOrder(CoffeeFlavour.CAPPUCCINO, CoffeeLatteArt.BARISTA_SWAG, 5);
		shop.takeOrder(CoffeeFlavour.AFFOGATO, CoffeeLatteArt.FRENCH, 7);
		shop.takeOrder(CoffeeFlavour.ESPRESSO, CoffeeLatteArt.FISHBONE, 1);
		shop.takeOrder(CoffeeFlavour.LATTE, CoffeeLatteArt.DISNEY, 3);
		shop.takeOrder(CoffeeFlavour.CAPPUCCINO, CoffeeLatteArt.CAT, 2);
		shop.takeOrder(CoffeeFlavour.ESPRESSO, CoffeeLatteArt.FISHBONE, 8);
		shop.takeOrder(CoffeeFlavour.AFFOGATO, CoffeeLatteArt.BARISTA_SWAG, 4);
		shop.takeOrder(CoffeeFlavour.CAPPUCCINO, CoffeeLatteArt.DISNEY, 10);
		shop.takeOrder(CoffeeFlavour.LATTE, CoffeeLatteArt.LITTLE_BUNNY, 6);
		shop.takeOrder(CoffeeFlavour.FRAPPUCCINO, CoffeeLatteArt.DISNEY, 9);

		System.out.println("------------------------------------------------------------");
		System.out.println("Number of Order Objects: " + CoffeeShop.getNumberOfOrders());
		System.out.println("Number of Coffee Objects: " + CoffeeFactory.getNumberOfCoffee());
	}
}