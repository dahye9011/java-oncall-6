package oncall;

import org.junit.jupiter.api.Test;

public class OutputViewTest {
    @Test
    void 출력_포맷_테스트() {
        // given
        OutputView outputView = new OutputView();
        int month = 5;
        int date = 5;
        String dayName = "금";
        boolean isHoliday = true;
        EmployeeName employeeName = new EmployeeName("다혜");

        // when & then
        outputView.printScheduleLine(month, date, dayName, isHoliday, employeeName);
    }
}
