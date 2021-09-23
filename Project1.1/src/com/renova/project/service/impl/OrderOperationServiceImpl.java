package com.renova.project.service.impl;

import com.renova.project.model.Customer;
import com.renova.project.model.Order;
import com.renova.project.model.OrderItem;
import com.renova.project.model.Product;
import com.renova.project.service.CustomerOperationService;
import com.renova.project.service.OrderOperationService;
import com.renova.project.service.ProductOperationService;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class OrderOperationServiceImpl implements OrderOperationService {
    private ArrayList<OrderItem> orderItemArrayList = new ArrayList<>();
    private static Customer theCustomerWhoWillPlaceTheOrder = new Customer();
    private static final ArrayList<Order> orderArrayList = new ArrayList<>();
    private final ProductOperationService productOperationService = new ProductOperationServiceImpl();
    private final CustomerOperationService customerOperationService = new CustomerOperationServiceImpl();
    private static int orderID = 1;

    // sipariş işlemi için kullanıcının müşteri seçmesini sağlar
    @Override
    public void selectUserForOrder() {
        System.out.println("- Sipariş verme işlemi için öncelikle aşağıdaki listeden kullanıcı seçimi yapınız. Siparişi hangi kullanıcı verecek? " +
                "Lütfen kullanıcı ID' sini seçiniz:");
        customerOperationService.listCustomers();
        Scanner input = new Scanner(System.in);
        String nextLine = input.nextLine();
        try {
            if (nextLine.isEmpty()) {
                System.out.println("- Lütfen boş değer girmeyin!");
            } else {
                theCustomerWhoWillPlaceTheOrder = customerOperationService.getCustomerArrayList().get(Integer.parseInt(nextLine) - 1);
                getProductsToOrder();
            }
        } catch (Exception e) {
            System.out.println("- Size tanınan seçeneklerden başka işlem yapmayınız!");
        }
    }

    // sipariş verilmek istenen ürünleri seçtirir daha sonra ise miktar seçtirir
    @Override
    public void getProductsToOrder() {
        System.out.println("- Lütfen aşağıda listelenen ürünlerden almak istediğiniz ürünün/ürünlerin teker teker ID' sini giriniz:");
        productOperationService.listProducts();
        System.out.println("- ÜRÜN SEÇİMİNİZ BİTTİĞİNDE SEÇTİĞİNİZ ÜRÜNLERİ BİR SONRAKİ AŞAMAYA GEÇMEK İÇİN x YAZINIZ");
        System.out.println("- ÜRÜN SEÇMEDEN ÇIKMAK İÇİN y YAZINIZ");
        ArrayList<Product> productArrayList = new ArrayList<>();
        boolean flag = true;
        while (flag) {
            Scanner selectedProduct = new Scanner(System.in);
            String nextLine = selectedProduct.nextLine();

            try {
                if (nextLine.equals("x")) {
                    if (!productArrayList.isEmpty()) {
                        flag = false;
                        System.out.println("- Ürün seçiminiz bitti. Ürün miktarı girme işlemi için yönlendiriliyorsunuz... \n");
                        getOrderQuantities(productArrayList);
                    } else {
                        System.out.println("- DEVAM ETMEDEN ÖNCE LÜTFEN EN AZ 1 ÜRÜN EKLEYİNİZ!");
                    }
                } else if (nextLine.equals("y")) {
                    flag = false;
                    System.out.println("- Herhangi bir ürün seçilmeden işlem sonlandırıldı...");
                } else if (nextLine.isEmpty()) {
                    System.out.println("- Lütfen boş değer girmeyin!");
                } else {
                    boolean isPreselected = productOperationService.isThisProductPreselected(productArrayList, Integer.parseInt(nextLine));
                    if (isPreselected) {
                        System.out.println("- Bu ürünü zaten eklediniz. Lütfen eklemediğiniz ürünleri ekleyin veya adet girme aşamasına geçin");
                    } else {
                        productArrayList.add(this.productOperationService.getProductArrayList().get(Integer.parseInt(nextLine) - 1));
                        productOperationService.printProductsInArray(productArrayList);
                    }
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("- Lütfen listedeki ürünlerin ID' lerinden seçiniz!");
            } catch (Exception e) {
                System.out.println("- Size tanınan seçeneklerden başka işlem yapmayınız!");
            }
        }
    }

    // sipariş verilmek için seçilen ürünlerin miktarlarının girilmesi
    @Override
    public void getOrderQuantities(ArrayList<Product> productArrayList) {
        System.out.println("- Lütfen seçtiğiniz ürünlerin satın alma miktarlarını giriniz. Seçtiğiniz ürünler sırayla listelenecektir...");
        Scanner input;
        OrderItem orderItem;
        for (int i = 0; i < productArrayList.size(); i++) {
            System.out.println("- " + productArrayList.get(i).getName() + " adlı üründen kaç adet almak istiyorsunuz? Lütfen bir değer giriniz:");
            input = new Scanner(System.in);
            String nextLine = input.nextLine();
            try {
                // x girilirse sayıları işleme gönder
                if (nextLine.isEmpty()) {
                    System.out.println("- Lütfen boş değer girmeyin!");
                } else {
                    orderItem = new OrderItem((i + 1), productArrayList.get(i), Integer.parseInt(nextLine));
                    orderItemArrayList.add(orderItem);
                    System.out.println("- " + productArrayList.get(i).getName() + " adlı ürün siparişe hazır!");
                }
            } catch (Exception e) {
                System.out.println("- Size tanınan seçeneklerden başka işlem yapmayınız!");
                i--;
            }
        }
        System.out.println("- Tüm ürünler siparişe hazır. Aşağıda özet bilgiyi görüntüleyebilir ve siparişi tamamlayabilirsiniz.");
        completeTheOrder();
    }

    // siparişi tamamlayıp kayıt eder
    @Override
    public void completeTheOrder() {
        System.out.println("- SİPARİŞİ VERECEK OLAN KULLANICI: " + theCustomerWhoWillPlaceTheOrder.getName());
        Order order = new Order();
        double orderTotal = 0;
        for (OrderItem orderItem : orderItemArrayList) {
            orderTotal = orderTotal + calculateTheOrderTotal(orderItem);
            order.addOrderItem(orderItem);
        }
        order.setId(orderID);
        order.setOrderDate(new Date());
        order.setCustomer(theCustomerWhoWillPlaceTheOrder);
        order.setOrderItems(new ArrayList<>(orderItemArrayList));
        order.setOrderTotal(orderTotal);
        orderArrayList.add(order);
        orderID++;
        orderItemArrayList.clear();
        System.out.println("- Sipariş toplam fiyatı: " + order.getOrderTotal());
    }

    // sipariş toplamını hesaplar
    @Override
    public double calculateTheOrderTotal(OrderItem orderItem) {
        double orderItemTotal = 0;
        orderItemTotal = orderItemTotal + orderItem.getQuantity() * orderItem.getUnitPrice();
        return orderItemTotal;
    }

    // sipariş veren son müşterinin tüm siparişlerini yazdırır
    @Override
    public void printTheOrdersOfTheLastCustomerWhoPlacedAnOrdee() {
        double sumOfAllOrders = 0;
        if (orderArrayList.isEmpty()) {
            System.out.println("                    ÜZGÜNÜM HENÜZ BİR SİPARİŞ YOK                   ");
        } else {
            boolean isOrderPrintFirstTime;
            int orderCount = 1;
            for (Order order : orderArrayList) {
                isOrderPrintFirstTime = true;
                boolean customerControl = order.getCustomer().getId() == theCustomerWhoWillPlaceTheOrder.getId();
                if (customerControl) {
                    if (isOrderPrintFirstTime) {
                        System.out.println("\n                    " + order.getCustomer().getName() + " ADLI MÜŞTERİNİN " + orderCount + ". SİPARİŞİ                    ");
                        System.out.println("- Siparişi veren kullanıcı: " + order.getCustomer().getName() +
                                " ve sipariş detayları şu şekildedir: \n" + order);
                    }
                    System.out.println("\n- Sipariş içerisindeki ürünler:");
                    for (int i = 0; i < order.getOrderItems().size(); i++) {
                        System.out.println("Order ID: " + order.getId() + " " + order.getOrderItems().get(i).toString());
                    }
                    sumOfAllOrders = sumOfAllOrders + order.getOrderTotal();
                }
                if (customerControl) {
                    System.out.println("                                " + orderCount + ". SİPARİŞİN SONU                    \n");
                    System.out.println("- Müşterinin verdiği bütün siparişlerin toplamı: " + sumOfAllOrders + "' dır.");
                    orderCount++;
                }
            }
            isOrderPrintFirstTime = false;
        }
    }

    // bu zamana kadar verilmiş tüm siparişleri listeler
    @Override
    public void printAllOrdersAndDetails() {
        double sumOfAllOrders = 0;
        if (orderArrayList.isEmpty()) {
            System.out.println("                    ÜZGÜNÜM HENÜZ BİR SİPARİŞ YOK                   ");
        } else {
            int orderCount = 1;
            for (Order order : orderArrayList) {
                System.out.println("\n                                      " + orderCount + ". SİPARİŞ                    ");
                System.out.println("\n- Siparişi veren kullanıcı: " + order.getCustomer().getName() +
                        " ve sipariş detayları şu şekildedir: \n" + order);
                System.out.println("- Sipariş içerisindeki ürünler:");
                for (int i = 0; i < order.getOrderItems().size(); i++) {
                    System.out.println("Order ID: " + order.getId() + " " + order.getOrderItems().get(i).toString());
                }
                sumOfAllOrders = sumOfAllOrders + order.getOrderTotal();
                System.out.println("                                    " + orderCount + ". SİPARİŞİN SONU                    \n");
                orderCount++;
            }
            System.out.println("- Bu zamana kadar verilen bütün siparişlerin toplamı: " + sumOfAllOrders + "' dır.");
        }
    }

}
