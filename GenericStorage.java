package lesson1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class GenericStorage<E> {
    private E[] data;
    private static final int DEFAULT_SIZE = 10;
    private int currentSize;

    public GenericStorage(int size) {
        this.data = (E[]) new Object[size];
        this.currentSize = 0;
    }

    public GenericStorage() {
        this.data = (E[]) new Object[DEFAULT_SIZE];
        this.currentSize = 0;
    }

    public void add(E value) {
        data[currentSize] = value;
        currentSize++;
    }

    public void swap(int firstIndex, int secondIndex) {
        Object o = data[firstIndex];
        data[firstIndex] = data[secondIndex];
        data[secondIndex] = (E) o;
    }

    public ArrayList<E> toArrayList(ArrayList<E> arrayList) {
        Collections.addAll(arrayList, data);
        return arrayList;
    }

    @Override
    public String toString() {
        return Arrays.toString(data);
    }
}
