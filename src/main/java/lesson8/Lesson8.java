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

public class Lesson8 {
    static Wall WALL = new Wall();
    static Treadmill TREADMILL = new Treadmill();

    public static void main(String[] args) {
        firstTaskWithInterfaces();
        secondTask(WALL, TREADMILL);
    }

    private static void secondTask(Wall wall, Treadmill treadmill) {
        Object[] objects = {
                new Human(),
                new Cat(),
                new Robot()
        };
        for (Object object : objects) {
            wall.doWithWall(object);
            treadmill.run();
        }
    }

    private static void firstTaskWithInterfaces() {
        Human human = new Human();
        human.run();
        human.jump();
        Cat cat = new Cat();
        cat.run();
        cat.jump();
        Robot robot = new Robot();
        robot.run();
        robot.jump();
    }
}
