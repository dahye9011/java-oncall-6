package oncall;

import java.util.List;
import java.util.Set;

public class Employees {
    private static final int MIN_EMPLOYEES_SIZE = 5;
    private static final int MAX_EMPLOYEES_SIZE = 35;
    private final List<Employee> employeeList;

    public Employees(List<Employee> employeeList) {
        validateEmployees(employeeList);
        this.employeeList = employeeList;
    }

    private void validateEmployees(List<Employee> employeeList) {
        validateNotEmpty(employeeList);
        validateSize(employeeList);
        validateDuplicate(employeeList);
    }

    private void validateNotEmpty(List<Employee> employeeList) {
        if (employeeList == null || employeeList.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 근무자 목록은 비어 있을 수 없습니다.");
        }
    }

    private void validateSize(List<Employee> employeeList) {
        if (employeeList.size() < MIN_EMPLOYEES_SIZE || employeeList.size() > MAX_EMPLOYEES_SIZE) {
            throw new IllegalArgumentException("[ERROR] 근무자 인원수는 5~35명이어야 합니다.");
        }
    }

    private void validateDuplicate(List<Employee> employeeList) {
        if (Set.copyOf(employeeList).size() != employeeList.size()) {
            throw new IllegalArgumentException("[ERROR] 근무자는 중복될 수 없습니다.");
        }
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }
}
