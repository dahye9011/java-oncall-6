package oncall;

public class EmployeeName {
    private static final int MAX_NAME_SIZE = 5;
    private final String value;

    public EmployeeName(String value) {
        validateEmployeeName(value);
        this.value = value;
    }

    private void validateEmployeeName(String value) {
        validateNotBlank(value);
        validateNameLength(value);
    }

    private void validateNotBlank(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 근무자 이름은 비어있을 수 없습니다.");
        }
    }

    private void validateNameLength(String value) {
        if (value.length() > MAX_NAME_SIZE) {
            throw new IllegalArgumentException("[ERROR] 이름 길이는 최대 5자까지 가능합니다.");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        EmployeeName other = (EmployeeName) obj;
        return value.equals(other.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public String getValue() {
        return value;
    }
}
