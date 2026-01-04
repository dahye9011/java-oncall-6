package oncall;

import java.util.List;

public class Schedules {
    private final List<Schedule> scheduleList;

    public Schedules(List<Schedule> scheduleList) {
        this.scheduleList = scheduleList;
    }

    public List<Schedule> getScheduleList() {
        return scheduleList;
    }
}
