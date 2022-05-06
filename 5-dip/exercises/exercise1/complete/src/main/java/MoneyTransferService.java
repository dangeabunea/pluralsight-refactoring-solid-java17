public class MoneyTransferService {
    private MoneyTransferAuditor auditor;

    public MoneyTransferService(MoneyTransferAuditor auditor) {
        this.auditor = auditor;
    }

    public void transfer(BankAccount from, BankAccount to, double amount) {
        if (from == null || to == null) {
            throw new IllegalArgumentException("Bank accounts must not be null");
        }
        if (amount < 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }

        if (from.getAmount() < amount) {
            auditor.logInsufficientFunds(from, amount);
            return;
        }

        // Perform transfer
        from.withdraw(amount);
        to.add(amount);
        auditor.logTransfer(from, to, amount);
    }
}
