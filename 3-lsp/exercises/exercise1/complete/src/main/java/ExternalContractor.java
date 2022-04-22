import java.time.LocalDate;

public class ExternalContractor{
    private String name;
    private int age;
    private LocalDate contractExpirationDate;

    public ExternalContractor(String name, int age, LocalDate contractExpirationDate) {
        this.name = name;
        this.age = age;
        this.contractExpirationDate = contractExpirationDate;
    }
}
