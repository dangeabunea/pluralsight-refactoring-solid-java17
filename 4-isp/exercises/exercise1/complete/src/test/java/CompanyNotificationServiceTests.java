import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CompanyNotificationServiceTests {
    @Test
    public void doesNotHaveUnneededMethods(){
        var hasSendEmailMethod = TestHelpers.getMethod("CompanyNotificationService", "sendTextMessage").isPresent();
        var hasSendSlackMessageMethod = TestHelpers.getMethod("CompanyNotificationService", "sendInInternalApplication").isPresent();

        assertFalse(hasSendEmailMethod);
        assertFalse(hasSendSlackMessageMethod);
    }
}
