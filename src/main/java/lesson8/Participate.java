package lesson8;

public class Participate implements AbleToDo {
    private String nameOfParticipate;
    private int boundOfJump;
    private int boundOfRun;
    private boolean isContinue = true;
    private String type;

    public Participate(String type) {
        this.type = type;
    }

    public Participate(String nameOfParticipate, int boundOfJump, int boundOfRun) {
        this.nameOfParticipate = nameOfParticipate;
        this.boundOfJump = boundOfJump;
        this.boundOfRun = boundOfRun;
    }

    public String getNameOfParticipate() {
        return nameOfParticipate;
    }

    public int getBoundOfJump() {
        return boundOfJump;
    }

    public int getBoundOfRun() {
        return boundOfRun;
    }

    @Override
    public void run() {
        System.out.printf("%s is running\n", this.type);
    }

    @Override
    public void jump() {
        if (this.type.equals("Robot")) {
            System.out.printf("%s can't jumping\n", this.type);
        } else {
            System.out.printf("%s is jumping\n", this.type);
        }
    }
}
