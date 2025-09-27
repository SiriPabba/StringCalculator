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
