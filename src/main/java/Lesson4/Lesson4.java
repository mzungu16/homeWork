package Lesson4;

/*
Полностью разобраться с кодом, попробовать переписать с нуля, стараясь не подглядывать в методичку.
Переделать проверку победы, чтобы она не была реализована просто набором условий, например, с использованием циклов.
Попробовать переписать логику проверки победы, чтобы она работала для поля 5х5 и количества фишек 4. Очень желательно не делать это просто набором условий для каждой из возможных ситуаций;
Доработать искусственный интеллект, чтобы он мог блокировать ходы игрока.
*/

import java.util.Random;
import java.util.Scanner;

public class Lesson4 {

    private static final char X_POINT = 'X';
    private static final char O_POINT = 'O';
    private static final char EMPTY_POINT = '.';
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random RANDOM = new Random();
    private static char[][] field;
    private static int fieldSizeX;
    private static int fieldSizeY;
    private static int figures;
    private static int checkCounterHuman;
    private static int checkCounterAi;

    public static void main(String[] args) {
        initField();
        printField();
        while (true) {
            humanTurn();
            if(checkWin()){
                printField();
                break;
            }
            aiTurn();
            printField();
            if(checkWin())break;
        }
    }

    private static void initField() {
        fieldSizeX = SCANNER.nextInt();
        fieldSizeY = SCANNER.nextInt();
        field = new char[fieldSizeY][fieldSizeX];
        figures = field.length-1;
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                field[y][x] = EMPTY_POINT;
            }
        }
    }

    private static void printField() {
        System.out.print(" ");
        for (int x = 0; x < fieldSizeX; x++) {
            System.out.print(" " + (x + 1));
        }
        System.out.println();
        for (int y = 0; y < fieldSizeY; y++) {
            System.out.print(y + 1 + "|");
            for (int x = 0; x < fieldSizeX; x++) {
                System.out.print(field[y][x] + "|");
            }
            System.out.println();
        }
    }

    private static void humanTurn() {
        int valueX, valueY;
        do {
            System.out.println("Input the coordinate please");
            valueX = SCANNER.nextInt() - 1;
            valueY = SCANNER.nextInt() - 1;
        } while (!placeIsEmpty(valueY, valueX) || !boundIsNorm(valueY, valueX));

        field[valueY][valueX] = X_POINT;
    }

    private static void aiTurn() {
        int aiValueX, aiValueY;
        do {
            aiValueX = RANDOM.nextInt(fieldSizeX);
            aiValueY = RANDOM.nextInt(fieldSizeY);
        } while (!placeIsEmpty(aiValueY, aiValueX));

        field[aiValueY][aiValueX] = O_POINT;
    }

    private static boolean checkWin() {
        // проверка по строкам
        if (checkStrings()) return true;
        // проверка по столбцам
        if (checkColumns()) return true;
        // проверка по диагонали начиная с 0:0
        if (checkFirstDiagonal()) return true;
        // проверка по противоположной диагонали
        if (checkLastDiagonal()) return true;
        // проверка на ничью
        if (isHoleFieldEmpty()) {
            System.out.println("Draw");
            return true;
        }
        return false;
    }

    private static boolean checkLastDiagonal() {
        if (checkCounterHuman != 0 || checkCounterAi != 0) {
            checkCounterHuman = 0;
            checkCounterAi = 0;
        }
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if ((y + x) == field.length - 1) {
                    if (field[y][x] == X_POINT) checkCounterHuman++;
                    else if (field[y][x] == O_POINT) checkCounterAi++;
                    if (checkCounterHuman == figures) {
                        System.out.println("You wins");
                        return true;
                    } else if (checkCounterAi == figures) {
                        System.out.println("Ai wins");
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean checkFirstDiagonal() {
        if (checkCounterHuman != 0 || checkCounterAi != 0) {
            checkCounterHuman = 0;
            checkCounterAi = 0;
        }
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (y == x) {
                    if (field[y][x] == X_POINT) checkCounterHuman++;
                    else if (field[y][x] == O_POINT) checkCounterAi++;
                    if (checkCounterHuman == figures) {
                        System.out.println("You wins");
                        return true;
                    } else if (checkCounterAi == figures) {
                        System.out.println("Ai wins");
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean checkColumns() {
        if (checkCounterHuman != 0 || checkCounterAi != 0) {
            checkCounterHuman = 0;
            checkCounterAi = 0;
        }
        for (int x = 0; x < fieldSizeX; x++) {
            for (int y = 0; y < fieldSizeY; y++) {
                if (field[y][x] == X_POINT) checkCounterHuman++;
                else if (field[y][x] == O_POINT) checkCounterAi++;
            }
            if (checkCounterHuman == figures) {
                System.out.println("You wins");
                return true;
            } else if (checkCounterAi == figures) {
                System.out.println("Ai wins");
                return true;
            }
            checkCounterHuman = 0;
            checkCounterAi = 0;
        }
        return false;
    }

    private static boolean checkStrings() {
        if (checkCounterHuman != 0 || checkCounterAi != 0) {
            checkCounterHuman = 0;
            checkCounterAi = 0;
        }
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (field[y][x] == X_POINT) checkCounterHuman++;
                else if (field[y][x] == O_POINT) checkCounterAi++;
            }
            if (checkCounterHuman == figures) {
                System.out.println("You wins");
                return true;
            } else if (checkCounterAi == figures) {
                System.out.println("Ai wins");
                return true;
            }
            checkCounterHuman = 0;
            checkCounterAi = 0;
        }
        return false;
    }

    private static boolean boundIsNorm(int valueY, int valueX) {
        return valueX >= 0 && valueY >= 0 && valueX < fieldSizeX && valueY < fieldSizeY;
    }

    private static boolean placeIsEmpty(int valueY, int valueX) {
        return field[valueY][valueX] == EMPTY_POINT;
    }

    private static boolean isHoleFieldEmpty() {
        int i = 0;
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (field[y][x] == EMPTY_POINT) i++;
            }
        }
        if (i != 0) return false;
        return true;
    }
}