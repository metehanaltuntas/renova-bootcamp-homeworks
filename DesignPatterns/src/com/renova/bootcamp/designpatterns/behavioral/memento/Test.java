package com.renova.bootcamp.designpatterns.behavioral.memento;

/**
 * @author Metehan ALTUNTAŞ
 */

/**
 * Nesnelerin veri elemanlarında taşıdıkları verilere durum bilgisi yani state denilmektedir. Kullanıcı eylemleri nedeniyle
 * ya da farklı sebeplerle nesnenin durum bilgisi değişebilir veya tümüyle kaybolabilir. Bu noktada nesneyi önceki durumuna
 * geri döndürmek bir ihtiyaç haline gelmektedir. Memento pattern' i bu ihtiyaca cevap vermektedir.
 * <p>
 * Terminolojide durum bilgisi korunarak gerektiğinde önceki durumuna ger döndürülmek istenilen nesnelere Originator
 * denilmektedir. Bu nesne basit veya kompleks bir durum bilgisine sahip olabilir.
 * <p>
 * Burada akla takılan bir soru olarak neden doğrudan Originator olan nesnede durum bilgisi saklanmadığı ve bunun için
 * ayrı bir Memento nesne kullanmak gerektiği akla gelebilir. Burada yanıt Encapsulation prensibinin uygulanmasıdır.
 * Yani Memento nesne sadece Originator nesnenin orjinal durumuna geri dönebilmesi için gerekli olan bilgiye sahip olmalıdır.
 * Bundan daha fazlasını bilmesi Encapsulation' a aykırıdır.
 * <p>
 * Ayrıca Caretaker ismiyle sembolize edilen taşıyıcı(container) nesnede aynı Originator' a ilişkin birden çok Memento
 * nesne de saklanabilir. Genellikle undo-redo sistemlerinde bu durum Memento nesnelerin bir stack sistemi yardımıyla
 * saklanması şeklinde uygulanmaktadır.
 */

public class Test {
    public static void main(String[] args) {
        // oluşturulacak element' in bilgileri
        ElementInformation elementInformation = new ElementInformation();
        elementInformation.setElementType(ElementTypes.TRANSISTOR);
        elementInformation.setDetail("BC-237");
        elementInformation.setLocation(new Location(12, 35));

        // bilgiler kullanılarak elementin yaratılması (originator nesne)
        Element originator = new Element(elementInformation);
        System.out.println(originator);

        // originator nesne için memento nesnesinin yaratılması
        Memento memento = originator.createMemento();
        // artık originator nesnenin bir yedeği alındı

        // şimdi originator nesnenin bilgilerini değiştiriyoruz
        originator.setElementInformation(new ElementInformation(
                ElementTypes.TRANSISTOR,
                "BD-547",
                new Location(12, 35)));
        System.out.println(originator);

        /**
         * originator nesnenin bilgilerini yukarıda değiştirmiştik ama bu işlemi geri almak istiyoruz
         * bu yüzden originator nesnenin information bilgisini memento nesnenin information bilgisi ile değiştiriyoruz
         */
        originator.setMemento(memento);
        // ve artık nesnemizin bilgileri eskiden olduğu gibi oldu
        System.out.println(originator);
    }
}
