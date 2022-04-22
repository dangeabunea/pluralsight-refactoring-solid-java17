import java.util.List;

public class TimeOffCalculator {
    public double calculateAvgRemainingTimeOffPerEmployee(List<Employee> employees){
        if(employees.size() == 0){
            return 0;
        }

        var totalRemainingTimeOff = employees.stream().mapToInt(Employee::calculateRemainingTimeOff).sum();
        var totalEmployees = employees.size();

        return (double)totalRemainingTimeOff / (double)totalEmployees;
    }
}
