import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OnlineStorePaymentServiceTests {
    @Test
    public void payUsingCardExists() {
        var result =  TestHelpers.getMethod("OnlineStorePaymentService", "payUsingCard").isPresent();
        assertTrue(result, "payUsingCard does not exist on OnlineStorePaymentService");
    }

    @Test
    public void payUsingBankTransferExists() {
        var result =  TestHelpers.getMethod("OnlineStorePaymentService", "payUsingBankTransfer").isPresent();
        assertTrue(result, "payUsingBankTransfer does not exist on OnlineStorePaymentService");
    }

    @Test
    public void payUsingPayPalNotExists() {
        var result =  TestHelpers.getMethod("OnlineStorePaymentService", "payUsingPayPal").isPresent();
        assertFalse(result, "payUsingPayPal still exists on OnlineStorePaymentService");
    }
}
