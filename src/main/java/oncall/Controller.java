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
        // 1️⃣ 시작일 정보 입력 + 재입력
        StartDayInfo startDayInfo = readStartDayInfo();
        int month = startDayInfo.getMonth();
        String startDayName = startDayInfo.getDayName();
        int dayCount = DayCounter.countDay(month);

        // 2️⃣ 달력 도메인 생성
        Calendar calendar = new Calendar(month, startDayName, dayCount);

        // 3️⃣ 평일/휴일 근무 순번 입력 + 재입력(휴일이 틀려도 평일부터)
        List<EmployeeName> weekdayEmployees = new ArrayList<>();
        List<EmployeeName> weekendEmployees = new ArrayList<>();
        readEmployees(weekdayEmployees, weekendEmployees);

        // 4️⃣ 스케줄 배정
        ScheduleMaker scheduleMaker = new ScheduleMaker(weekdayEmployees, weekendEmployees);

        List<EmployeeName> scheduledEmployees = new ArrayList<>();
        for (int date = 1; date <= dayCount; date++) {
            boolean isDutyHoliday = calendar.isHoliday(month, date); // 배정 기준(토/일/법정공휴일 포함)
            scheduledEmployees.add(scheduleMaker.pickWorker(isDutyHoliday));
        }

        // 5️⃣ 출력
        for (int i = 0; i < dayCount; i++) {
            int date = i + 1;
            String dayName = calendar.getDayName(date);
            boolean isPrintHoliday = calendar.isLegalHoliday(month, date); // 출력용(평일 공휴일만)

            outputView.printScheduleLine(
                    calendar.getMonth(),
                    date,
                    dayName,
                    isPrintHoliday,
                    scheduledEmployees.get(i)
            );
        }
    }

    // 시작일 입력 재입력
    // 잘못되면 "비상 근무를 배정할 월과 시작 요일"부터 다시
    private StartDayInfo readStartDayInfo() {
        while (true) {
            try {
                String startDate = inputView.readWorkingStartDay();

                List<String> parsed = Parser.splitAndTrim(startDate);
                if (parsed.size() != 2) {
                    throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
                }

                int month = Parser.parseStringToInt(parsed.get(0));
                String dayName = parsed.get(1);

                return new StartDayInfo(month, dayName);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // 평일/휴일 순번 입력 재입력
    // 휴일이 틀려도 평일부터 다시
    private void readEmployees(List<EmployeeName> weekdayList, List<EmployeeName> weekendList) {
        while (true) {
            try {
                weekdayList.clear();
                weekendList.clear();

                String weekdayInput = inputView.readWeekdayWorkingEmployees();
                String weekendInput = inputView.readWeekendWorkingEmployees();

                weekdayList.addAll(toEmployeeNames(weekdayInput));
                weekendList.addAll(toEmployeeNames(weekendInput));
                return;

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<EmployeeName> toEmployeeNames(String input) {
        List<String> tokens = Parser.splitAndTrim(input);

        List<EmployeeName> result = new ArrayList<>();
        for (String token : tokens) {
            result.add(new EmployeeName(token)); // 생성자 검증(메시지는 [ERROR]로 시작)
        }
        return result;
    }
}
