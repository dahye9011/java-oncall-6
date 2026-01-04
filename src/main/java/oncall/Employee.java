package oncall;

public class Employee {
    private final EmployeeName employeeName;

    public Employee(EmployeeName employeeName) {
        this.employeeName = employeeName;
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

    public EmployeeName getEmployeeName() {
        return employeeName;
    }
}
