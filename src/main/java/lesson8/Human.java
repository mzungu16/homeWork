package lesson8;

public class Human implements AbleToDo {
    private String name;
    public Human() {
    }

    public Human(String name){
        this.name = name;
    }

    public void throughTheObstacle (Wall wall, Treadmill treadmill){
        wall.obstaclePassingMethodInWall(this.name);
        treadmill.obstaclePassingMethodInTreadmill(this.name);
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
