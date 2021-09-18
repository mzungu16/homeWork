package lesson8;

/*
 * 1. Создайте три класса Человек, Кот, Робот, которые не наследуются от одного класса.
 * Эти классы должны уметь бегать и прыгать (методы просто выводят информацию о действии в консоль).
 * 2. Создайте два класса: беговая дорожка и стена, при прохождении через которые, участники должны выполнять соответствующие действия (бежать или прыгать).
 * Результат выполнения печатаем в консоль (успешно пробежал, не смог пробежать и т.д.).
 * 3. Создайте два массива: с участниками и препятствиями, и заставьте всех участников пройти этот набор препятствий.
 * 4. У препятствий есть длина (для дорожки) или высота (для стены), а участников ограничения на бег и прыжки.
 * Если участник не смог пройти одно из препятствий, то дальше по списку он препятствий не идет.
 * */

import java.awt.*;

public class Lesson8 {
    public static void main(String[] args) {
//        firstAndSecondTask();
        Participate[] participates = {
                new Human("John", 3, 200),
                new Cat("Tom", 10, 500),
                new Robot("AV-124", 0, 1000),
                new Human("Ghbkaf", 6, 1000),
                new Robot("safasfaff", 4, 1000),
                new Cat("AVAFAFAF", 8, 1000),
                new Robot("AV-12afafsaf4", 0, 1000)
        };


        Checkable[] obstacles = {
                new Wall(),
                new Treadmill(),
                new Treadmill(),
                new Wall()
        };
        for (Participate participate : participates) {
            for (Checkable o : obstacles) {
                if(o.check(participate) && participate.isContinue()){
                    System.out.printf("%s do %s\n",participate.getNameOfParticipate(),o.returnNameOfObstacle());
                }
            }
        }
    }

    private static void firstAndSecondTask() {
        Participate[] participates = {
                new Human("Human"),
                new Cat("Cat"),
                new Robot("Robot")
        };
        for (Participate participate : participates) {
            participate.jump();
            participate.run();
        }
    }
}
