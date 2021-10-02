package lesson11;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Box<E> {
    private List<E> list = new ArrayList<>();
    private double totalWeight;

    public Box() {
    }

    public double weightOfBox() {
        for (Object o : this.list) {
            if (o instanceof Fruit) {
                totalWeight += ((Fruit) o).getWeightOfFruit();
            }
        }
        return totalWeight;
    }

    public boolean compareByWeight(Box<?> fruitBox) {
        return Math.abs(weightOfBox() - fruitBox.weightOfBox()) < 0.00000000000001;
    }

    public void add(E apple) {
        this.list.add(apple);
    }

    public void add(List<E> appleList) {
        for (E e : appleList) {
            add(e);
        }
    }

    public void copyAndEmptyBox(Box<E> fruitBox) {
        fruitBox.addAll(this.list);
        this.list.clear();
    }

    private void addAll(List<E> list) {
        this.list.addAll(list);
    }

    public List<E> getList() {
        return list;
    }
}
