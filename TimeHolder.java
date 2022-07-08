package sample;

public class TimeHolder {

    private String timeOfBooking;
    private final static TimeHolder INSTANCE = new TimeHolder();

    TimeHolder() {
    }

    public static TimeHolder getInstance() {
        return INSTANCE;
    }

    public void setTimeOfBooking(String u) {
        this.timeOfBooking = u;
    }

    public String getTimeOfBooking() {
        return this.timeOfBooking;
    }

}
