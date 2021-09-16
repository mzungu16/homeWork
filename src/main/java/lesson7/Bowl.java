package lesson7;

public class Bowl {
    private int bowl;

    public Bowl(int bowl) {
        this.bowl = bowl;
    }

    public void fillBowl(int needToFill, int restFood) {
        this.bowl += needToFill - restFood;
    }

    public int getBowl() {
        return bowl;
    }

    public void setBowl(int bowl) {
        this.bowl = Math.max(bowl, 0);
    }
}
