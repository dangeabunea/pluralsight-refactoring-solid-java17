import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PayPalPaymentServiceTests {
    @Test
    public void interfaceExists() {
        var result =  TestHelpers.getClass("PayPalPaymentService").isPresent();
        assertTrue(result, "Interface PayPalPaymentService does not exist");
    }

    @Test
    public void payUsingPayPalMethodExists() {
        var result =  TestHelpers.getMethod("PayPalPaymentService", "payUsingPayPal").isPresent();
        assertTrue(result, "Method does not exist on PayPalPaymentService");
    }
}
