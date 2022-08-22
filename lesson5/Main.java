package lesson1.lesson5;

import java.util.concurrent.*;

public class Main {
    public static final int CARS_COUNT = 4;
    public static Semaphore semaphore;
    public static CountDownLatch cdl;
    private static ExecutorService service;
    private static int i = 0;

    public static void main(String[] args) {
        semaphore = new Semaphore(CARS_COUNT / 2);
        cdl = new CountDownLatch(CARS_COUNT);
        service = Executors.newFixedThreadPool(CARS_COUNT);

        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];

        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }

        System.out.println("ÂÀÆÍÎÅ ÎÁÚßÂËÅÍÈÅ >>> Ïîäãîòîâêà!!!");

        for (Car car : cars) {
            service.execute(() -> {
                try {
                    CarsPreparation.preparation(car);
                    startNotification();
                    car.run();
                    winnerNotification(car);
                    cdl.countDown();
                    cdl.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                endNotification();
            });
        }
        service.shutdown();
    }

    public static synchronized void startNotification() {
        if (i == 0) {
            i++;
            System.out.println("ÂÀÆÍÎÅ ÎÁÚßÂËÅÍÈÅ >>> Ãîíêà íà÷àëàñü!!!");
        }
    }

    public static synchronized void winnerNotification(Car car) {
        if (i == 1) {
            i++;
            System.out.println(car.getName() + " - WIN!!!");
        }
    }

    public static synchronized void endNotification() {
        if (i == 2) {
            i++;
            System.out.println("ÂÀÆÍÎÅ ÎÁÚßÂËÅÍÈÅ >>> Ãîíêà çàêîí÷èëàñü!!!");
        }
    }
}