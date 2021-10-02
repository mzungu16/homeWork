package lesson11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Lesson11 {
    static Random RANDOM = new Random();

    public static void main(String[] args) {
        Integer [] intArray = {1, 34, 5, 23};
        int firstIndex = RANDOM.nextInt(intArray.length), secondIndex = RANDOM.nextInt(intArray.length);
        swapElements(intArray, firstIndex, secondIndex);
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(intArray));
        System.out.println(arrayList);
    }

    private static void swapElements(Integer[] intArray, int firstIndex, int secondIndex) {
        System.out.println(Arrays.toString(intArray));
        int temp = intArray[firstIndex];
        intArray[firstIndex] = intArray[secondIndex];
        intArray[secondIndex] = temp;
        System.out.println(Arrays.toString(intArray));
    }
}
