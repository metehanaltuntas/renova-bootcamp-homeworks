package com.renova.egitim;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Metehan ALTUNTAŞ
 */

public class Main {
    private static Main main = new Main();
    // yapılabilecek işlemler
    private String[] actions = {"Çıkış", "Toplama", "Çıkarma", "Çarpma", "Bölme", "Mod Alma", "Hafızaya Al", "Hafızadakini Yazdır ve Temizle"};
    // yapılan son işlemin sonucu
    private static Double lastOperationResult;
    // kayıt edilen sonuç
    private static Double savedResult;
    // daha önceeden kayıt edilen bir değer var mı
    private boolean isThereAnyRecordedValue = false;
    // daha önceden yapılmış bir işlemin sonucu var mı
    private boolean isThereAnyResult = false;

    public static void main(String[] args) {
        main.createTheMenu();
    }

    // menu' nün oluşturulması
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
                    case 1: // toplama işlemi
                        printTheOperationName(actions[1]);
                        main.doAddition(main.getNumbers(actions[1]));
                        break;
                    case 2: // çıkarma işlemi
                        printTheOperationName(actions[2]);
                        main.doSubtraction(main.getNumbers(actions[2]));
                        break;
                    case 3: // çarpma işlemi
                        printTheOperationName(actions[3]);
                        main.doMultiplication(main.getNumbers(actions[3]));
                        break;
                    case 4: // bölme işemi
                        printTheOperationName(actions[4]);
                        main.doDivision(main.getNumbers(actions[4]));
                        break;
                    case 5: // mod alma işlemi
                        printTheOperationName(actions[5]);
                        System.err.println("UYARI! Mod alma işlemi sadece 2 sayı için yapılacak olup 2' den fazla sayı girilse bile bu sayılar işleme alınmayacaktır");
                        main.doModulo(main.getNumbers(actions[5]));
                        break;
                    case 6:
                        // hafızaya alma işlemi
                        printTheOperationName(actions[6]);
                        saveTheLastoperationResult();
                        break;
                    case 7:
                        // hafızadakini yazdırma ve temizleme işlemi
                        printTheOperationName(actions[7]);
                        printAndDeleteSavedValue();
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

    // toplama işlemi metodu
    private void doAddition(ArrayList<Double> numberArrayList) {
        printNumbersInArray(numberArrayList);
        double result = 0;
        for (Number number : numberArrayList) {
            result = result + number.doubleValue();
        }
        setLastOperationResult(result);
        System.out.println("İşlem sonucu = " + String.format("%,.3f", result));
    }

    // çıkarma işlemi metodu
    private void doSubtraction(ArrayList<Double> numberArrayList) {
        printNumbersInArray(numberArrayList);
        double result = 0;
        boolean isThisFirstNumber = true;
        for (Number number : numberArrayList) {
            // eğer ilk sayı işleme alınıyorsa önce bu sayıyı result' a eklemeliyiz ki diğer bütün sayılar bu sayıdan çıkartılsın
            if (isThisFirstNumber) {
                result = number.doubleValue();
                isThisFirstNumber = false;
            } else {
                result = result - number.doubleValue();
            }
        }
        setLastOperationResult(result);
        System.out.println("İşlem sonucu = " + String.format("%,.3f", result));
    }

    // çarpma işlemi metodu
    private void doMultiplication(ArrayList<Double> numberArrayList) {
        printNumbersInArray(numberArrayList);
        double result = 1;
        for (Number number : numberArrayList) {
            result = result * number.doubleValue();
        }
        setLastOperationResult(result);
        System.out.println("İşlem sonucu = " + String.format("%,.3f", result));
    }

