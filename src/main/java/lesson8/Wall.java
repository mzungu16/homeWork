package lesson8;

public class Wall implements Checkable {
    public Wall() {

    }

    @Override
    public boolean check(Participate participate) {
        int height = 5;
        if (height > participate.getBoundOfJump()) {
            participate.setContinue(false);
            return false;
        }
        return true;
    }

    @Override
    public String returnNameOfObstacle() {
        return "Wall";
    }
}
