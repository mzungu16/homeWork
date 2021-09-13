package lesson6;

/*
*1. Создать классы Собака и Кот с наследованием от класса Животное.
*2. Все животные могут бежать и плыть. В качестве параметра каждому методу передается длина препятствия.
Результатом выполнения действия будет печать в консоль. (Например, dogBobik.run(150); -> 'Бобик пробежал 150 м.');
*3. У каждого животного есть ограничения на действия (например бег: кот 200 м., собака 500 м.; плавание: кот не умеет плавать, собака 10 м.).
*4. Добавить подсчет созданных котов, собак и животных.
*/

import java.util.Scanner;

public class Lesson6 {
    static String[] TYPEOFANIMALS = {"Собака", "Кот"};
    static Scanner SCANNER = new Scanner(System.in);
    static int DOGCOUNTER = 0;
    static int CATCOUNTER = 0;
    static Dog DOG = null;
    static Cat CAT = null;

    public static void main(String[] args) {
        System.out.println("Введите сколько животных будет");
        int sizeOfArray = SCANNER.nextInt();
        Animal[] animals = new Animal[sizeOfArray];
        mainMethod(animals);
        System.out.printf("Всего было созданно собак - %d, котов - %d", DOG.getCounterDogs(), CAT.getCatCounter());
    }

    private static void mainMethod(Animal[] animals) {
        int inputSwimLength, inputRunLength;
        String inputTypeOfAnimal;
        for (int i = 0; i < animals.length; i++) {
            System.out.println("Введите тип животного, расстояние заплыва, расстояние пробежки");
            inputTypeOfAnimal = SCANNER.next();
            inputSwimLength = SCANNER.nextInt();
            inputRunLength = SCANNER.nextInt();
            if (inputTypeOfAnimal.equals(TYPEOFANIMALS[0])) {
                DOG = new Dog(TYPEOFANIMALS[0], inputSwimLength, inputRunLength);
                animals[i] = DOG;
                DOGCOUNTER++;
                DOG.setCounterDogs(DOGCOUNTER);
            } else {
                CAT = new Cat(TYPEOFANIMALS[1], inputSwimLength, inputRunLength);
                animals[i] = CAT;
                CATCOUNTER++;
                CAT.setCatCounter(CATCOUNTER);
            }
            animals[i].animalSwim(inputSwimLength);
            animals[i].animalRun(inputRunLength);
        }
    }
}
