package lesson8;

public class Robot implements AbleToDo {

    public Robot() {
    }

    @Override
    public void run() {
        System.out.println("Robot is running");
    }

    @Override
    public void jump() {
        System.out.println("Robot can't jump");
    }
}
