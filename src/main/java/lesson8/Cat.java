package lesson8;

public class Cat implements AbleToDo {

    public Cat() {
    }

    @Override
    public void run() {
        System.out.println("Cat is running");
    }

    @Override
    public void jump() {
        System.out.println("Cat can jump");
    }
}
