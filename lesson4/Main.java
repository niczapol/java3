package lesson1.lesson4;

public class Main {

    public static void main(String[] args) {
        Letters letters = new Letters();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                letters.printLetterA();
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                letters.PrintLetterB();
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                letters.printLetterC();
            }
        }).start();
    }
}
