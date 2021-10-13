package org.egitim.spring.controller;

import org.egitim.spring.model.servi̇ce.IOrderServiceFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class OrderFulfillmentController {
    @Autowired
    private IOrderServiceFacade facade;
    private boolean orderFulfilled = false;


    public boolean isOrderFulfilled() {
        return this.orderFulfilled;
    }

    public void orderProduct(int productId) {
        // sipariş işleminin
        this.orderFulfilled = facade.placeOrder(productId);
        System.out.println("OrderFulfillmentController: Order fulfillment completed.");
    }
}