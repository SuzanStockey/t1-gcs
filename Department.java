public class Department {
    private String name;
    private double maxRequestAmount;

    public Department(String name, double maxRequestAmount) {
        this.name = name;
        this.maxRequestAmount = maxRequestAmount;
    }

    public String getName() {
        return name;
    }

    public double getMaxRequestAmount() {
        return maxRequestAmount;
    }
}