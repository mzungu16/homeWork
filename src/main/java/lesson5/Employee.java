package lesson5;

/*
Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
Конструктор класса должен заполнять эти поля при создании объекта.
Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.
Создать массив из 5 сотрудников. Пример: Person[] persArray = new Person[5];
// Вначале объявляем массив объектов persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30);
// потом для каждой ячейки массива задаем объект persArray[1] = new Person(...); ... persArray[4] = new Person(...);
С помощью цикла вывести информацию только о сотрудниках старше 40 лет.
*/

public class Employee {
    private String secondName, position, email, telephone;
    private int salary, age;

    Employee(String secondName, String position, String email, String telephone, int salary, int age) {
        this.secondName = secondName;
        this.position = position;
        this.email = email;
        this.telephone = telephone;
        this. salary = salary;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String toString() {
        return String.format("Сотрудник: %s, должность - %s, email - %s, телефон - %s, зарплата - %d, возраст - %d",
                this.secondName, this.position, this.email, this.telephone, this.salary, this.age);
    }
}
