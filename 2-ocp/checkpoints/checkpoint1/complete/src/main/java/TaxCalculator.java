import java.util.List;

public class TaxCalculator {
    @Deprecated(forRemoval = true)
    public double calculateTotalTaxes(List<Employee> employees) {
        var taxes = 0.0;

        for (var e : employees) {
            var tax =  calculateTaxForEmployee(e);
            taxes += tax;
        }

        return taxes;
    }

    public double calculateTotalTaxesWithNationalityDetails(List<Employee> employees){
        var taxes = 0.0;

        for (var e : employees) {
            var tax =  calculateTaxForEmployee(e);

            // take nationality into consideration
            if(!e.getNationality().equals("USA")){
                tax += e.getIncome() * 0.1;
            }

            taxes += tax;
        }

        return taxes;
    }

    private double calculateTaxForEmployee(Employee e) {
        double employeeTaxes = 0;
        if (e.getIncome() < 10000) {
            // 10% taxes
            employeeTaxes = e.getIncome() * 0.1;
        } else if (e.getIncome() >= 10000 && e.getIncome() < 50000) {
            // 20% taxes
            employeeTaxes= e.getIncome() * 0.25;
        } else if (e.getIncome() >= 50000) {
            // 30% taxes
            employeeTaxes= e.getIncome() * 0.35;
        }

        return employeeTaxes;
    }
}
