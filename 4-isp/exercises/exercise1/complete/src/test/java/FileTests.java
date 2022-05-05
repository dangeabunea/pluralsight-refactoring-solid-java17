import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FileTests {
    @Test
    public void emailNotificationServiceInterfaceExists() {
        var result = TestHelpers.getClass("EmailNotificationService").isPresent();
        assertTrue(result, "Interface EmailNotificationService not created");
    }

    @Test
    public void emailNotificationServiceInterfaceHasMethod() {
        var result = TestHelpers.getMethod("EmailNotificationService", "sendEmail").isPresent();
        assertTrue(result, "Interface EmailNotificationService does not have notification method");
    }

    @Test
    public void textNotificationServiceInterfaceExists() {
        var result = TestHelpers.getClass("TextNotificationService").isPresent();
        assertTrue(result, "Interface TextNotificationService not created");
    }

    @Test
    public void textNotificationServiceInterfaceHasMethod() {
        var result = TestHelpers.getMethod("TextNotificationService", "sendTextMessage").isPresent();
        assertTrue(result, "Interface TextNotificationService does not have notification method");
    }

    @Test
    public void slackNotificationServiceInterfaceExists() {
        var result = TestHelpers.getClass("SlackNotificationService").isPresent();
        assertTrue(result, "Interface SlackNotificationService not created");
    }

    @Test
    public void slackNotificationServiceInterfaceHasMethod() {
        var result = TestHelpers.getMethod("SlackNotificationService", "sendSlackMessage").isPresent();
        assertTrue(result, "Interface SlackNotificationService does not have notification method");
    }

    @Test
    public void internalApplicationNotificationServiceInterfaceExists() {
        var result = TestHelpers.getClass("InternalApplicationNotificationService").isPresent();
        assertTrue(result, "Interface InternalApplicationNotificationService not created");
    }

    @Test
    public void internalApplicationNotificationServiceInterfaceHasMethod() {
        var result = TestHelpers.getMethod("InternalApplicationNotificationService", "sendInInternalApplication").isPresent();
        assertTrue(result, "Interface InternalApplicationNotificationService does not have notification method");
    }

    @Test
    public void notificationServiceInterfaceDeleted(){
        var result = TestHelpers.getClass("NotificationService").isPresent();
        assertTrue(result, "Interface NotificationService not created");
    }
}
