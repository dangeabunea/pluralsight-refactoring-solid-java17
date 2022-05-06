public interface MoneyTransferAuditor {
    void logTransfer(BankAccount from, BankAccount to, double amount);
    void logInsufficientFunds(BankAccount from, double amount);
}
