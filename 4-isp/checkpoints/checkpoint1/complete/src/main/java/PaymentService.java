public interface PaymentService {
    void payUsingCard(double amount, String cardNumber, String ccv);
    void payUsingBankTransfer(double amount, String ibanCode);
}
