import java.util.List;

public class EmployeeRestApiService {
    public List<Employee> findAll(){
        System.out.println("Faking call to http://localhost/employees");
        return List.of(
                new Employee("John Smith", 40000),
                new Employee("Anna Smith", 80000),
                new Employee("Robert Carey", 60000),
                new Employee("Linda Brighton", 50000)
        );
    }
}
