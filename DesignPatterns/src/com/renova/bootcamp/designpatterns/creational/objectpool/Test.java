package com.renova.bootcamp.designpatterns.creational.objectpool;

/**
 * @author Metehan ALTUNTAŞ
 */

/**
 * Nesne yaratma işlemleri özellikle bazı nesneler için performansı doğrudan etkilemektedir. Performans da çoğu
 * yazılım için temel niteliklerden biridir. Bu anlamda Object Pool design pattern belirli sayıda nesneyi önceden
 * yaratıp havuzlama ihtiyacını karşılamaktadır.
 * <p>
 * Özellikle çok kullanıcıya hizmet veren uygulamalarda iş yapan nesnelerin veritabanı bağlantılarının havuzlanması
 * bu pattern' in uygulanma şekli olarak örnek verilebilir. İstemci böyle bir nesneye ihtiyaç duyduğu zaman bu nesneyi
 * yaratmaktansa, bu nesneyi daha önceden yaratılmış hazır bir nesnenin kullanılmak üzere havuzdan çıkarılarak istemiciye
 * verilmesi, istemcinin nesneyle işi bittikten sonra ise nesneyi yok etmek yerine havuza geri göndermesi performansı
 * arttıran bir yöntemdir.
 */

public class Test {
    public static void main(String[] args) {
        try {
            Connection connection = new Connection("k1");
            connection.open();
            connection.execute("select1");
            // bağlantılar kapatılmazsa hala kullanılıyor demektir ve kapatılmadan pool' dan alınıp kullanılamazlar
            connection.close();
            System.out.println("---------------------");
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }

        try {
            Connection connection2 = new Connection("k1");
            connection2.open();
            connection2.execute("select2");
            // bağlantılar kapatılmazsa hala kullanılıyor demektir ve kapatılmadan pool' dan alınıp kullanılamazlar
            connection2.close();
            System.out.println("---------------------");
        } catch (NullPointerException e) {
            System.out.println("Lütfen bekleyin");
        }

        try {
            Connection connection3 = new Connection("k1");
            connection3.open();
            connection3.execute("select3");
            // bağlantılar kapatılmazsa hala kullanılıyor demektir ve kapatılmadan pool' dan alınıp kullanılamazlar
            connection3.close();
            System.out.println("---------------------");
        } catch (NullPointerException e) {
            System.out.println("Lütfen bekleyin");
        }

        try {
            Connection connection4 = new Connection("k1");
            connection4.open();
            connection4.execute("select4");
            // bağlantılar kapatılmazsa hala kullanılıyor demektir ve kapatılmadan pool' dan alınıp kullanılamazlar
            connection4.close();
            System.out.println("---------------------");
        } catch (NullPointerException e) {
            System.out.println("Lütfen bekleyin");
        }

        System.out.println("\n");

        try {
            Connection connection5 = new Connection("k3");
            connection5.open();
            connection5.execute("select5");
            connection5.close();
            System.out.println("---------------------");
        } catch (NullPointerException e) {
            System.out.println("Lütfen bekleyin");
        }

    }
}
