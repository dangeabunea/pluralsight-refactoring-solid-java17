import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class PaymentServiceTests {

    @Test
    public void payUsingPayPalNotExists() {
        var result =  TestHelpers.getMethod("PaymentService", "payUsingPayPal").isPresent();
        assertFalse(result, "Method still exists on interface PaymentService");
    }
}
