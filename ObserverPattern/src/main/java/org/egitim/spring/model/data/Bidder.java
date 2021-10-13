package org.egitim.spring.model.data;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Observable;
import java.util.Observer;

/**
 * java.util paketindeki Observer isimli interface durum bilgisi değiştiğinde kendisini gözlemleyen nesnelere uyarı
 * gönderebilen nesneler için gerekli eylemi (update metodu) tanımlar.
 */

@Component
@Scope("prototype")
public class Bidder implements Observer {
    Product observable;
    String bidderName;

    public void setBidderName(String bidderName) {
        this.bidderName = bidderName;
    }

    /**
     * Tüm observer' lara bildirim yapılması için update metodu. Her observer için çağrılır.
     */
    @Override
    public void update(Observable observable, Object arg) {
        this.observable = (Product) observable;
        String name = this.observable.getObserver().toString();
        if (name.equals(bidderName)) {
            System.out.println("Hello " + bidderName + "! New bid of amount " + this.observable.getBidAmount() + " has been placed on " + this.observable.getProductName() + " by you");
        }
        if (!name.equals(bidderName))
            System.out.println("Hello " + bidderName + "! New bid of amount " + this.observable.getBidAmount() + " has been placed on " + this.observable.getProductName() + " by " + this.observable.getObserver());
    }

    @Override
    public String toString() {
        return bidderName;
    }
}
