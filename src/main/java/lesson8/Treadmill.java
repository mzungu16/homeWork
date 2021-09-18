package lesson8;

public class Treadmill implements Checkable {
    public Treadmill() {
    }

    @Override
    public boolean check(Participate participate) {
        int length = 535;
        if (length > participate.getBoundOfRun()) {
            return false;
        }
        return true;
    }

    @Override
    public String returnNameOfObstacle() {
        return "Treadmill";
    }
}
