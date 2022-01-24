package sample;

public final class DateHolder {

    private String date;
    private final static DateHolder INSTANCE = new DateHolder();

    DateHolder() {
    }

    public static DateHolder getInstance() {
        return INSTANCE;
    }

    public void setDate(String u) {
        this.date = u;
    }

    public String getDate() {
        return this.date;
    }
}

