package company;

public class Main {

    public static void main(String[] args) {
        AssumptionService assumption = new AssumptionService();

        int result = assumption.readNumber("XLIV");
        System.out.println(result);
    }

}
