package com.renova.bootcamp.designpatterns.structured.flyweight.withoutflyweight;

import com.renova.bootcamp.designpatterns.structured.flyweight.CoffeeFlavour;
import com.renova.bootcamp.designpatterns.structured.flyweight.CoffeeLatteArt;

import java.util.ArrayList;

// siparişlerin listesini tutan sınıf
public class CoffeeShop {
	
	private static final ArrayList<Order> orders = new ArrayList<>();

	public void takeOrder(CoffeeFlavour flavourName, CoffeeLatteArt latteArt, int tableNumber) {
		orders.add(Order.of(flavourName, latteArt, tableNumber));
	}

	public static int getNumberOfOrders() {
		return orders.size();
	}

}