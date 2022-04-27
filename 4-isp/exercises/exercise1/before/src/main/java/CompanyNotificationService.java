// A private company will probably choose to alert
// employees via Slack and email
public class CompanyNotificationService implements NotificationService {
    @Override
    public void sendTextMessage(String phoneNb, String text) {
        // No implementation
        return;
    }

    @Override
    public void sendEmail(String to, String text) {
        System.out.println("Sending to " + to + " message " + text);
    }

    @Override
    public void sendInInternalApplication(String apiUrl) {
        // No implementation
        return;
    }

    @Override
    public void sendSlackMessage(String slackUser, String text) {
        System.out.println("Sending to " + slackUser + " message " + text);
    }
}
