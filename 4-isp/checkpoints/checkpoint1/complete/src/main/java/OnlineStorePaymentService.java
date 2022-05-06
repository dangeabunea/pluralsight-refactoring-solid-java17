public class OnlineStorePaymentService implements PaymentService {
    @Override
    public void payUsingCard(double amount, String cardNumber, String ccv) {
        BankGateway.processCardPayment(amount, cardNumber, ccv);
    }

    @Override
    public void payUsingBankTransfer(double amount, String ibanCode) {
        BankGateway.processBankPayment(amount, ibanCode);
    }
}
