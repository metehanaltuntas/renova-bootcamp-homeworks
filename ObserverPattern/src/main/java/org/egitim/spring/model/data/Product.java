package org.egitim.spring.model.data;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Observable;
import java.util.Observer;

/**
 * Observable ise aynı paketteki diğer sınıftır. Genel amacı gözlemlenebilen nesnelere türetme yoluyla temel karakteristikleri
 * kazandırtır. Her observable nesneyi gözlemleyen n tane observer nesne olabilir.
 *
 * Sınıfın addObserver(Observer o) ve deleteObserver(Observer o) metotları ise Observer interface' ini implemente eden
 * nesnelerin register ve unregister edilme işlemlerini gerçekleştirir.
 */

@Component
@Scope("prototype")
public class Product extends Observable {
    private String productName;
    private BigDecimal bidAmount;
    private Observer observer;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getBidAmount() {
        return bidAmount;
    }

    public void setBidAmount(BigDecimal bidAmount) {
        this.bidAmount = bidAmount;
    }

    public Observer getObserver() {
        return observer;
    }

    @Override
    public synchronized void deleteObserver(Observer o) {
        System.out.println("-----------------Unfollow situation----------------");
        System.out.println(((Bidder) o).bidderName + " unfollowed the product");
        super.deleteObserver(o);
    }

    public void setBidAmount(Observer observer, BigDecimal newBidAmount) {
        System.out.println("-----------------New bid placed----------------");
        int res = bidAmount.compareTo(newBidAmount);
        // verilen teklif mevcut tekliften az değilse
        if (res == -1) {
            this.observer = observer;
            this.bidAmount = newBidAmount;
            // setChanger() metodunun ise herhangi bir t anında çağrılması observable nesnenin durumunun değiştiğini ifade eder.
            setChanged();
            /*Observable nesne durumu değiştiğinde notifyObservers() metodunu çağırır. Bu fonksiyon ise observer nesnelerin
             update() metotlarının çağrılmasını sağlar ve observer nesneler kendilerini günceller.*/
            notifyObservers();
        } else {
            // verilen teklif mevcut tekliften az veya eşitse
            System.out.println("New bid amount cannot be less or equal to current bid amount: " + this.bidAmount);
        }
    }
}