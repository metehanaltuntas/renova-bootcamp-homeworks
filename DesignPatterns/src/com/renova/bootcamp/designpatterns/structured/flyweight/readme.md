Nesne yönenimli olarak geliştirilen bir uygulamada nesne sayısı arttıkça maliyet de artmakta buna bağlı olarak performans kayıpları oluşmaktadır. 
Bu noktada Flyweight pattern bir çözüm sunmaktadır.
Flyweight pattern, diğer benzer nesnelerle mümkün olduğunca fazla veri paylaşarak bellek kullanımını en aza indirmek için kullanılır.
Halihazırda var olan benzer türdeki nesneleri cache gibi davranan ve eşleşen hiçbir nesne bulunmadığında yeni nesne oluşturan bir koleksiyonda depolayarak yeniden kullanmaya çalışır.

Flyweight nesneleri immutable yapmak oluşturulduktan sonra değiştirilemeyecekleri anlamına gelir bu da onları diğer nesnelerle paylaşırken yardımcı olur.
Flyweight pattern, çok sayıda nesneye sahip olmaktan kaçınmamıza yardımcı olur ve oluşturulan nesneleri mümkün olduğunca yeniden kullanarak etkin bir şekilde kullanmamızı sağlar.

Flyweight nesnesinin temelde iki farklı özelliği vardır:
- Intrinsic - Bir instrinsic(içsel/değişmez) durum özelliği, flyweight nesnesinde depolanır ve paylaşılır. En iyi uygulama olarak içsel durumları değişmez yapmalıyız.
- Extrinsic - Bir extrinsic(dışsal) durum özelliği nesneye göre değiştiği için bu özellikler paylaşılmaz.