    // bölme işlemi metodu
    private void doDivision(ArrayList<Double> numberArrayList) {
        printNumbersInArray(numberArrayList);
        double result = 0;
        boolean isThisFirstNumber = true;
        for (Number number : numberArrayList) {
            // eğer ilk sayı işleme alınıyorsa önce bu sayıyı result' a eklemeliyiz ki diğer bütün sayılar bu sayıya bölünsün
            if (isThisFirstNumber) {
                result = number.doubleValue();
                isThisFirstNumber = false;
            } else {
                result = result / number.doubleValue();
            }
        }
        setLastOperationResult(result);
        System.out.println("İşlem sonucu = " + String.format("%,.3f", result));
    }

    // mod alma metodu
    private void doModulo(ArrayList<Double> numberArrayList) {
        if (numberArrayList.size() > 2) {
            System.out.println("---------- 2' den fazla sayı mevcut. Sadece ilk iki sayı işleme alınacaktır. ----------");
        }
        // sadece iki sayıya mod işlemi uygulanacağından döngü 2 defa çalıştırılıp bitiyor
        double result = 0;
        byte control = 0;
        for (Number number : numberArrayList) {
            result = result % number.doubleValue();
            if (control == 1) {
                break;
            }
            control++;
        }
        setLastOperationResult(result);
        System.out.println("İşlem sonucu = " + String.format("%,.3f", result));
    }

    // yapılan son işlemi kayıt edilebilme ihtimaline karşı saklar
    private void setLastOperationResult(Double value) {
        isThereAnyResult = true;
        lastOperationResult = value;
    }

    // yapılacak herhangi bir işlem için girilen sayıların alınması
    private ArrayList<Double> getNumbers(String operationName) {
        System.out.println(operationName + " işlemi yapmak için lütfen en az 2 sayı giriniz:(işlemi tamamlamak için küçük x harfi giriniz)");
        ArrayList<Double> numberArrayList = new ArrayList<>();
        boolean flag = true;
        while (flag) {
            Scanner scanner = new Scanner(System.in);
            String nextLine = scanner.nextLine();

            // x girilirse sayıları işleme gönder
            if (nextLine.equals("x")) {
                if (numberArrayList.size() < 2) {
                    System.err.println("Lütfen en az 2 adet sayı giriniz!");
                } else {
                    flag = false;
                    System.out.println("Sayılar işleme gönderiliyor...");
                }
            } else if (nextLine.isEmpty()) {
                System.out.println("Lütfen boş değer girmeyin!");
            } else {
                numberArrayList.add(Double.parseDouble(nextLine));
                printNumbersInArray(numberArrayList);
            }
        }
        return numberArrayList;
    }

    // işleme alınan sayıların yazdırılması
    private void printNumbersInArray(ArrayList<Double> numberArrayList) {
        System.out.println("İşleme alınacak sayılar: " + numberArrayList);
    }

    // operasyon isminin yazdırılması
    private void printTheOperationName(String actionName) {
        System.out.println("------------------------- Şu an __" + actionName + " İşlemi__ yapıyorsunuz -------------------------");
    }

    // kayıt edilen değeri önce yazdırma sonra silme
    private void printAndDeleteSavedValue() {
        // daha önceden kayıt edilen bir değer var mı diye kontrol
        if (!isThereAnyRecordedValue) {
            System.out.println("Kayıt edilen herhangi bir değer bulunamadı!");
        } else {
            isThereAnyRecordedValue = false;
            System.out.println("Kayıt edilen değer: " + savedResult + "' dir.");
            System.out.println("Kayıt edilen değer başarıyla silindi.");
        }
    }

    // son operasyondaki işlemi kayıt etme
    private void saveTheLastoperationResult() {
        // herhangi bir operasyon yapılmış mı diye kontrol etme
        if (!isThereAnyResult) {
            System.out.println("Üzgünüm henüz herhangi bir işlem sonucu mevcut olmadığından bu işlemi gerçekleştiremezsiniz.");
        } else {
            savedResult = lastOperationResult;
            isThereAnyRecordedValue = true;
            System.out.println("Son çıktı [" + lastOperationResult + "] başarıyla kayıt edildi.");
        }
    }

    private void printSperator() {
        System.out.println("--------------------------------------------------------------------------------------------------------");
    }

}
