package lesson8;

public class Robot implements AbleToDo {
    private String nameOfRobot;
    public Robot() {
    }

    public Robot(String nameOfRobot){
        this.nameOfRobot = nameOfRobot;
    }

    public void throughTheObstacleRobot (Wall wall, Treadmill treadmill){
        wall.obstaclePassingMethodInWall(this.nameOfRobot);
        treadmill.obstaclePassingMethodInTreadmill(this.nameOfRobot);
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
