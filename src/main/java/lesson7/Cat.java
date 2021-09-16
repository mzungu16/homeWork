package lesson7;

public class Cat {
    private String name;
    private int satiety;
    private boolean initialSatiety = false;

    public Cat(String name, int satiety) {
        this.name = name;
        this.satiety = satiety;
    }

    public int eat(int foodInBowl) {
        return foodInBowl - satiety;
    }

    public boolean isInitialSatiety() {
        return initialSatiety;
    }

    public void setInitialSatiety(boolean initialSatiety) {
        this.initialSatiety = initialSatiety;
    }

    public String getName() {
        return name;
    }

    public int getSatiety() {
        return satiety;
    }
}
