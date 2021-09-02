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

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lesson3 {
    public static void main(String[] args) {
        fillArray();//метод для выполнения 1 задания
        findNumber();//метод для выполнения 2 задания
        findWord();//метод для выполнения 3 задания
    }

    //метод, заполняет диагональные элементы квадратной матрицы единицами
    static void fillArray() {
        int[][] arrayToFill = new int[5][5];
        for (int i = 0; i < arrayToFill.length; i++) {
            for (int j = 0; j < arrayToFill.length; j++) {
                if (i == j) {
                    arrayToFill[i][j] = 1;
                }
                System.out.print(arrayToFill[i][j] + " ");
            }
            System.out.println();
        }
    }

    //метод, запускающий игру "угадай число"
    static void findNumber() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.println("Угадайте число от 0 - 9");
        int numberToFind = random.nextInt(9), inputNumber, i = 3;
        while (i != 0) {
            System.out.println("Попыток - " + i);
            inputNumber = scanner.nextInt();
            if (inputNumber > numberToFind) { //если введенное число больше заданного, то выводим сообщение в консоль + уменьшаем кол-во попыток
                System.out.println("Введенное число больше загаданного");
                i--;
            } else if (inputNumber < numberToFind) { //если введенное число меньше заданного, то выводим сообщение в консоль + уменьшаем кол-во попыток
                System.out.println("Веденное число меньше загаданного");
                i--;
            } else { // если они совпадают, то мы угадали выводим сообщение в консоль и прерываем цикл
                System.out.println("Вы угадали");
                break;
            }
            if (i == 0) { // кодовый блок отвечающий за переигровку если да, то перезапускаем, если нет то просто по условию цикла мы выйдем из него
                System.out.println("Вы проиграли (");
                System.out.println("Хотите попробовать еще раз? 1-да 0-нет");
                int yesOrNot = scanner.nextInt();
                if (yesOrNot == 1) { // если 1(да), то мы перезапускаем цикл путем возвращения количества попыток к 3
                    i = 3;
                }
            }
        }
    }

    //метод, запускающий игру "угадай слово"
    static void findWord() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String[] words = {"apple", "nut", "olive", "avocado","melon", "leak", "kiwi", "mango", "mushroom"}; // строковый массив слов, которые возможно загадать
        System.out.println("Для выполнения третьего задания мы загадаем случайное слово - " + Arrays.toString(words) + " ваша задача его отгадать");
        int indexOfWordToFind = random.nextInt(words.length); // генерируем индекс случайного элемента в этом массиве
        String wordToFind = words[indexOfWordToFind], inputWord, symbols = "";
        while (true) { // цикл выполняющий основную логику
            inputWord = scanner.next();
            if (inputWord.equals(wordToFind)) { // проверка, если каждый символ введенного слова равен символу загаданного слова, то это означает, что мы угадали
                System.out.println("Вы угадали слово оно - " + wordToFind);
                break;
            } else { // иначе мы перехожим в блок, который отвечает за повтор
                System.out.println("Вы не угадали попробуйте еще раз" + Arrays.toString(words));
                if (inputWord.length() >= wordToFind.length()) { // проверяем, если длина слова больше или совпадает вызываем метод
                    System.out.println(elseToFindFunction(wordToFind, inputWord, symbols)); // метод, отвечающий за проверку букв во введенном слове
                }else{ // иначе говорим попробовать еще раз, до тех пор, пока длина слова не будем либо такой же, либо не превысит загаданное
                    System.out.println("В загаданном слове больше букв");
                }
            }
        }
    }

    static String elseToFindFunction(String wordToFind, String inputWord, String symbols) {
        for (int i = 0; i < 15; i++) {
            if (i < wordToFind.length()) { // пока i меньше длинны загаданного слова мы сравниваем символы
                if (inputWord.charAt(i) == wordToFind.charAt(i)) { // если символы равно то в строку записываем отгаданные
                    symbols += wordToFind.charAt(i);
                } else { // на месте всех не отгаданных ставим #
                    symbols += "#";
                }
            } else { // чтобы игрок не знал длину слова мы остающийся место заполняем символами #
                symbols += "#";
            }
        }
        return symbols; // возвращаем полученную строку
    }
}
