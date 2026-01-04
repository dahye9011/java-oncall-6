package oncall;

public class OutputView {
    public void printScheduleLine(int month, int date, String dayName, boolean isHoliday, EmployeeName employeeName) {
        String holiday = "";

        if (isHoliday) {
            holiday = "(휴일)";
        }

        System.out.println(month + "월 " + date + "일 " + dayName + holiday + " " + employeeName.getValue());
    }
}
