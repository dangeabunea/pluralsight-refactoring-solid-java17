import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create employees
        var annaSmith = new FullTimeEmployee("Anna Smith", 20);
        annaSmith.setTimeOffDaysTaken(1);

        var johnDoe = new FullTimeEmployee("John Doe", 41);
        johnDoe.setTimeOffDaysTaken(2);

        List<Employee> employees = List.of(annaSmith, johnDoe);

        // Run calculation
        var calc = new TimeOffCalculator();
        var result = calc.calculateAvgRemainingTimeOffPerEmployee(employees);

        System.out.println("AVG TIME OFF IS " + result);
    }
}
