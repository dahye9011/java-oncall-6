package oncall;

import java.util.ArrayList;
import java.util.List;

public class ScheduleMaker {
    // 1일부터 dayCount까지 돌면서, 매일 배정된 이름을 하나씩 만들기
    public List<EmployeeName> makeScheduleForDayCount(Employees employees, int dayCount) {
        List<Employee> employeeList = employees.getEmployeeList();
        List<EmployeeName> employeeNameList = new ArrayList<>();

        for (int i = 0; i < dayCount; i++) {
            employeeNameList.add(employeeList.get(i).getEmployeeName());
        }

        return employeeNameList;
    }
}
