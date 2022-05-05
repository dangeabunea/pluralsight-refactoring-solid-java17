import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class KindergartenNotificationServiceTests {
    @Test
    public void doesNotHaveUnneededMethods(){
        var hasSendEmailMethod = TestHelpers.getMethod("KindergartenNotificationService", "sendEmail").isPresent();
        var hasSendSlackMessageMethod = TestHelpers.getMethod("KindergartenNotificationService", "sendSlackMessage").isPresent();

        assertFalse(hasSendEmailMethod);
        assertFalse(hasSendSlackMessageMethod);
    }
}
