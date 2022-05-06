import java.util.UUID;

public class BankAccount {
    private UUID id;
    private String owner;
    private double amount;

    public BankAccount(String owner, double initialAmount){
        this.owner= owner;
        this.amount = initialAmount;
        this.id = UUID.randomUUID();
    }

    public void withdraw(double amountToWithdraw){
        this.amount -= amountToWithdraw;
    }

    public void add(double amountToAdd){
        this.amount += amountToAdd;
    }

    public UUID getId() {
        return id;
    }

    public String getOwner() {
        return owner;
    }

    public double getAmount() {
        return amount;
    }
}
