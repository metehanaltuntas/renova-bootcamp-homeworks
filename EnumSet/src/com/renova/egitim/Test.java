package com.renova.egitim;
import java.util.EnumSet;

/**
 * @author Metehan ALTUNTAŞ
 */

/**
 * Enum türü, bir değişkenin önceden tanımlanmış sabitler kümesi olmasını sağlayan özel bir veri türüdür.
 * Değişken, kendisi için önceden tanımlanmış değerlerden birine eşittir.
 * Yani enum' lar bizim için belirli sabit değerleri tutan yapılardır.
 * Programları oluştururken, bir grup adlandırılmış sabite hizmet etmek için genellikle enum' ları kullanırız.
 * Ancak, enum türüyle bir Set interface' i uygulamak istiyorsak, Java'da EnumSet'i kullanmamız gerekir.
 * Özetle EnumSet, enum türüyle çalışmak için Set collection' larının bir uygulamasıdır. EnumSet, AbstractSet'ten extend alır ve Set interface' ini implement eder.
 * <p>
 * Java'da EnumSet hakkında birkaç önemli nokta şunlardır:
 * - Yalnızca aynı enumaration türüne ait enum değerlerini içerir
 * - Java Collection Framework' ün bir üyesidir.
 * - Yüksek performanslı set implementation' ını sağlar ve senkronize edilmez (thread safe değildir)
 * - Kullanıcının NULL değerler eklemesine izin vermez ve bir NullPointerException oluşturur.
 * - Öğeler, kaydedildikleri sırayla saklanır
 * - ConcurrentModificationException' ının fırlatıldığından emin olmak için kullanılabilecek güvenli bir iteration kullanır
 * <p>
 * Aşağıda EnumSet' in bize sunduğu metotlardan örneklere yer verilmiştir.
 */
public class Test {
    public static void main(String[] args) {
        // bir enum set referansı oluşturalım
        EnumSet<ProgrammingLanguagesEnum> sampleSet;

        // of method -> belirtilen değerlerle bir enum set oluşturur
        // bir tane veri ekliyoruz
        sampleSet = EnumSet.of(ProgrammingLanguagesEnum.C);
        // seti yazdır
        System.out.println("The EnumSet after adding a single element is: " + sampleSet);

        // iki tane veri ekliyoruz
        sampleSet = EnumSet.of(ProgrammingLanguagesEnum.C, ProgrammingLanguagesEnum.JAVA);
        // seti yazdır
        System.out.println("The EnumSet after adding two elements is: " + sampleSet);


        //Range method -> Başlangıçta belirtilen iki uç nokta tarafından tanımlanan aralıktaki tüm öğeleri içeren bir enum seti oluşturmak için kullanılır.
        sampleSet = EnumSet.range(ProgrammingLanguagesEnum.JAVA, ProgrammingLanguagesEnum.JAVASCRIPT);
        // seti yazdır
        System.out.println("The range of the EnumSet is: " + sampleSet);

        //allOf method -> Belirtilen öğe türündeki tüm öğeleri içeren bir enum kümesi oluşturmak için kullanılır.
        sampleSet = EnumSet.allOf(ProgrammingLanguagesEnum.class);
        // seti yazdır
        System.out.println("All the elements in the EnumSet are: " + sampleSet);


        //copyOf(EnumSet) method -> bir enumSet' i başka bir enumSet' e kopyalar

        // tüm elemanları set' e atıyoruz
        EnumSet<ProgrammingLanguagesEnum> exampleSet = EnumSet.allOf(ProgrammingLanguagesEnum.class);
        // seti yazdırıyoruz
        System.out.println("The elements in the initial EnumSet are: " + exampleSet);
        // elemanları başka bir enumSet' e kopyalıyoruz
        EnumSet<ProgrammingLanguagesEnum> finalSet = EnumSet.copyOf(exampleSet);
        // yeni seti yazdırıyoruz
        System.out.println("The elements in the copied EnumSet are: " + finalSet);

        //complementOf method -> belirtilen değerlerin yer almadığı ancak enum içerisindeki diğer tüm değerlerin yer aldığı bir set oluşturur
        // örnek set
        sampleSet = EnumSet.of(ProgrammingLanguagesEnum.JAVA, ProgrammingLanguagesEnum.JAVASCRIPT, ProgrammingLanguagesEnum.PERL);
        // bir enumSet oluşturuyoruz
        EnumSet<ProgrammingLanguagesEnum> complementSet;
        // seçilen değerlerin olmadığı bir enumSet oluşturuluyor
        complementSet = EnumSet.complementOf(sampleSet);
        // oluşturulan set' i yazdırıyoruz
        System.out.println("The elements in the complement EnumSet are: " + complementSet);

        // noneOf method -> belirtilen tipte boş bir enumSet oluşturur
        // seti oluştur
        EnumSet<ProgrammingLanguagesEnum> noneExampleSet = EnumSet.noneOf(ProgrammingLanguagesEnum.class);
        // seti yazdır (boş)
        System.out.println("EnumSet consists of the elements: " + noneExampleSet);

        //clone method -> metodu kullanan set' in bir kopyasını oluşturur
        EnumSet<ProgrammingLanguagesEnum> finalCloneSet = sampleSet.clone();
        // kopyayı yazdır
        System.out.println("The clone set consists of the elements:" + finalCloneSet);

        // remove method -> belirtilen enum değerini listeden kaldırır
        // removeAll moethod -> colleciton tipinde verilen listedeki her elemanı belirtilen enumSet' ten kaldırır(burada kullanılmadı)
        finalCloneSet.remove(ProgrammingLanguagesEnum.JAVA);
        System.out.println("The set items after remove element:" + finalCloneSet);


        // son olarak oluşturduğumuz ProgrammingLanguagesEnum tipinde değerleri tutan bir enumSet ile bu
        // kayıtları ve bütün özelliklerini yazdıralım
        System.out.println("\n- ProgrammingLanguagesEnum içerisindeki bütün kayıtlar ve özellikleri: ");
        EnumSet<ProgrammingLanguagesEnum> programmingLanguagesEnums = EnumSet.allOf(ProgrammingLanguagesEnum.class);
        for (ProgrammingLanguagesEnum programmingLanguagesEnum : programmingLanguagesEnums) {
            System.out.println("Programming language name: " + programmingLanguagesEnum.getProgrammingLanguage() + " | " +
                    "release date: " + programmingLanguagesEnum.getReleaseDate());
        }
    }
}
