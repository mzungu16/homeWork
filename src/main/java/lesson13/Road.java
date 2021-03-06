package lesson13;

import java.util.HashMap;
import java.util.Map;

public class Road extends Stage {
    private static Map<String, Long> hashMap = new HashMap();
    private static int COUNTER = 0;

    public Road(int length) {
        this.length = length;
        this.description = "Дорога " + length + " метров";
    }

    public static int getCOUNTER() {
        return COUNTER;
    }

    public static Map<String, Long> getHashMap() {
        return hashMap;
    }

    public static void winner() {
        long min = 200000000000000L;
        String key = "";
        for (Map.Entry<String, Long> entry : hashMap.entrySet()) {
            if (min > entry.getValue()) {
                key = entry.getKey();
                min = entry.getValue();
            }
        }
        System.out.println(key + " - " + min + "mls -  WINNER");
    }

    @Override
    public void go(Car c) {
        try {
            System.out.println(c.getName() + " начал этап: " + description);
            Thread.sleep(length / c.getSpeed() * 1000);
            System.out.println(c.getName() + " закончил этап: " + description);
            if (this.length == 40) {
                hashMap.put(c.getName(), System.currentTimeMillis());
                COUNTER++;
            }
            if (COUNTER == Lesson13.CARS_COUNT) {
                Lesson13.threadEnd.start();
                Thread.sleep(500);
                Lesson13.threadPrint.start();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
