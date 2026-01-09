package oncall;

public class StartDayInfo {
    private final int month;
    private final String dayName;

    public StartDayInfo(int month, String dayName) {
        this.month = month;
        this.dayName = dayName;
    }

    public int getMonth() {
        return month;
    }

    public String getDayName() {
        return dayName;
    }
}
