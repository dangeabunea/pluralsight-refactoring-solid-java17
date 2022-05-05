public interface PaymentService {
    void payUsingCard(double amount, String cardNumber, String ccv);
    void payUsingPayPal(double amount, String accountName);
    void payUsingBankTransfer(double amount, String ibanCode);
}
