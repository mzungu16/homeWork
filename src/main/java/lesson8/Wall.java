package lesson8;

public class Wall implements Checkable {
    public Wall() {

    }

    @Override
    public boolean check(Participate participate) {
        int hight = 5;
        if (hight > participate.getBoundOfJump()) {

            return false;
        }
        return true;
    }

    @Override
    public String returnNameOfObstacle() {
        return "Wall";
    }
}
