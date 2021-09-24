package lesson9;

/*
 * 1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4.
 * При подаче массива другого размера необходимо бросить исключение MyArraySizeException.
 * 2. Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать.
 * Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
 * должно быть брошено исключение MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.
 *  3. В методе main() вызвать полученный метод, обработать возможные исключения MyArraySizeException и MyArrayDataException и вывести результат расчета.
 * */

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lesson9 {
    static Scanner SCANNER = new Scanner(System.in);
    static Random RANDOM = new Random();
    static int SUMMER = 0;
    static final int CONSTANT_SIZE = 4;
    static String ELEMENT_TO_REMEMBER;

    public static void main(String[] args) {
        System.out.println("Enter array size- ");
        int inputSize = SCANNER.nextInt();
        String[][] arrayToCheck = new String[CONSTANT_SIZE][CONSTANT_SIZE];
        checkMethod(arrayToCheck, inputSize);
    }

    private static void checkMethod(String[][] arrayToCheck, int inputSize) {
        try {
            fillArrayWithStrings(arrayToCheck, inputSize);
            System.out.println(fromStringToIntMethod(arrayToCheck, inputSize));
        } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            throw new MyArraySizeException("Array not 4X4");
        } catch (NumberFormatException numberFormatException) {
            throw new MyArrayDataException("Can't parseInt '" + ELEMENT_TO_REMEMBER + "' / " + +SUMMER + " - your total sum");
        }
    }

    private static int fromStringToIntMethod(String[][] arrayToCheck, int inputSize) {
        int[][] newArrayOfInts = new int[CONSTANT_SIZE][CONSTANT_SIZE];
        for (int i = 0; i < inputSize; i++) {
            for (int j = 0; j < inputSize; j++) {
                ELEMENT_TO_REMEMBER = arrayToCheck[i][j];
                newArrayOfInts[i][j] = Integer.parseInt(arrayToCheck[i][j]);
                SUMMER += newArrayOfInts[i][j];
            }
        }
        return SUMMER;
    }

    private static void fillArrayWithStrings(String[][] arrayToCheck, int inputSize) {
        String[] strings = {"5", "7", "test", "45", "8", "6+8", "1", "34", "1", "3", "9"};
        for (int i = 0; i < inputSize; i++) {
            for (int j = 0; j < inputSize; j++) {
                arrayToCheck[i][j] = strings[RANDOM.nextInt(11)];
            }
        }
        System.out.println(Arrays.deepToString(arrayToCheck));
    }
}
