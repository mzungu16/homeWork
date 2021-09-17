package lesson8;

public class Wall {

    public Wall() {
    }

    public void doWithWall(Object object) {
        if (object instanceof Human) {
            System.out.println("Human jump");
        } else if (object instanceof Cat) {
            System.out.println("Cat jump");
        } else {
            System.out.println("Robot can't jump :(");
        }
    }
}
