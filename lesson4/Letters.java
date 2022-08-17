package lesson1.lesson4;

public class Letters {

    public synchronized void printLetterA() {
        System.out.print("A");

        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        notify();
    }

    public synchronized void PrintLetterB() {
        System.out.print("B");

        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        notify();
    }

    public synchronized void printLetterC() {
        System.out.print("C ");

        notify();

        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
