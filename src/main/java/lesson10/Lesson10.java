package lesson10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/*
 * Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
 * Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
 * Посчитать, сколько раз встречается каждое слово.
 */

public class Lesson10 {
    static Scanner SCANNER;
    static File file = new File("dictionary.txt");

    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>(15);
        ArrayList<String> arrayList2 = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        initArrayList(arrayList);
        arrayList.forEach(System.out::println);
        findAndPrintWords(arrayList, arrayList2, map);
    }

    private static void findAndPrintWords(ArrayList<String> arrayList, ArrayList<String> arrayList2, Map<String, Integer> map) {
        for (String s : arrayList) {
            map.put(s, Collections.frequency(arrayList, s));
            if (Collections.frequency(arrayList,s) == 1) arrayList2.add(s);
        }
        System.out.println(arrayList2);
        System.out.println(map);
    }

    private static void initArrayList(ArrayList<String> arrayList) {
        try {
            SCANNER = new Scanner(file);
            while (SCANNER.hasNext()) {
                arrayList.add(SCANNER.next());
            }
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println(fileNotFoundException.getMessage());
        } finally {
            SCANNER.close();
        }
    }
}
