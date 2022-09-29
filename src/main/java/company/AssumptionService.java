package company;

import java.util.Arrays;
import java.util.Map;

public class AssumptionService {

    private static final Map<String, Assumption> assumptions = Map.of(
            "M", new Assumption(1000, 7),
            "D", new Assumption(500, 6),
            "C", new Assumption(100, 5),
            "L", new Assumption(50, 4),
            "X", new Assumption(10, 3),
            "V", new Assumption(5, 2),
            "I", new Assumption(1, 1)
    );
    public static final String INVALID_NUMBER = "Invalid number";

    public int readNumber(String numbers) {
        numbers = numbers.replaceAll("\\s+","");
        boolean b = Arrays.stream(numbers.split("")).anyMatch(s -> !assumptions.containsKey(s));
        if (b) {
            throw new IllegalStateException("Illegal letter");
        }
        int result = 0;
        for (int i = 0; i < numbers.length(); i ++) {
            String v = String.valueOf(numbers.charAt(i));
            checkForFourSameCharacters(numbers, v);
            if (i+1 < numbers.length()) {
                v = v + numbers.charAt(i + 1);
            }
            result += readPrimitiveNumber(v);
        }
        System.out.println(result);
        return result;
    }

    private void checkForFourSameCharacters(String numbers, String character) {
        String s = character + character + character + character;
        if (numbers.contains(s)) {
            throw new IllegalStateException(INVALID_NUMBER);
        }
    }

    private int readPrimitiveNumber(String number) {
        Assumption first = assumptions.get(String.valueOf(number.charAt(0)));
        if (number.length() == 1) {
            return first.getArabicValue();
        }
        Assumption second = assumptions.get(String.valueOf(number.charAt(1)));

        if (first.getWeight() < second.getWeight()) {
            if (first.getArabicValue() * 2 == second.getArabicValue()) {
                throw new IllegalStateException("Invalid number");
            }
            return -first.getArabicValue();
        }
        if (first.getWeight() > second.getWeight()) {
            return first.getArabicValue();
        }
        if (first.getWeight() == second.getWeight()) {
            if (first.getWeight() % 2 == 1) {
                return first.getArabicValue();
            }
        }
        throw new IllegalStateException("Invalid number");
    }
}
