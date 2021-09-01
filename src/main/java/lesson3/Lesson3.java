package lesson3;

/*
* 1. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
* 2. Написать программу, которая загадывает случайное число от 0 до 9 и пользователю дается 3 попытки угадать это число.
При каждой попытке компьютер должен сообщить, больше ли указанное пользователем число, чем загаданное, или меньше.
После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).
* 3. Создать массив из слов String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
"garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"}
При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя, сравнивает его с загаданным словом и сообщает, правильно ли ответил пользователь.
Если слово не угадано, компьютер показывает буквы, которые стоят на своих местах. apple – загаданное apricot - ответ игрока ap#############
(15 символов, чтобы пользователь не мог узнать длину слова) Для сравнения двух слов посимвольно можно пользоваться:
String str = "apple"; char a = str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции Играем до тех пор, пока игрок не отгадает слово. Используем только маленькие буквы.
*/

import java.util.Random;
import java.util.Scanner;

public class Lesson3 {
    public static void main(String[] args) {
        fillArray();//метод для выполнения 1 задания
        System.out.println("Угадайте число от 0 - 9");
        findNumber();//метод для выполнения 2 задания
    }

    //метод, заполняет диагональные элементы квадратного массива единицами
    static void fillArray() {
        int[][] arrayToFill = new int[3][3];
        for (int i = 0; i < arrayToFill.length; i++) {
            for (int j = 0; j < arrayToFill.length; j++) {
                if (i == j) {
                    arrayToFill[i][j] = 1;
                }
                System.out.print(arrayToFill[i][j]);
            }
            System.out.println();
        }
    }

    static void findNumber() {
        Random random = new Random();
        int numberToFind = random.nextInt(9);
       // System.out.println(numberToFind);
        Scanner scanner = new Scanner(System.in);
        int inputNumber, i = 3;
        while (i != 0) {
            System.out.println("Попыток - " + i);
            inputNumber = scanner.nextInt();
            if (inputNumber > numberToFind) {
                System.out.println("Введенное число больше загаданного");
                i--;
            } else if (inputNumber < numberToFind) {
                System.out.println("Веденное число меньше загаданного");
                i--;
            } else {
                System.out.println("Вы угадали");
                break;
            }
            if (i == 0) {
                System.out.println("Вы проиграли (");
                System.out.println("Хотите попробовать еще раз? 1-да 0-нет");
                int yesOrNot = scanner.nextInt();
                if (yesOrNot == 1) {
                    i = 3;
                }
            }
        }
    }
}
