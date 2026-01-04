package oncall;

import java.util.Arrays;
import java.util.List;

public class Parser {
    public static List<String> splitAndTrim(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .toList();
    }

    public static int parseStringToInt(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] ~은 숫자여야 합니다.");
        }
    }
}
