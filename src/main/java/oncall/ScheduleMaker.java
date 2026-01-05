package oncall;

import java.util.ArrayList;
import java.util.List;

public class ScheduleMaker {
    private final List<EmployeeName> weekdayEmployeeList;
    private final List<EmployeeName> weekendEmployeeList;
    private int weekdayIndex = 0;
    private int weekendIndex = 0;

    public ScheduleMaker(List<EmployeeName> weekdayEmployeeList, List<EmployeeName> weekendEmployeeList) {
        this.weekdayEmployeeList = weekdayEmployeeList;
        this.weekendEmployeeList = weekendEmployeeList;
    }

    // 1일부터 dayCount까지 돌면서, 매일 배정된 이름을 하나씩 만들기
    // employees 수가 dayCount보다 적은 경우 순회시키기
    public List<EmployeeName> makeScheduleForDayCount(Employees employees, int dayCount) {
        List<Employee> employeeList = employees.getEmployeeList();
        List<EmployeeName> employeeNameList = new ArrayList<>();
        int employeeCount = employeeList.size();

        for (int day = 0; day < dayCount; day++) {
            int employeeIndex = day % employeeCount;
            // 근무자 이름 리스트에 추가
            employeeNameList.add(employeeList.get(employeeIndex).getEmployeeName());
        }

        return employeeNameList;
    }

    // 오늘이 휴일인지 알려주면, 근무할 사람 알려 줄게
    public EmployeeName pickWorker(boolean isHoliday) {
        if (!isHoliday) {
            EmployeeName picked = weekdayEmployeeList.get(weekdayIndex);
            weekdayIndex = (weekdayIndex + 1) % weekdayEmployeeList.size(); // 순환
            return picked;
        }

        EmployeeName picked = weekendEmployeeList.get(weekendIndex);
        weekendIndex = (weekendIndex + 1) % weekendEmployeeList.size(); // 순환
        return picked;
    }
}
