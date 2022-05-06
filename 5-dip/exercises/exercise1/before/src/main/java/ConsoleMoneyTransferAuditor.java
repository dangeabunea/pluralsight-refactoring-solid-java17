import java.text.MessageFormat;

public class ConsoleMoneyTransferAuditor {
    public void logTransfer(BankAccount from, BankAccount to, double amount) {
        System.out.println(MessageFormat.format(
                "Transferred ${0} from {1}, to {2}",
                from.getId(), to.getId(), amount));
    }

    public void logInsufficientFunds(BankAccount from, double amount) {
        System.out.println(MessageFormat.format(
                "Insufficient funds. Can not transfer ${0} from {1}. Current amount is {2}",
                amount, from.getId(), from.getAmount()));
    }
}
