// Parents usually need to be alerted via text and internal application
public class KindergartenNotificationService implements NotificationService {
    private String internalApiUrl = "https://mykindergarden.com/api/v1/broadcast";

    @Override
    public void sendTextMessage(String phoneNb, String text) {
        System.out.println("Sending to " + phoneNb + " message " + text);
    }

    @Override
    public void sendEmail(String to, String text) {
        // No implementation
        return;
    }

    @Override
    public void sendInInternalApplication(String text) {
        System.out.println("Sending to " + internalApiUrl + " message " + text);
    }

    @Override
    public void sendSlackMessage(String slackUser, String text) {
        // No implementation
        return;
    }
}
