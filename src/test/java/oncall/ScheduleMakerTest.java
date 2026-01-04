package oncall;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ScheduleMakerTest {
    @DisplayName("")
    @Test
    public void 테스트() {
        // given
        ScheduleMaker scheduleMaker = new ScheduleMaker();
        List<Employee> employeeList = List.of(
                new Employee(new EmployeeName("A"), 1),
                new Employee(new EmployeeName("B"), 2),
                new Employee(new EmployeeName("C"), 3),
                new Employee(new EmployeeName("D"), 4),
                new Employee(new EmployeeName("E"), 5)
        );
        Employees employees = new Employees(employeeList);

        // when
        Schedules schedules = scheduleMaker.makeSchedules(employees, 5);

        // then
//        assertThat().isEqualTo();
        assertThat(schedules).isNotNull();
//        System.out.println(schedules.getScheduleList().get(2).getSchedule());
    }
}
