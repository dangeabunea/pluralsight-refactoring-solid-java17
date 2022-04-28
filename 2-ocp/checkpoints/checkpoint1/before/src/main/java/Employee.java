public class Employee {
    private String name;
    private double income;
    private String nationality;

    public Employee(String name, double income, String nationality) {
        this.name = name;
        this.income = income;
        this.nationality = nationality;
    }

    public String getName() {
        return name;
    }

    public double getIncome() {
        return income;
    }

    public String getNationality() {
        return nationality;
    }
}
