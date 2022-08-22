package lesson1.lesson5;

public class Car implements Runnable {
    private static int CARS_COUNT;

    static {
        CARS_COUNT = 0;
    }

    private Race race;
    private int speed;
    private String name;

    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "�������� #" + CARS_COUNT;
    }

    @Override
    public void run() {
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
    }

    public int getSpeed() {
        return speed;
    }

    public String getName() {
        return name;
    }
}
