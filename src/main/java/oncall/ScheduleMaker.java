package oncall;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ScheduleMaker {
    public Schedules makeSchedules(Employees employees, int dayCount) {
        List<Employee> employeeList = employees.getEmployeeList();
        List<Schedule> scheduleList = new ArrayList<>();

        for (int i = 0; i < dayCount; i++) {
            Map<Integer, EmployeeName> map = employeeList.stream()
                    .collect(Collectors.toMap(e -> e.getWorkingDay(), // 근무 날짜
                            e -> e.getEmployeeName())); // 근무자 이름
            scheduleList.add(new Schedule(map));
        }

        return new Schedules(scheduleList);
    }
}
