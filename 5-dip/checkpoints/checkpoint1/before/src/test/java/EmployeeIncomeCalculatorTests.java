import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeIncomeCalculatorTests {
    @Test
    public void shouldCalculateAvgIncomes() {
        var restApiService = new EmployeeRestApiService();
        var incomeCalc= new EmployeeIncomeCalculator(restApiService);

        var result = incomeCalc.calculateAvgIncome();

        assertEquals(result, 57500.0, 0.1);
    }
}
