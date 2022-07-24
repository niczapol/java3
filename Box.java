package lesson1;

import java.util.ArrayList;

public class Box<E extends Fruit> {
    private final ArrayList<E> box;
    private int currentCapacity;

    public Box() {
        this.box = new ArrayList<>(10);
        currentCapacity = 0;
    }

    public Box(int capacity) {
        this.box = new ArrayList<>(capacity);
    }

    public void add(E value) {
        box.add(currentCapacity, value);
        currentCapacity++;
    }

    public float getBoxWeight() {
        float boxWeight = 0;
        for (E e : box) {
            boxWeight += e.GetWeight();
        }
        return boxWeight;
    }

    public boolean compare(Box box) {

        return this.getBoxWeight() == box.getBoxWeight();
    }

    public void fruitTransfer(Box<E> box) {
        for (E e : this.box) {
            box.add(e);
        }
        this.box.clear();
        currentCapacity = 0;
    }

}
