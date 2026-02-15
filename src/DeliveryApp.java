import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static List<Parcel> allParcels = new ArrayList<>();
    private static List<Parcel> allTrackingParcels = new ArrayList<>();


    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addParcel();
                    break;
                case 2:
                    sendParcels();
                    break;
                case 3:
                    calculateCosts();
                    break;
                case 4:
                    reportStatus();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 — Добавить посылку");
        System.out.println("2 — Отправить все посылки");
        System.out.println("3 — Посчитать стоимость доставки");
        System.out.println("4 — Показать список с трекингом?");
        System.out.println("0 — Завершить");
    }

    private static void typeOrdewrMenu() {
        System.out.println("Какой тип посылки вы хотите собрать?");
        System.out.println("1 — Стандарт");
        System.out.println("2 — Хрупкие предметы");
        System.out.println("3 — Скоропортящиеся продукты");
        System.out.println("0 или любая другая клавиша - Вернуться ");
    }



    // реализуйте методы ниже

    private static void addParcel() {
        //выбор типа
        typeOrdewrMenu();
        int choice = Integer.parseInt(scanner.nextLine());
        if(choice == 0 || choice >3){
            System.out.println("Вы вышли в главное меню.");

            return;
        }
        //заполнение
        System.out.println("Краткое описание:");
        String description = scanner.nextLine();
        System.out.println("Вес, целое число:");
        int weight = Integer.parseInt(scanner.nextLine());
        System.out.println("Адрес места назначения посылки в виде строки:");
        String deliveryAddress = scanner.nextLine();
        System.out.println("День месяца, в который посылка была отправлена:");
        int sendDay = Integer.parseInt(scanner.nextLine());

        Parcel newParcel;

        switch (choice) {
            case 1 -> {
                newParcel = new StandardParcel(
                        description, weight,
                        deliveryAddress, sendDay);
                allParcels.add(newParcel);
            }
            case 2 -> {
                newParcel = new FragileParcel(
                        description, weight,
                        deliveryAddress, sendDay);
                allParcels.add(newParcel);
                allTrackingParcels.add(newParcel);
            }

            case 3 -> {
                System.out.println("Срок годности в днях:");
                int timeToLive = Integer.parseInt(scanner.nextLine());
                newParcel = new PerishableParcel(
                        description, weight,
                        deliveryAddress, sendDay,
                        timeToLive);
                allParcels.add(newParcel);

            }

        }
        // Подсказка: спросите тип посылки и необходимые поля, создайте объект и добавьте в allParcels

    }


    private static  void sendParcels() {
       for(Parcel parcel : allParcels) {
           parcel.packageItem();
           parcel.deliver();
       }
        // Пройти по allParcels, вызвать packageItem() и deliver()
    }

    private static void calculateCosts() {
        int sum = 0;
        // Посчитать общую стоимость всех доставок и вывести на экран
        for(Parcel parcel : allParcels) {
            sum = sum + parcel.calculateDeliveryCost();
        }
    }
    private static void reportStatus() {
        for(Parcel parcel : allTrackingParcels) {
            System.out.println("Введите текущее местоположение для посылки " + parcel.getTrackNumber() + "':");
            FragileParcel fragileParcel = (FragileParcel) parcel;
            String newLocation = scanner.nextLine();
            fragileParcel.reportStatus(newLocation);

        }

    }
}
