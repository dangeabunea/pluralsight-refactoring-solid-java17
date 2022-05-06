public class EmployeeIncomeCalculator {
    private EmployeeRestApiService employeeApiService;

    /*
    We are passing dependencies in the construcotr, which is great. But we are not
    using abstractions. This high level component still depends on a low level
    rest service
     */
    public EmployeeIncomeCalculator(EmployeeRestApiService employeeRestApiService) {
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
