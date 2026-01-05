package oncall;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        int month = 0;
        String dayName = "";
        int dayCount = 0;

        while (true) {
            try {
                // 비상 근무를 배정할 월과 시작 요일 입력 받기
                String startDate = inputView.readWorkingStartDay();

                // 입력 월 & 요일 파싱
                List<String> parsed = Parser.splitAndTrim(startDate);
                month = Parser.parseStringToInt(parsed.get(0));
                dayName = parsed.get(1);

                dayCount = DayCounter.countDay(month);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage()); // [ERROR]...
            }
        }

        // 달력 도메인 생성
        Calendar calendar = new Calendar(month, dayName, dayCount);

        // 평일 비상 근무 순번대로 사원 닉네임을 입력 받기
        String weekdayEmployees = inputView.readWeekdayWorkingEmployees();

        // 휴일 비상 근무 순번대로 사원 닉네임을 입력 받기
        String weekendEmployees = inputView.readWeekendWorkingEmployees();

        List<EmployeeName> weekdayList = toEmployeeNames(weekdayEmployees);
        List<EmployeeName> weekendList = toEmployeeNames(weekendEmployees);

        ScheduleMaker scheduleMaker = new ScheduleMaker(weekdayList, weekendList);

        // 근무자 객체 생성
//        List<String> parsedWeekdayEmployees = Parser.splitAndTrim(weekdayEmployees);
//        List<Employee> employeeList = new ArrayList<>();
//        for (int i = 0; i < parsedWeekdayEmployees.size(); i++) {
//            EmployeeName employeeName = new EmployeeName(parsedWeekdayEmployees.get(i));
//            Employee employee = new Employee(employeeName);
//            employeeList.add(employee);
//        }
//
//        Employees employees = new Employees(employeeList);

        // 근무 스케줄 배정
        List<EmployeeName> scheduledEmployeesName = new ArrayList<>();
        for (int date = 1; date <= dayCount; date++) {
            boolean isDutyHoliday = calendar.isHoliday(month, date); // 토/일/법정공휴일 포함
            scheduledEmployeesName.add(scheduleMaker.pickWorker(isDutyHoliday));
        }

        // 반복문 돌면서 1~dayCount일 출력
        for (int i = 0; i < dayCount; i++) {
            int date = i + 1;
            dayName = calendar.getDayName(date);

            boolean isPrintHoliday = calendar.isLegalHoliday(month, date); // 출력용(평일 공휴일만)

            // month, date, dayName, isHoliday, EmployeeName
            outputView.printScheduleLine(
                    calendar.getMonth(),
                    date,
                    dayName,
                    isPrintHoliday,
                    scheduledEmployeesName.get(i));
        }
    }

    private List<EmployeeName> toEmployeeNames(String input) {
        List<String> tokens = Parser.splitAndTrim(input);
        List<EmployeeName> result = new ArrayList<>();
        for (String token : tokens) {
            result.add(new EmployeeName(token));
        }
        return result;
    }
}
