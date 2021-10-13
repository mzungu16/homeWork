package lesson13;

import java.util.Collections;
import java.util.Map;

public class Lesson13 {
    public static final int CARS_COUNT = 4;
    public static int COUNTER = 4;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        Car car = null;
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
            car = cars[0];
        }
        Thread threadStart = new Thread(Lesson13::startMessage), threadEnd = new Thread(Lesson13::endMessage);
        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
            COUNTER++;
        }
        Thread.sleep(2000);
        threadStart.start();
        Thread.sleep(10000);
        System.out.println(Road.getFinishMap());
        Road.winner();
        Thread.sleep(2000);
        threadEnd.start();
    }

    private static void endMessage() {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }

    private static void startMessage() {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
    }
}