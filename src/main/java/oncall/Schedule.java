package oncall;

import java.util.Map;

public class Schedule {
    private final Map<Integer, EmployeeName> schedule;

    public Schedule(Map<Integer, EmployeeName> schedule) {
        this.schedule = schedule;
    }

    public Map<Integer, EmployeeName> getSchedule() {
        return schedule;
    }
}
