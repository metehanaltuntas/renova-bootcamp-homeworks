package com.renova.project;

import com.renova.project.service.CustomerOperationService;
import com.renova.project.service.OrderOperationService;
import com.renova.project.service.ProductOperationService;
import com.renova.project.service.impl.CustomerOperationServiceImpl;
import com.renova.project.service.impl.OrderOperationServiceImpl;
import com.renova.project.service.impl.ProductOperationServiceImpl;

import java.util.Scanner;

/**
 * @author Metehan ALTUNTAŞ
 */

/**
 * Projedeki bug' lar giderildi. Zaman yetişmediğinden projeye bir arayüz yazılamadı.
 */
public class Test {
    private static Test test = new Test();
    private final OrderOperationService orderOperationService = new OrderOperationServiceImpl();
    private final ProductOperationService productOperationService = new ProductOperationServiceImpl();
    private final CustomerOperationService customerOperationService = new CustomerOperationServiceImpl();

    private String[] actions = {"Çıkış", "Ürünleri Listele", "Sipariş Ver", "Sipariş Veren Son Müşterinin Siparişlerini Listele","Kayıtlı Tüm Siparişleri Listele"};

    public static void main(String[] args) {
        test.create();
        test.createTheMenu();
    }

    // birkaç hazır kullanıcı ve ürün girilmesi
    private void create() {
        productOperationService.createSomeProduct();
        customerOperationService.createSomeCustomer();
    }

    // menünün oluşturulması
    private void createTheMenu() {
        boolean status = true;
        Scanner input = new Scanner(System.in);
        while (status) {
            printOperations();
            System.out.println("Lütfen yapmak istediğiniz işlemi seçiniz:");
            String answer = input.nextLine();
            // boş değer girilmesi ihtimaline karşı
            if (answer.isEmpty()) {
                System.out.println("Lütfen boş değer girmeyin!");
            } else {
                int convertedAnswer = Integer.parseInt(answer);
                switch (convertedAnswer) {
                    case 0:
                        System.out.println("Çıkış yapılıyor...");
                        status = false;
                        break;
                    case 1: // tüm ürünleri listeler
                        printTheOperationName(actions[1]);
                        productOperationService.listProducts();
                        break;
                    case 2: // sipariş işlemi için kullanıcı seçtirir. sipariş işlemi için ilk adımı başlatır
                        printTheOperationName(actions[2]);
                        orderOperationService.selectUserForOrder();
                        break;
                    case 3: // sipariş veren son kullanıcının tüm siparişlerini yazdırır
                        printTheOperationName(actions[3]);
                        orderOperationService.printTheOrdersOfTheLastCustomerWhoPlacedAnOrdee();
                        break;
                    case 4: // bu zamana kadar verilmiş tüm siparişleri yazdırır
                        printTheOperationName(actions[4]);
                        orderOperationService.printAllOrdersAndDetails();
                        break;
                    default:
                        System.out.println("Lütfen geçerli bir işlem seçiniz!");
                }
            }
            printSperator();
        }
    }

    // program içerisinde yapılabilecek işlemleri listeler
    private void printOperations() {
        int code = 0;
        for (String action : actions) {
            System.out.println("[" + code + "] " + action);
            code++;
        }
    }

    // operasyon isminin yazdırılması
    private void printTheOperationName(String actionName) {
        System.out.println("__________________________________________________________________ " +
                "" + actionName + "" +
                " ________________________________________________________________________");
    }

    private void printSperator() {
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");
    }
}
