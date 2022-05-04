import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaxCalculatorTests {
    @Test
    public void shouldCalculateTaxes(){
        var employees = List.of(
                new Employee("John Smith", 60000.0, "USA"),
                new Employee("Anna Smith", 40000.0, "USA"),
                new Employee("Pierre Evra", 30000.0, "France"),
                new Employee("Bogdan Stancu", 9000.0, "Romania")
        );

        var calc = new TaxCalculator();
        var result = calc.calculateTotalTaxes(employees);

        assertEquals(39400.0, result, 0.1);
    }

    @Test
    public void shouldCalculateTaxesWithNationality() throws InvocationTargetException, IllegalAccessException {
        var employees = List.of(
                new Employee("John Smith", 60000.0, "USA"),
                new Employee("Anna Smith", 40000.0, "USA"),
                new Employee("Pierre Evra", 30000.0, "France"),
                new Employee("Bogdan Stancu", 9000.0, "Romania")
        );

        var calc = new TaxCalculator();
        var method = TestHelpers.getMethod("TaxCalculator", "calculateTotalTaxesWithNationalityDetails");
        double result = (double) method.get().invoke(calc, employees);

        assertEquals(43300.0, result, 0.1);
    }
}
