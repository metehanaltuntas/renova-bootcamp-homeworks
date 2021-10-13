package org.egitim.spring.model.servi̇ce.iml;

import org.egitim.spring.model.data.Product;
import org.egitim.spring.model.servi̇ce.IOrderServiceFacade;
import org.egitim.spring.model.servi̇ce.InventoryService;
import org.egitim.spring.model.servi̇ce.PaymentService;
import org.egitim.spring.model.servi̇ce.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;


/**
 * işlemleri gerçekleştiren facade sınıf
 */
@Service
public class OrderServiceFacadeImpl implements IOrderServiceFacade {
    @Autowired
    private Product product;
    @Autowired
    private InventoryService inventoryService;
    @Autowired
    private PaymentService paymentService;
    @Autowired
    private ShippingService shippingService;

    /**
     * aslında tanımlanmış herhangi bir product yok. burada rastgele gönderilen productId' deki ürünün var olduğunu düşünüyoruz
     * ve gerekli işlemleri yapıyoruz. order işlemi kendi içerisinde birden fazla metot' tan da oluşabilirdi ama burada gerek duyulmadı
     */
    @Override
    public boolean placeOrder(int productId) {
        boolean orderFulfilled = false;
        product.productId = productId;
        // ürünün var mı?
        if (inventoryService.isAvailable(product)) {
            System.out.println("Product with ID: " + product.productId + " is available.");
            // ödeme kontrolü
            boolean paymentConfirmed = paymentService.makePayment();
            if (paymentConfirmed) {
                System.out.println("Payment confirmed...");
                shippingService.shipProduct(product);
                System.out.println("Product shipped...");
                orderFulfilled = true;
            }
        }
        return orderFulfilled;
    }
}




