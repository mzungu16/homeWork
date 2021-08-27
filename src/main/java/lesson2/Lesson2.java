package lesson2;

/*
1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].С помощью цикла и условия заменить 0 на 1, 1 на 0;
2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
4. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
5. *** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true, если в массиве есть место,
в котором сумма левой и правой части массива равны. Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
граница показана символами ||эти символы в массив не входят.
6. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным),
при этом метод должен сместить все элементы массива на n позиций. Элементы смещаются циклично.
Для усложнения задачи нельзя пользоваться вспомогательными массивами. Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1]
при n = -2 (на два влево) -> [ 6, 1, 3, 5 ]. При каком n в какую сторону сдвиг можете выбирать сами.
*/

import java.util.Arrays;

public class Lesson2 {
    public static void main(String[] args) {
        System.out.println("Выполнение 1-го задания");
        replacingArrayValues();
        System.out.println("Выполнение 2-го задания");
        fillArrayWithValues();
        System.out.println("Выполнение 3-го задания");
        loopThroughAndMultiply();
        System.out.println("Выполнение 4-го задания");
        minAndMaxElementsInArray();
        System.out.println("Выполнение 5-го задания");
        int [] arrayToCheck = {2, 2, 2, 1, 2, 2, 10, 1};
        checkBalance(arrayToCheck);
    }

    static void replacingArrayValues() {
        int[] intArrayForReplace = {1, 1, 0, 0, 1, 0};
        System.out.println(Arrays.toString(intArrayForReplace));
        for (int i = 0; i < intArrayForReplace.length; i++) {
            switch (intArrayForReplace[i]) {
                case 0 -> intArrayForReplace[i] = 1;
                case 1 -> intArrayForReplace[i] = 0;
            }
        }
        System.out.println(Arrays.toString(intArrayForReplace));
    }

    static void fillArrayWithValues() {
        // int c = 0;
        int[] intArrayForFill = new int[8];
        System.out.println(Arrays.toString(intArrayForFill));
        for (int i = 1; i < intArrayForFill.length; i++) {
            /*c+=3;
            intArrayForFill[i] = c;*/
            intArrayForFill[i] = intArrayForFill[i - 1] + 3;
        }
        System.out.println(Arrays.toString(intArrayForFill));
    }

    static void loopThroughAndMultiply() {
        int[] intArrayForLoop = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(intArrayForLoop));
        for (int i = 0; i < intArrayForLoop.length; i++) {
            if (intArrayForLoop[i] < 6) intArrayForLoop[i] *= 2;
        }
        System.out.println(Arrays.toString(intArrayForLoop));
    }

    static void minAndMaxElementsInArray() {
        int[] intArrayMinMax = {1, 5, 55, 2, 55, 12};
        int max = intArrayMinMax[0];
        int min = intArrayMinMax[2];
        System.out.println(Arrays.toString(intArrayMinMax));
        for (int i = 0; i < intArrayMinMax.length; i++) {
            if (intArrayMinMax[i] > max) max = intArrayMinMax[i];
            if (intArrayMinMax[i] < min) min = intArrayMinMax[i];
        }
        System.out.println("Max element - " + max + " Min element - " + min);
    }

    static boolean checkBalance (int[] arrayToCheck){
        for (int i = 0;i<arrayToCheck.length;i++){

        }
        return false;
    }
}
