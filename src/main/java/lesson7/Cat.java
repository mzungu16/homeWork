package lesson7;

public class Cat {
    private String name;
    private int satiety;
    private boolean notHungry = false;

    public Cat(String name, int satiety) {
        this.name = name;
        this.satiety = satiety;
    }

    public int eat(int foodInBowl) {
        return foodInBowl - satiety;
    }

    public boolean isNotHungry() {
        return notHungry;
    }

    public void setNotHungry(boolean notHungry) {
        this.notHungry = notHungry;
    }

    public String getName() {
        return name;
    }

    public int getSatiety() {
        return satiety;
    }
}
