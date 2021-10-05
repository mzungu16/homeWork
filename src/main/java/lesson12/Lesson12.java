package lesson12;

import java.util.Arrays;

public class Lesson12 {
    static final int SIZE_OF_ARRAY = 100_000;

    public static void main(String[] args) {
        calculateValueWithOutThreads();
        calculateValueWithThreads();
    }

    private static void calculateValueWithThreads() {
        float[] myArray1 = new float[SIZE_OF_ARRAY];
        Arrays.fill(myArray1, 1f);
        float[] myArray2 = new float[SIZE_OF_ARRAY / 2];
        System.arraycopy(myArray1, 0, myArray2, 0, SIZE_OF_ARRAY / 2);
        float[] myArray3 = new float[SIZE_OF_ARRAY / 2];
        System.arraycopy(myArray1, SIZE_OF_ARRAY / 2, myArray3, 0, SIZE_OF_ARRAY / 2);
        long timeOfBegin1 = System.currentTimeMillis();
        new Thread(() -> calculate(myArray2)).start();
        new Thread(() -> calculate(myArray3)).start();
        System.arraycopy(myArray2, 0, myArray1, 0, myArray2.length);
        System.arraycopy(myArray3, 0, myArray1, myArray2.length, myArray3.length);
        System.out.println(System.currentTimeMillis() - timeOfBegin1);
    }

    private static void calculate(float[] myArray) {
        for (int i = 0; i < SIZE_OF_ARRAY / 2; i++) {
            myArray[i] = (float) (myArray[i] * Math.sin(0.2f + (i / 5)) * Math.cos(0.2f + (i / 5)) * Math.cos(0.4f + (i / 2)));
        }
    }

    private static void calculateValueWithOutThreads() {
        float[] myArray = new float[SIZE_OF_ARRAY];
        Arrays.fill(myArray, 1f);
        long timeOfBegin = System.currentTimeMillis();
        for (int i = 0; i < SIZE_OF_ARRAY; i++) {
            myArray[i] = (float) (myArray[i] * Math.sin(0.2f + (i / 5)) * Math.cos(0.2f + (i / 5)) * Math.cos(0.4f + (i / 2)));
        }
        System.out.println(System.currentTimeMillis() - timeOfBegin);
    }
}
