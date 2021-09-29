package com.renova.bootcamp.designpatterns.structured.flyweight.withflyweight;


import com.renova.bootcamp.designpatterns.structured.flyweight.CoffeeFlavour;
import com.renova.bootcamp.designpatterns.structured.flyweight.CoffeeLatteArt;

public class Coffee {

	protected final CoffeeFlavour flavourName; // intrinsic(içsel/değişmez) attribute

	protected Coffee(CoffeeFlavour flavourName) {
		super();
		this.flavourName = flavourName;
	}

	public CoffeeFlavour getFlavourName() {
		return flavourName;
	}

	protected CoffeeLatteArt applyLatteArt(CoffeeLatteArt latteArt) {
		/**
		 * CoffeeLatteArt, Extrinsic(dışsal) nitelik olarak hareket edecektir. Bu nedenle, Coffee nesnesinin oluşturulmasında
		 * ve işlenmesinde method parametreleri olarak gerekli olacak ve class member olarak saklanmayacaktır.
		 */
		return latteArt;
	}

}