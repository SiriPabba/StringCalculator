import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculator {

    public static int add(String numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }

        String delimiterRegex = ",|\n";

        // Check for custom delimiter
        if (numbers.startsWith("//")) {
            int newlineIndex = numbers.indexOf("\n");
            String customDelimiter = numbers.substring(2, newlineIndex);
            delimiterRegex = Pattern.quote(customDelimiter);
            numbers = numbers.substring(newlineIndex + 1);
        }

        String[] tokens = numbers.split(delimiterRegex);
        List<Integer> negatives = new ArrayList<>();
        int sum = 0;

        for (String token : tokens) {
            if (token.isBlank()) continue;
            int n = Integer.parseInt(token.trim());
            if (n < 0) negatives.add(n);
            sum += n;
        }

        if (!negatives.isEmpty()) {
            String msg = negatives.stream()
                                  .map(String::valueOf)
                                  .collect(Collectors.joining(","));
            throw new IllegalArgumentException("negative numbers not allowed " + msg);
        }

        return sum;
    }
}
