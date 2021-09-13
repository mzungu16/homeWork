package lesson5;

/*
Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
Конструктор класса должен заполнять эти поля при создании объекта.
Внутри класса «Сотудник» написать метод, который выводит информацию об объекте в консоль.
Создать массив из 5 сотрудников. Пример: Person[] persArray = new Person[5];
// Вначале объявляем массив объектов persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30);
// потом для каждой ячейки массива задаем объект persArray[1] = new Person(...); ... persArray[4] = new Person(...);
С помощью цикла вывести информацию только о сотрудниках старше 40 лет.
*/

import java.util.Random;

public class Lesson5 {
    public static void main(String[] args) {
        Employee[] employees = new Employee[5];
        String[] names = {"Ivanov Ivan", "John White", "Tom Bell", "Jack Alan", "Petrov Vladimir"};
        String[] positions = {"top-engineer", "android-developer", "ios-developer", "hr", "manager"};
        String[] emails = {"example@gmail.com", "text@sad.com", "text2@test.com", "text3@txt.com", "text4@gm.com"};
        String[] telephones = {"+221214124", "+380323124", "+7124124512", "+981124214", "+01241241241"};
        int[] salarys = {45000, 55000, 6000, 80000, 96000};
        int[] ages = {45, 25, 30, 40, 41};
        for (int i = 0; i < employees.length; i++) {
            employees[i] = new Employee(names[i], positions[i], emails[i], telephones[i], salarys[i], ages[i]);
            if (employees[i].getAge() > 40) {
                System.out.println(employees[i]);
            }
        }
    }
}
