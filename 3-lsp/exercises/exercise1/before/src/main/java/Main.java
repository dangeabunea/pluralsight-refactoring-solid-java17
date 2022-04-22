import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create employees
        var annaSmith = new FullTimeEmployee("Anna Smith", 20);
        annaSmith.setTimeOffDaysTaken(1);

        var johnDoe = new FullTimeEmployee("John Doe", 41);
        johnDoe.setTimeOffDaysTaken(2);

        var contractorDude = new ExternalContractor("Contractor Dude", 30, LocalDate.now().plusYears(1));

        List<Employee> employees = List.of(annaSmith, johnDoe, contractorDude);

        // Run calculation
        var calc = new TimeOffCalculator();
        var result = calc.calculateAvgRemainingTimeOffPerEmployee(employees);

        // External contractors are breaking the average calculation; If they should have no time off days,
        // they should not be taken into account when computing averages.
        // So, we can say that an ExternalContractor does not fully substitute an employee
        System.out.println("AVG TIME OFF IS " + result);
    }
}
