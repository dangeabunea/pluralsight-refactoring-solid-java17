import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TimeOffCalculatorTests {
    @Test
    public void shouldCalculateCorrectAverage() {
        var annaSmith = new FullTimeEmployee("Anna Smith", 20);
        annaSmith.setTimeOffDaysTaken(1);

        var johnDoe = new FullTimeEmployee("John Doe", 41);
        johnDoe.setTimeOffDaysTaken(2);

        List<Employee> employees = List.of(annaSmith, johnDoe);

        var calc = new TimeOffCalculator();
        var result = calc.calculateAvgRemainingTimeOffPerEmployee(employees);

        assertEquals(20, result, 0.01);
    }
}
