package oncall;

import java.util.List;

public class Calendar {
    private static final List<String> DAYS = List.of("월", "화", "수", "목", "금", "토", "일");

    private final int month;
    private final String dayName; // 1일의 요일
    private final int dayCount; // 일 수

    public Calendar(int month, String dayName, int dayCount) {
        this.month = month;
        this.dayName = dayName;
        this.dayCount = dayCount;
    }

    public int getMonth() {
        return month;
    }

    // 날짜를 알려 주면, 무슨 요일인지 답해 줄게
    public String getDayName(int date) {
        int startIndex = DAYS.indexOf(dayName); // 시작 요일 인덱스 찾기
        int dayIndex = (startIndex + (date - 1)) % 7;
        return DAYS.get(dayIndex);
    }

    public int getDayCount() {
        return dayCount;
    }

    public boolean isHoliday(int month, int date) {
        String dayName = getDayName(date);

        // 토/일이면 휴일
        if (dayName.equals("토") || dayName.equals("일")) {
            return true;
        }

        // 법정공휴일이면 휴일
        return isLegalHoliday(month, date);
    }

    public boolean isLegalHoliday(int month, int date) {
        if (month == 1 && date == 1) {
            return true;
        }
        if (month == 3 && date == 1) {
            return true;
        }
        if (month == 5 && date == 5) {
            return true;
        }
        if (month == 6 && date == 6) {
            return true;
        }
        if (month == 8 && date == 15) {
            return true;
        }
        if (month == 10 && (date == 3 || date == 9)) {
            return true;
        }
        if (month == 12 && date ==25) {
            return true;
        }
        return false;
    }
}
