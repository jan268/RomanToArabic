package company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AssumptionServiceTest {

    private final AssumptionService assumptionService = new AssumptionService();

    @Test
    void TestPositive() {
        assertEquals(assumptionService.readNumber("III"), 3);
        assertEquals(assumptionService.readNumber("IV "), 4);
        assertEquals(assumptionService.readNumber("V"), 5);
        assertEquals(assumptionService.readNumber("VI"), 6);
        assertEquals(assumptionService.readNumber("VII "), 7);
        assertEquals(assumptionService.readNumber("VIII "), 8);
        assertEquals(assumptionService.readNumber("IX "), 9);
        assertEquals(assumptionService.readNumber("XLIV "), 44);
        assertEquals(assumptionService.readNumber("MCMLXXXVI"), 1986);
    }

    @Test
    void TestNegative() {
        checkException("Illegal letter", "ABC");
        checkException("Invalid number", "LL");
        checkException("Invalid number", "IIII");
    }

    private void checkException(String expectedMessage, String number) {
        Exception exception = assertThrows(IllegalStateException.class, () -> assumptionService.readNumber(number));
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}