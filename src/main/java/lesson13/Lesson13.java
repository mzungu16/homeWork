package lesson13;

import java.util.Collections;
import java.util.Map;

public class Lesson13 {
    public static final int CARS_COUNT = 4;
    public static Thread threadPrint = new Thread(Lesson13::printResult);
    public static Thread threadEnd = new Thread(Lesson13::endMessage);


    public static void main(String[] args) throws InterruptedException {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }
        Thread threadStart = new Thread(Lesson13::startMessage);
        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }
        Thread.sleep(2000);
        threadStart.start();
    }

    private static void printResult() {
        System.out.println(Road.getHashMap());
        Road.winner();
    }

    private static void endMessage() {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }

    private static void startMessage() {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
    }
}