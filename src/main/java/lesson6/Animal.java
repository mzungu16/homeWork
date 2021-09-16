package lesson6;

public abstract class Animal {
    protected String typeOfAnimal;
    protected int swimLength, runLength;

    public Animal(String typeOfAnimal, int swimLength, int runLength) {
        this.typeOfAnimal = typeOfAnimal;
        this.swimLength = swimLength;
        this.runLength = runLength;
    }

    public abstract void animalSwim(int inputSwimLength);

    public abstract void animalRun(int inputRunLength);


}
