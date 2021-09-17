package lesson8;

public class Cat implements AbleToDo {
    private String nameOfCat;
    public Cat() {
    }

    public Cat(String nameOfCat){
        this.nameOfCat = nameOfCat;
    }

    public void throughTheObstacleCat (Wall wall, Treadmill treadmill){
        wall.obstaclePassingMethodInWall(this.nameOfCat);
        treadmill.obstaclePassingMethodInTreadmill(this.nameOfCat);
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
