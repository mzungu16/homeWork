package lesson7;

/*
1. Расширить задачу про котов и тарелки с едой.
2. Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды (например, в миске 10 еды, а кот пытается покушать 15-20).
3. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны). Если коту удалось покушать (хватило еды), сытость = true.
4. Считаем, что если коту мало еды в тарелке, то он её просто не трогает, то есть не может быть наполовину сыт (это сделано для упрощения логики программы).
5. Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки и потом вывести информацию о сытости котов в консоль.
6. Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку.
* */

import java.util.Scanner;

public class Lesson7 {
    static Bowl bowl = new Bowl(40);
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Cat[] cats = {
                new Cat("Simba", 25),
                new Cat("Barsik", 5),
                new Cat("John", 8),
                new Cat("Tom", 12)
        };
        mainFunction(cats);
    }

    private static void mainFunction(Cat[] cats) {
        int restFoodInBowl = bowl.getBowl();
        for (Cat cat : cats) {
            if (cat.getSatiety() > bowl.getBowl()) {
                System.out.printf("%s не хватает еды в миске!\n",cat.getName());
                System.out.print("Миску можно наполнить 1 - Да, 2 - Нет\n");
                int inputAnswer = scanner.nextInt();
                if (inputAnswer == 1) {
                    bowl.fillBowl(cat.getSatiety(), restFoodInBowl);
                    System.out.printf("Миска была заполнена на %d\n",cat.getSatiety()-restFoodInBowl);
                }else{
                    System.out.printf("%s не будет кушать так как в миске мало еды! И его сытость - %b\n", cat.getName(), cat.isNotHungry());
                    break;
                }
            }
            restFoodInBowl = cat.eat(bowl.getBowl());
            bowl.setBowl(restFoodInBowl);
            cat.setNotHungry(true);
            System.out.printf("%s покушал. Остаток еды в миске - %d. И его сытость теперь - %b\n", cat.getName(), bowl.getBowl(),cat.isNotHungry());
        }
    }
}
