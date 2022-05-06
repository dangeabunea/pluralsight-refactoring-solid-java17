public class EmployeeIncomeCalculator {
    private EmployeeApi employeeApiService;

    public EmployeeIncomeCalculator(EmployeeApi employeeRestApiService) {
        this.employeeApiService = employeeRestApiService;
    }

    public double calculateAvgIncome(){
        var employees = employeeApiService.findAll();
        return employees.stream()
                .mapToInt(Employee::income)
                .average()
                .getAsDouble();
    }
}
