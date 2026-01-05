package oncall;

public class OutputView {
    public void printScheduleLine(int month, int date, String dayName, boolean isLegalHoliday, EmployeeName employeeName) {
        System.out.println(formatScheduleLine(month, date, dayName, isLegalHoliday, employeeName));
    }

    public String formatScheduleLine(int month, int date, String dayName, boolean isLegalHoliday, EmployeeName employeeName) {
        String holiday = " ";

        if (isLegalHoliday) {
            holiday = "(휴일) ";
        }

        return month + "월 " + date + "일 " + dayName + holiday + employeeName;
    }
}
