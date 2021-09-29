package com.renova.bootcamp.designpatterns.creational.objectpool;

public class ConnectionContext {
    // nesnenin kullanılıp kullanılmadığı bilgisini tutar
    private boolean isActive;

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    // connection context nesnesi yaratılır ve henüz kullanılmadığından aktifliği false olarak atanır
    public ConnectionContext() {
        this.isActive = false;
        System.out.println("ConnectionContext yaratıldı");
    }

    public void open() {
        System.out.println("Connection açıldı");
    }

    public void close() {
        System.out.println("Connection kapatıldı");
    }

    public void execute(String query) {
        System.out.println(query + " çalıştı");
    }
}
