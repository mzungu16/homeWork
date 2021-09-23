package lesson8;

public class Cat extends Participate implements AbleToDo {

    public Cat(String type) {
        super(type);
    }

    public Cat(String nameOfCat, int boundOfJumpCat, int boundOfRunCat) {
        super(nameOfCat,boundOfJumpCat,boundOfRunCat);
    }
}
