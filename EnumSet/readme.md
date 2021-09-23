*Enum türü, bir değişkenin önceden tanımlanmış sabitler kümesi olmasını sağlayan özel bir veri türüdür.
Değişken, kendisi için önceden tanımlanmış değerlerden birine eşittir.
Yani enum' lar bizim için belirli sabit değerleri tutan yapılardır.
Programları oluştururken, bir grup adlandırılmış sabite hizmet etmek için genellikle enum' ları kullanırız.
Ancak, enum türüyle bir Set interface' i uygulamak istiyorsak, Java'da EnumSet'i kullanmamız gerekir.
Özetle EnumSet, enum türüyle çalışmak için Set collection' larının bir uygulamasıdır. 
EnumSet, AbstractSet'ten extend alır ve Set interface' ini implement eder.*

Java'da EnumSet hakkında birkaç önemli nokta şunlardır:
- Yalnızca aynı enumaration türüne ait enum değerlerini içerir
- Java Collection Framework' ün bir üyesidir.
- Yüksek performanslı set implementation' ını sağlar ve senkronize edilmez (thread safe değildir)
- Kullanıcının NULL değerler eklemesine izin vermez ve bir NullPointerException oluşturur.
- Öğeler, kaydedildikleri sırayla saklanır
- ConcurrentModificationException' ının fırlatıldığından emin olmak için kullanılabilecek güvenli bir iteration kullanır

Program içerisinde EnumSet' in bize sunduğu metotlardan örneklere yer verilmiştir.