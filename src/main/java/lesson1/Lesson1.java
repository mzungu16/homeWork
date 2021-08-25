package lesson1;

import java.util.Scanner;

/*
1. Создать пустой проект в IntelliJ IDEA и прописать метод main().
2. Создать переменные всех пройденных типов данных и инициализировать их значения.
3. Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат, где a, b, c, d – аргументы этого метода, имеющие тип float.
4. Написать метод, принимающий на вход два целых числа и проверяющий, что их сумма лежит в пределах от 10 до 20 (включительно),
   если да – вернуть true, в противном случае – false.
5. Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль,
   положительное ли число передали или отрицательное. Замечание: ноль считаем положительным числом.
6. Написать метод, которому в качестве параметра передается целое число.
   Метод должен вернуть true, если число отрицательное, и вернуть false если положительное.
7. Написать метод, которому в качестве параметра передается строка, обозначающая имя. Метод должен вывести в консоль сообщение «Привет, указанное_имя!».
8. *Написать метод, который определяет, является ли год високосным, и выводит сообщение в консоль.
    Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
*/

public class Lesson1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        dataTypes();//вызов метода, который отвечает за выполнение 2-го задания
        System.out.println("Для выполнения 3-го задания введите значения аргументов!");
        float a = scanner.nextFloat(), b = scanner.nextFloat(), c = scanner.nextFloat(), d = scanner.nextFloat();//инициализация нескольких переменных в одну строку с одним типом, вводить нужно с ','
        calculateMethod(a, b, c, d);//вызов метода который отвечает за выполнения 3-го задания
        System.out.println("Для выполнения 4-го задания введите два аргумента!");
        int firstVal = scanner.nextInt(), secondVal = scanner.nextInt();//инициализация нескольких переменных в одну строку с одним типом
        isSumInRange(firstVal, secondVal);//вызов метода который отвечает за выполнения 4-го задания
        System.out.println("Для выполнения 5-го и 6-го задания введите число");
        int number = scanner.nextInt();
        isPositiveNumber(number);//вызов метода который отвечает за выполнения 5-го задания
        isNegativeNumber(number);//вызов метода который отвечает за выполнения 6-го задания
        System.out.println("Для 7-го задания введите строку");
        String message = scanner.next();
        printMessage(message);//вызов метода который отвечает за выполнение 7-го задания
        System.out.println("Для выполнения 8-го задания введите год");
        int year = scanner.nextInt();
        leapYear(year);//вызов метода который отвечает за выполнение 8-го задания
    }

    //метод в котором происходит инициализация переменных с изученными типами с последующим выводом в консоль
    static void dataTypes() {
        byte byteVal = -115;
        short shortVal = 11505;
        int intVal = 4;
        long longVal = 14999323L;
        float floatVal = 10.14f;
        double doubleVal = 25.4;
        char charVal = 'h';
        boolean booleanVal = true;
        System.out.println("byte byteVal = " + byteVal + "\n" + "short shortVal = " + shortVal + "\n" + "int intVal = " + intVal + "\n" + "long longVal = " + longVal
                + "\n" + "float floatVal = " + floatVal + "\n" + "double doubleVal = " + doubleVal + "\n" + "chat chatVal = " + charVal + "\n" + "boolean booleanVal = " + booleanVal);
    }

    //метод, который принимает 4 аргумента с типом float и подсчитывает выражение после чего выводит в консоль его результат
    static void calculateMethod(float a, float b, float c, float d) {
        float result = a * (b + (c / d));
        System.out.println("Результат подсчета выражения = " + result);
    }

    //метод, который принимает два целочисленных аргумента, после чего подсчитывает их сумму и проверяет находится ли она(сумма) в нужном диапазоне(10..20)
    static void isSumInRange(int firstVal, int secondVal) {
        int sumVal = firstVal + secondVal;
        System.out.println(sumVal >= 10 && sumVal <= 20);
    }

    //метод, который принимает число и после проверки положительное оно или нет выводит в консоль результат
    static void isPositiveNumber(int number) {
        if (number >= 0) System.out.println(number + " положительное");
        else System.out.println(number + " отрицательное");
    }

    //метод, который принимает число и выводит в консоль true если число отрицательное в противном случае выводит false
    static void isNegativeNumber(int number) {
        System.out.println(number < 0);
    }

    //метод, который принимает строку и выводит в консоль сообщение
    static void printMessage(String message) {
        System.out.println("Привет, " + message);
    }

    //метод, который принимает число(год) и проверяет, является ли год високосным
    static void leapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    System.out.println(year + " год високосный");
                } else System.out.println(year + " год не високосный");
            } else System.out.println(year + " год високосный");
        } else System.out.println(year + " не високосный год");
    }
}
