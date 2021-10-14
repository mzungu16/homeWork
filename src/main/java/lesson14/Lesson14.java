package lesson14;

import java.util.*;

/*
 * 1. Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив.
 *  Метод должен вернуть новый массив, который получен путем вытаскивания из исходного массива элементов, идущих после последней четверки.
 *  Входной массив должен содержать хотя бы одну четверку, иначе в методе необходимо выбросить RuntimeException.
 *  Написать набор тестов для этого метода (по 3-4 варианта входных данных). Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].
 * 2. Написать метод, который проверяет состав массива из чисел 1 и 4.
 *  Если в нем нет хоть одной четверки или единицы, то метод вернет false;
 *  Написать набор тестов для этого метода (по 3-4 варианта входных данных).
 * [ 1 1 1 4 4 1 4 4 ] -> true [ 1 1 1 1 1 1 ] -> false [ 4 4 4 4 ] -> false [ 1 4 4 1 1 4 3 ] -> false
 * */
public class Lesson14 {
    public static void main(String[] args) {
        int[] intArray = {1, 3, 4, 5, 6, 1, 3, 4, 5, 5, 6};
        System.out.println(Arrays.toString(intArray));
        System.out.println(Arrays.toString(getNewArray(intArray)));

        Random random = new Random();
        int[] arrayWithTwoAndFour = {1, 4};
        int[] arrayNewForTask2 = new int[5];
        for (int i = 0; i < arrayNewForTask2.length; i++) {
            arrayNewForTask2[i] = arrayWithTwoAndFour[random.nextInt(2)];
        }
        System.out.println(Arrays.toString(arrayNewForTask2));
        System.out.println(checkArray(arrayNewForTask2));
    }


    public static int[] getNewArray(int[] intArray) {
        List<Integer> arrayList = new ArrayList<>();
        if (checkArrayForNeedValue(intArray)) {
            for (int i = intArray.length - 1; i >= 0; i--) {
                if (intArray[i] != 4) {
                    arrayList.add(intArray[i]);
                } else {
                    break;
                }
            }
            Collections.reverse(arrayList);
            int[] newArray = new int[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                newArray[i] = arrayList.get(i);
            }
            return newArray;
        } else {
            throw new RuntimeException("Can't find value - 4 in Array ");
        }

    }

    private static boolean checkArrayForNeedValue(int[] intArray) {
        for (int j : intArray) {
            if (j == 4) return true;
        }
        return false;
    }

    public static boolean checkArray(int[] intArray) {
        List<Integer> integerList = new ArrayList<>();
        for (int j : intArray) {
            integerList.add(j);
        }
        return integerList.contains(4) && integerList.contains(1);
    }
}
