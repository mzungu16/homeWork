package lesson10;

/*
 * Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и телефонных номеров.
 * В этот телефонный справочник с помощью метода add() можно добавлять записи, а с помощью метода get() искать номер телефона по фамилии.
 * Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев), тогда при запросе такой фамилии должны выводиться все телефоны.
 * Желательно не добавлять лишний функционал (дополнительные поля (имя, отчество, адрес), взаимодействие с пользователем через консоль и т.д).
 * Консоль использовать только для вывода результатов проверки телефонного справочника.
 */

import java.util.*;

public class ContactList {
    static Random RANDOM = new Random();
    static List<String> contactList = new ArrayList<>();
    static List<String> telephoneList = new ArrayList<>();

    public static void main(String[] args) {
        fillLists();
        printAllContactList();
        findContact();
    }

    private static void findContact() {
        int surname = RANDOM.nextInt(contactList.size());
        for (int i = 0; i < contactList.size(); i++) {
            if (contactList.get(surname).equals(contactList.get(i))){
                System.out.printf("%s - %s\n",contactList.get(i),telephoneList.get(i));
            }
        }
    }

    private static void printAllContactList() {
            System.out.println("List of all contacts!");
        for (int i = 0; i < contactList.size(); i++) {
            System.out.printf("%s - %s\n",contactList.get(i),telephoneList.get(i));
        }
        System.out.println();
    }

    private static void fillLists() {
        contactList.add("Sidorov");
        telephoneList.add("90123124");
        contactList.add("White");
        telephoneList.add("086441265412");
        contactList.add("Sidorov");
        telephoneList.add("124125546554");
        contactList.add("Poll");
        telephoneList.add("45466132");
        contactList.add("Ivanov");
        telephoneList.add("02151532");
        contactList.add("Sidorov");
        telephoneList.add("21354");
        contactList.add("Ivanov");
        telephoneList.add("3421432");
    }
}
