import org.egitim.spring.controller.OrderFulfillmentController;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Gerçekleştirilen projede bir e-ticaret mağazasının sipariş karşılama süreci basit anlamda ele alınmıştır. Buradaki senaryoda
 * gerçekleştirilen işlemler şu hizmetler sürecini tamamlar:
 *
 * Inventory service: Ürün var mı diye denetler
 * Payment service: Ödeme işlemi için bir payment ağ geçidine bağlanır
 * Shipping service: Ürünü depodan kullanıcıya göndermek için harici bir lojistik web hizmetiyle bağlantı kurar
 *
 * Bu senaryoda uygulamanın controller' ı, sipariş için hizmetlerle etkileşime girer. Kullanıcı sipariş vermek için
 * kullanıcı arayüzü ile etkileşim kurduğunda, istek denetleyiciyle eşleştirilir, bu da isteği yerine getirmek için hizmetlerle
 * etkileşime girer ve ardından kullanıcıyı yerine getirme durumu hakkında bilgilendirir.
 *
 * Ama farklı istemciler(desktop, web, desktop) sipariş vermeye başladığında her istemcinin bu servislere doğrudan ulaşması
 * ve çoklu etkileşimler yapması sınıfların birbirine sıkı bağlı olduğunu gösterir. Bu da istenmeyen bir durumdur ve SOLID' i
 * ihlal eder.
 *
 * Bu yüzden bu işlemin yüzü olacak bir sınıfa ihtiyacımız var. Arka planda ne iş yapıldığının bir önemi yok. Ön tarafa
 * her şeyi göstermeden bu işleri yönetebiliriz. Yani client tarafına belirli erişimleri veren bir sınıf tasarlamalıyız.
 */

class TestFacadePattern {
    @Test
    void name() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("context.xml");

        OrderFulfillmentController orderFulfillmentController = applicationContext.getBean("orderFulfillmentController", OrderFulfillmentController.class);

        // ürünün sipariş verilmesi
        orderFulfillmentController.orderProduct(9);
    }
}
