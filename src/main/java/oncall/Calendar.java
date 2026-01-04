package oncall;

public class Calendar {
    private final int month;
    private final String startDay; // 요일
    private final int dayCount; // 일 수

    public Calendar(int month, String startDay, int dayCount) {
        this.month = month;
        this.startDay = startDay;
        this.dayCount = dayCount;
    }

    public int getMonth() {
        return month;
    }

    public String getStartDay() {
        return startDay;
    }

    public int getDayCount() {
        return dayCount;
    }
}
