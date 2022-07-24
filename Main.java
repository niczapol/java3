package lesson1;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        GenericStorage<String> stringStorage = new GenericStorage<>();
        ArrayList<String> testArrayList = new ArrayList<>();

        stringStorage.add("apple");
        stringStorage.add("orange");
        stringStorage.add("bubble");
        stringStorage.add("pump");
        stringStorage.add("square");
        stringStorage.add("leg");
        System.out.println(stringStorage);

        stringStorage.swap(1, 4);
        System.out.println(stringStorage);

        testArrayList = stringStorage.toArrayList(testArrayList);
        System.out.println(testArrayList.toString());

        System.out.println();


        Apple apple = new Apple();
        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Apple apple3 = new Apple();

        Orange orange = new Orange();
        Orange orange1 = new Orange();
        Orange orange2 = new Orange();
        Orange orange3 = new Orange();

        Box<Apple> appleBox = new Box<>();
        Box<Orange> orangeBox = new Box<>();

        appleBox.add(apple);
        appleBox.add(apple1);
        appleBox.add(apple2);
        appleBox.add(apple3);

        orangeBox.add(orange);
        orangeBox.add(orange1);
        orangeBox.add(orange2);
        orangeBox.add(orange3);

        System.out.println(appleBox.getBoxWeight());
        System.out.println(orangeBox.getBoxWeight());

        System.out.println(appleBox.compare(orangeBox));

        Box<Apple> newAppleBox = new Box<>();
        appleBox.fruitTransfer(newAppleBox);
        System.out.println(appleBox.getBoxWeight());
        System.out.println(newAppleBox.getBoxWeight());


/*        appleBox.add(orange);
        appleBox.fruitTransfer(orangeBox);*/

    }
}
