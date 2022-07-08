package sample;

public final class DinerHolder {

    private int numberOfDiners;
    private final static DinerHolder INSTANCE = new DinerHolder();

    DinerHolder() {
    }

    public static DinerHolder getInstance() {
        return INSTANCE;
    }

    public void setNumberOfDiners(int u) {
        this.numberOfDiners = u;
    }

    public int getNumberOfDiners() {
        return this.numberOfDiners;
    }
}
