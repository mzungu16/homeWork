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
Для усложнения задачи нельзя пользоваться вспомогательными массивами. Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ];
[ 3, 5, 6, 1]при n = -2 (на два влево) -> [ 6, 1, 3, 5 ]. При каком n в какую сторону сдвиг, можете выбирать сами.
*/

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.abs;

public class Lesson2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выполнение 1-го задания");
        replacingArrayValues(); //метод для выполнения 1-го задания
        System.out.println("Выполнение 2-го задания");
        fillArrayWithValues(); //метод для выполнения 2-го задания
        System.out.println("Выполнение 3-го задания");
        loopThroughAndMultiply(); //метод для выполнения 3-го задания
        System.out.println("Выполнение 4-го задания");
        minAndMaxElementsInArray(); //метод для выполнения 4-го задания
        System.out.println("Выполнение 5-го задания");
        int[] arrayToCheck = {2, 6, 2, 2, 2, 10, 4};
        System.out.println(checkBalance(arrayToCheck)); //метод для выполнения 5-го задания
        double[] arrayToMove = {3, 9, 6, 2, 7};
        int n, sizeOfArray = arrayToMove.length - 1;
        while (true) { //цикл для проверки введенного числа n
            System.out.println("Введите число n");
            n = scanner.nextInt();
            if (abs(n) > sizeOfArray || n == 0) {
                System.out.println("Введите n от -" + sizeOfArray + " до " + sizeOfArray);
            } else {
                break;
            }
        }
        System.out.println("n = " + n);
        System.out.println(Arrays.toString(arrayToMove));
        moveArray(arrayToMove, n); //метод для выполнения 6-го задания
    }

    //метод, который выводит в консоль массив с измененными значениями(1->0;0->1)
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

    //метод, который выводит в консоль, массив, заполненный значениями в цикле с определенной закономерностью
    static void fillArrayWithValues() {
        int[] intArrayForFill = new int[8];
        System.out.println(Arrays.toString(intArrayForFill));
        for (int i = 1; i < intArrayForFill.length; i++) {
            intArrayForFill[i] = intArrayForFill[i - 1] + 3;
        }
        System.out.println(Arrays.toString(intArrayForFill));
    }

    //метод, который проверят все элементы массива(<6) если да то умножает данный элемент на два, после чего выводит в консоль измененный массив
    static void loopThroughAndMultiply() {
        int[] intArrayForLoop = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(intArrayForLoop));
        for (int i = 0; i < intArrayForLoop.length; i++) {
            if (intArrayForLoop[i] < 6) intArrayForLoop[i] *= 2;
        }
        System.out.println(Arrays.toString(intArrayForLoop));
    }

    //метод, который находит в массиве среди всех элементов самый максимальный и минимальный, после чего выводит их в консоль
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

    //метод, который принимает на вход целочисленный массив, после чего проверяет и возвращает true, если в массиве есть место, в котором сумма левой и правой части массива равны.
    static boolean checkBalance(int[] arrayToCheck) {
        int sumRight = 0;
        int sumLeft = 0;
        boolean result = false;
        for (int i = 0; i < arrayToCheck.length; i++) {     //первый цикл, который ищет сумму слева
            if (result == true) break;
            sumLeft += arrayToCheck[i];     //каждую итерацию, если мы не нашли баланс мы увеличиваем сумму на следующее значение массива с начала
            sumRight = 0;   //перед новым заходом во второй цикл мы обнуляем правую сумму
            for (int j = arrayToCheck.length - 1; j > i; j--) {     //второй цикл ищет и сравнивает внутри себя правую и левую суммы. Пример:[2, 2, 2, 1, 2, 2, || 10, 2]
                sumRight += arrayToCheck[j];    //каждую итерацию, если мы не нашли баланс мы увеличиваем сумму на следующее значение массива только с обратной стороны
                if (sumRight == sumLeft) { //если сумма справа равна сумме слева, то мы выходим из второго цикла, после и из первого, при этом присваивая переменной result значение true
                    result = true;
                    break;
                }
            }
        }
        return result;//возвращаем значение баланса true - есть, false - нет
    }

    //метод, который принимает массив и шаг, на который необходимо сместить массив, возвращает новый массив со смещенными значениями
    static void moveArray(double[] arrayToMove, int n) {
        //Вариант с доп массивом
       /* int[] newArrayToFill = new int[arrayToMove.length];
        int j = arrayToMove.length - n;
        if (n > 0) {
            for (int i = 0; i < arrayToMove.length; i++) {
                newArrayToFill[i] = arrayToMove[j];
                j++;
                if (j == arrayToMove.length) j = 0;
            }
        } else {
            j = abs(n);
            for (int i = 0; i < arrayToMove.length; i++) {
                newArrayToFill[i] = arrayToMove[j];
                j++;
                if (j == arrayToMove.length) j = 0;
            }
        }*/
        //Вариант с текущим массивом, основная идея заключалась в том, чтобы использовать десятичные числа а точку как разделитель
        double buf;
        int j = arrayToMove.length - n; // инициализирована переменная j, которая определяет индекс элемента, который должен находится на первом места
        if (n > 0) { //проверка в какую сторону мы смещаемся n > 0 по часовой n < 0 против
            for (int i = 0; i < arrayToMove.length; i++) {
                buf = arrayToMove[i]; // буферна переменная для хранения числа
                if (arrayToMove[i] % 1 != 0) { //если элемент массива десятичное число с не нулевым значением после запятой, то мы не очищаем его, а присваиваем десятичное значение при этом переведя его в целую часть иначе очищаем
                    arrayToMove[i] = (double) Math.round((arrayToMove[i] % 1) * 10);
                } else {
                    arrayToMove[i] = 0;
                }
                if (i == j) { //далее сравниваем, нашли ли мы индекс элемента который должен быть на первом месте
                    if (buf % 1 != 0) {
                        buf = buf - (buf % 1);//если оно дробное то нас интересует только целая часть
                    }
                    arrayToMove[abs(arrayToMove.length - (i + n))] = buf;
                    j++;
                } else {// иначе мы данный элемент сдвигаем в место где он должен находится после сдвига
                    if (buf % 1 != 0) {
                        buf = buf - (buf % 1);
                    }
                    arrayToMove[abs(((arrayToMove.length - j) + i))] += buf / 10;
                }
            }
        } else {//если значение n<0
            j = abs(n); // индекс элемента, который должен находится в начале массива
            int step = j;
            for (int i = 0; i < arrayToMove.length; i++) {
                buf = arrayToMove[i];// буферна переменная для хранения числа
                if (arrayToMove[i] % 1 != 0) {//если элемент массива десятичное число с не нулевым значением после запятой, то мы не очищаем его, а присваиваем десятичное значение при этом переведя его в целую часть иначе очищаем
                    arrayToMove[i] = (double) Math.round((arrayToMove[i] % 1) * 10);
                } else {
                    arrayToMove[i] = 0;
                }
                if (i == j) {//далее сравниваем, нашли ли мы индекс элемента который должен быть на первом месте
                    if (buf % 1 != 0) {
                        buf = buf - (buf % 1);//если оно дробное то нас интересует только целая часть
                    }
                    arrayToMove[abs(i - step)] = buf;
                    j++;
                } else {
                    if (buf % 1 != 0) {
                        buf = buf - (buf % 1);
                    }
                    arrayToMove[abs(((arrayToMove.length - j) + i))] += buf / 10;
                }
            }
        }
        System.out.println(Arrays.toString(arrayToMove));
    }
}
