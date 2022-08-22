package lesson1.lesson5;

import static lesson1.lesson5.Main.semaphore;

public class Tunnel extends Stage {

    public Tunnel() {
        this.length = 80;
        this.description = "������� " + length + " ������";
    }

    @Override
    public void go(Car c) {

        try {
            try {
                System.out.println(c.getName() + " ��������� � �����(����): " + description);
                semaphore.acquire(1);
                System.out.println(c.getName() + " ����� ����: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " �������� ����: " + description);
                semaphore.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
