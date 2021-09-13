package lesson6;

public class Cat extends Animal {
    private int catCounter;
    public Cat(String typeOfAnimal, int swimLength, int runLength) {
        super(typeOfAnimal, swimLength, runLength);
    }

    public int getCatCounter() {
        return catCounter;
    }

    public void setCatCounter(int catCounter) {
        this.catCounter = catCounter;
    }

    @Override
    public void animalSwim(int inputSwimLength) {
        System.out.printf("Кот не умеет плавать\n");
    }

    @Override
    public void animalRun(int inputRunLength) {
        if (inputRunLength < 200) {
            System.out.printf("%s пробежал - %d\n", typeOfAnimal, runLength);
        } else {
            System.out.printf("%s вероятно не сможет пробежать такую дистанцию\n", typeOfAnimal);
        }

    }
}
