package oncall;

public class Employee {
    private final EmployeeName employeeName;
    private final int workingDay;

    public Employee(EmployeeName employeeName, int workingDay) {
        this.employeeName = employeeName;
        this.workingDay = workingDay;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Employee other = (Employee) obj;
        return employeeName.equals(other.employeeName);
    }

    @Override
    public int hashCode() {
        return employeeName.hashCode();
    }

    // 내가 어제 일했는지 판단
    public boolean isWorked(int day) {
        return workingDay == day;
    }
}
