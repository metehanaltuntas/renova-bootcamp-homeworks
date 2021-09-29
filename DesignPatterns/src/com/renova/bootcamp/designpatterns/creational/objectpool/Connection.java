package com.renova.bootcamp.designpatterns.creational.objectpool;

public class Connection {
    private String connectionString;
    private PoolManager poolManager;
    private ConnectionContext connectionContext;

    public String getConnectionString() {
        return connectionString;
    }

    public void setConnectionString(String connectionString) {
        this.connectionString = connectionString;
    }

    public Connection(String connectionString) {
        this.connectionString = connectionString;
    }

    public void open() {
        poolManager = PoolManager.createPool();
        // poolManager' dan bir connection nesnesi istenecek
        connectionContext = poolManager.takeConnection(this.connectionString);
        // uygun bir connection nesnesi varsa bunu kullan
        if (connectionContext != null) {
            connectionContext.open();
        }
        // yoksa hata mesajı göster
        else {
            System.out.println("Connection açılamadı. Havuzda hiç uygun nesne yok.");
        }
    }

    public void close() {
        poolManager.releaseConnection(connectionContext);
        connectionContext.close();
    }

    public void execute(String query) {
        connectionContext.execute(query);
    }
}
