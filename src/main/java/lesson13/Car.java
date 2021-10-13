package lesson13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.CountDownLatch;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private static CountDownLatch countDownLatch = new CountDownLatch(Lesson13.CARS_COUNT);
    private static int WINNER;

    static {
        CARS_COUNT = 0;
    }

    private Race race;
    private int speed;
    private String name;
    private Road road;
    private ArrayList<Long> longArrayList = new ArrayList<>(Lesson13.CARS_COUNT);
    private ArrayList<String> stringArrayList = new ArrayList<>(Lesson13.CARS_COUNT);

    public ArrayList<Long> getLongArrayList() {
        return longArrayList;
    }

    public static int getWINNER() {
        return WINNER;
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
            while (countDownLatch.getCount() > 0) {
                Thread.sleep(2000);
                countDownLatch.countDown();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
            Road.getFinishMap();
        }
    }
}
