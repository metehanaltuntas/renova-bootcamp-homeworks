package com.renova.bootcamp.designpatterns.creational.objectpool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PoolManager {
    private static final int POOL_SIZE = 3;
    protected static PoolManager poolManager;
    private HashMap<String, List<ConnectionContext>> pools;

    protected PoolManager() {
        pools = new HashMap<>(POOL_SIZE);
    }

    // eğer henüz bir havuz oluşturulmadıysa bize bir belirlenen boyuta sahip bir havuz oluşturur
    // daha önceden bir havuz oluşturulduysa o havuzu döndürür
    public static PoolManager createPool() {
        // singleton PoolManager
        if (poolManager == null) {
            poolManager = new PoolManager();
            System.out.println("pool manager oluşturuldu");
        }
        return poolManager;
    }

    public ConnectionContext takeConnection(String key) {
        // eğer pool bu key' i içeren bir kaydı tutuyorsa daha önceden bu key' e bir connection pool açılmış demektir
        if (pools.containsKey(key)) {
            // tüm keyleri al
            List<ConnectionContext> objects = pools.get(key);
            // bu keyler içerisinde mevcut keyi bul ve bu key' in connection havuzuna eriş
            for (ConnectionContext connectionContext : objects) {
                // eğer bu key' e ait havuzda, aktif olmayan bir connection varsa onu döndürüyoruz
                if (!connectionContext.isActive()) {
                    connectionContext.setActive(true);
                    return connectionContext;
                }
            }
        }
        // eğer pool bu key' i içeren bir kaydı tutmuyorsa daha önceden bu key' e connection pool açılmamış demektir
        else {
            // bu yüzden belirtilen değerde bir connection havuzu oluşturuyoruz
            // istemci gerektiği zaman bu connection' lardan kullanarak istediği işleri yapabilir
            List<ConnectionContext> newPool = new ArrayList<>(POOL_SIZE);
            for (int i = 0; i < POOL_SIZE; i++) {
                newPool.add(new ConnectionContext());
            }
            pools.put(key, newPool);

            ConnectionContext connectionContext = newPool.get(0);
            connectionContext.setActive(true);

            return connectionContext;
        }
        // uygun bir connection nesnesi yoksa null döndür
        return null;
    }

    // istemcinin işi bittiğinde connection nesnesinin aktiflik durumu false yapılır ve tekrar havuza döner
    public void releaseConnection(ConnectionContext connectionContext) {
        connectionContext.setActive(false);
    }
}
