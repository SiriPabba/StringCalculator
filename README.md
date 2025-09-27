public class StringCalculator {

	    public static int add(String numbers) {
	        if (numbers == null || numbers.isEmpty()) {
	            return 0; // Step 1
	        }

	        String delimiter = ",|\n"; // default delimiters: comma or newline

	        // Step 5: Check for custom delimiter
	        if (numbers.startsWith("//")) {
	            int delimiterIndex = numbers.indexOf("\n");
	            delimiter = numbers.substring(2, delimiterIndex);
	            numbers = numbers.substring(delimiterIndex + 1);
	        }

	        // Split numbers using delimiters
	        String[] numArray = numbers.split(delimiter);

	        int sum = 0;
	        StringBuilder negatives = new StringBuilder();

	        for (String num : numArray) {
	            if (!num.isEmpty()) {
	                int n = Integer.parseInt(num.trim());

	                // Step 6: Check for negatives
	                if (n < 0) {
	                    if (negatives.length() > 0) {
	                        negatives.append(",");
	                    }
	                    negatives.append(n);
	                }

	                sum += n;
	            }
	        }

	        if (negatives.length() > 0) {
	            throw new IllegalArgumentException("negative numbers not allowed " + negatives);
	        }

	        return sum;
	    }

	    // Quick test
	    public static void main(String[] args) {
	        System.out.println(add(""));             // 0
	        System.out.println(add("1"));            // 1
	        System.out.println(add("1,5"));          // 6
	        System.out.println(add("1\n2,3"));       // 6
	        System.out.println(add("//;\n1;2;3"));   // 6
	        // System.out.println(add("1,-2,3,-4")); // Exception: negative numbers not allowed -2,-4
	    }
	}

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

    @Test
    void emptyStringReturnsZero() {
        assertEquals(0, StringCalculator.add(""));
    }

    @Test
    void singleNumberReturnsValue() {
        assertEquals(1, StringCalculator.add("1"));
    }

    @Test
    void twoNumbersCommaSeparated() {
        assertEquals(6, StringCalculator.add("1,5"));
    }

    @Test
    void multipleNumbers() {
        assertEquals(10, StringCalculator.add("1,2,3,4"));
    }

    @Test
    void newLineAsDelimiter() {
        assertEquals(6, StringCalculator.add("1\n2,3"));
    }

    @Test
    void customDelimiterSemicolon() {
        assertEquals(3, StringCalculator.add("//;\n1;2"));
    }

    @Test
    void negativeNumbersThrowException() {
        Exception ex = assertThrows(IllegalArgumentException.class,
            () -> StringCalculator.add("1,-2,3,-4"));
        assertEquals("negative numbers not allowed -2,-4", ex.getMessage());
    }
}


	
	

}
}
