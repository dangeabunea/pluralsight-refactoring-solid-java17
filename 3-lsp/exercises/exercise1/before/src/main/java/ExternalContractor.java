import java.time.LocalDate;

public class ExternalContractor extends Employee {
    private LocalDate contractExpirationDate;

    public ExternalContractor(String name, int age, LocalDate contractExpirationDate) {
        super(name, age);
        this.contractExpirationDate = contractExpirationDate;
    }

    @Override
    public int calculateRemainingTimeOff() {
        // Contractors do not have time off, but we
        // are forced to implement method. So, we make it return 0
        return 0;
    }
}
