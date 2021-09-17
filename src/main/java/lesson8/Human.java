package lesson8;

public class Human implements AbleToDo {

    public Human() {
    }

    @Override
    public void run() {
        System.out.println("Human is running");
    }

    @Override
    public void jump() {
        System.out.println("Human can jump");
    }
}
