package company;

public class Assumption {

    private Integer arabicValue;
    private int weight;

    public Assumption(Integer arabicValue, int weight) {
        this.arabicValue = arabicValue;
        this.weight = weight;
    }

    public Integer getArabicValue() {
        return arabicValue;
    }

    public int getWeight() {
        return weight;
    }
}
