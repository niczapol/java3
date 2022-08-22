package lesson1.lesson5;

import java.util.concurrent.CountDownLatch;

import static lesson1.lesson5.Main.CARS_COUNT;

public class CarsPreparation {

    private static CountDownLatch cdl;

    public static void preparation(Car car) throws InterruptedException {
        cdl = new CountDownLatch(CARS_COUNT);

        System.out.println(car.getName() + " готовится");
        try {
            Thread.sleep(500 + (int) (Math.random() * 800));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(car.getName() + " готов");
        cdl.countDown();
        cdl.await();
    }
}
