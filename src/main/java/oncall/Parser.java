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
}
