package oncall;

public class EmployeeName {
    private final String value;

    public EmployeeName(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
