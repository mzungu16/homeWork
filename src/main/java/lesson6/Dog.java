package lesson6;

public class Dog extends Animal {
   private int counterDogs;

    public Dog(String typeOfAnimal, int swimLength, int runLength) {
        super(typeOfAnimal, swimLength, runLength);
    }

    public int getCounterDogs() {
        return counterDogs;
    }

    public void setCounterDogs(int counterDogs) {
        this.counterDogs = counterDogs;
    }

    @Override
    public void animalSwim(int inputSwimLength) {
        if (inputSwimLength < 10) {
            System.out.printf("%s проплыл(а) - %d\n", typeOfAnimal, swimLength);
        } else {
            System.out.printf("%s вероятно утонет\n", typeOfAnimal);
        }
    }

    @Override
    public void animalRun(int inputRunLength) {
        if (inputRunLength < 500) {
            System.out.printf("%s пробежал(а) - %d\n", typeOfAnimal, runLength);
        } else {
            System.out.printf("%s вероятно не сможет пробежать такую дистанцию\n", typeOfAnimal);
        }
    }

}
