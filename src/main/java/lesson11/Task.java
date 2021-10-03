package lesson11;

/*
* Задача:
a) Даны классы Fruit, Apple extends Fruit, Orange extends Fruit;
b) Класс Box, в который можно складывать фрукты.
    Коробки условно сортируются по типу фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
c) Для хранения фруктов внутри коробки можно использовать ArrayList;
d) Сделать метод getWeight(), который высчитывает вес коробки, зная вес одного фрукта и их количество:
    вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);
e) Внутри класса Box сделать метод compare(), который позволяет сравнить текущую коробку с той, которую подадут в compare() в качестве параметра.
    true – если их массы равны, false в противоположном случае. Можно сравнивать коробки с яблоками и апельсинами;
f) Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую. Помним про сортировку фруктов: н
    нельзя яблоки высыпать в коробку с апельсинами. Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в первой;
g) Не забываем про метод добавления фрукта в коробку.
* */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Task {
    public static void main(String[] args) {
        Random random = new Random();
        Box<Apple> appleBox = new Box<>();
        addApplesInBoxAsSingleObject(appleBox);
        Box<Apple> appleBox1 = new Box<>();
        addApplesInBoxAsList(appleBox1, random);
        Box<Orange> orangeBox = new Box<>();
        addOrangesInBoxAsSingleObject(orangeBox);
        Box<Orange> orangeBox1 = new Box<>();
        addOrangesInBoxAsList(random, orangeBox1);
        System.out.println(appleBox.compareByWeight(orangeBox));//сравнение коробок
        appleBox.copyAndEmptyBox(appleBox1);//пересыпание фруктов
    }

    private static void addOrangesInBoxAsList(Random random, Box<Orange> orangeBox1) {
        Orange[] oranges = {
                new Orange(random.nextInt(9)),
                new Orange(random.nextInt(9)),
                new Orange(random.nextInt(9)),
                new Orange(random.nextInt(9)),
                new Orange(random.nextInt(9)),
                new Orange(random.nextInt(9)),
        };
        List<Orange> orangeList = new ArrayList<>(Arrays.asList(oranges));
        orangeBox1.add(orangeList);
    }

    private static void addOrangesInBoxAsSingleObject(Box<Orange> orangeBox) {
        orangeBox.add(new Orange(2.4));
        orangeBox.add(new Orange(1.40));
        orangeBox.add(new Orange(1.2));
        orangeBox.add(new Orange(2.35));
    }

    private static void addApplesInBoxAsList(Box<Apple> appleBox2, Random random) {
        Apple[] apples = {
                new Apple(random.nextInt(9)),
                new Apple(random.nextInt(9)),
                new Apple(random.nextInt(9)),
                new Apple(random.nextInt(9)),
                new Apple(random.nextInt(9))
        };
        List<Apple> appleList = new ArrayList<>(Arrays.asList(apples).subList(0, 5));
        appleBox2.add(appleList);
    }

    private static void addApplesInBoxAsSingleObject(Box<Apple> appleBox) {
        appleBox.add(new Apple(2.0));
        appleBox.add(new Apple(2.35));
        appleBox.add(new Apple(3.0));
    }
}
