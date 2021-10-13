import org.egitim.spring.model.data.Bidder;
import org.egitim.spring.model.data.Product;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;

/**
 * Gerçekleştirilen projede bir ürüne teklif veren kullanıcılar baz alınmıştır. Kullanıcılar ürüne teklif verdiklerinde
 * ürünü takip eden diğer kullanıcıların da bundan haberi olmaktadır.
 */

public class TestObserverPattern {
    @Test
    void name() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("context.xml");

        // product yaratılması
        Product product = applicationContext.getBean("product", Product.class);
        product.setProductName("L340 Digital Camera");
        product.setBidAmount(new BigDecimal("325"));

        // bidder yaratılması
        Bidder bidder = applicationContext.getBean("bidder", Bidder.class);
        bidder.setBidderName("Metehan ALTUNTAŞ");

        Bidder bidder2 = applicationContext.getBean("bidder", Bidder.class);
        bidder2.setBidderName("Mustafa UZUNLAR");

        Bidder bidder3 = applicationContext.getBean("bidder", Bidder.class);
        bidder3.setBidderName("Ayşe SALKIMDOĞAN");

        // observer nesnelerin eklenmesi
        product.addObserver(bidder);
        product.addObserver(bidder2);
        product.addObserver(bidder3);

        // teklif verilmesi
        product.setBidAmount(bidder, new BigDecimal(350));

        // observer' ın silinmesi
        product.deleteObserver(bidder2);

        product.setBidAmount(bidder3, new BigDecimal(375));

    }
}
