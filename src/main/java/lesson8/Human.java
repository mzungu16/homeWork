package lesson8;

public class Human extends Participate implements AbleToDo {

    public Human(String type) {
        super(type);
    }

    public Human(String name, int boundOfJump, int boundOfRun) {
        super(name,boundOfJump,boundOfRun);
    }
}
