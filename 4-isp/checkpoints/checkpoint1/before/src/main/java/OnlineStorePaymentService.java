public class OnlineStorePaymentService implements PaymentService {
    @Override
    public void payUsingCard(double amount, String cardNumber, String ccv) {
        BankGateway.processCardPayment(amount, cardNumber, ccv);
    }

    @Override
    public void payUsingPayPal(double amount, String accountName) {
        throw new RuntimeException("Can not support this payment method");
    }

    @Override
    public void payUsingBankTransfer(double amount, String ibanCode) {
        BankGateway.processBankPayment(amount, ibanCode);
    }
}
