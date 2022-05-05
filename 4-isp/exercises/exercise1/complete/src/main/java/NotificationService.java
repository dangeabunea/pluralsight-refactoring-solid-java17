// Generic notification interface
public interface NotificationService {
    void sendTextMessage(String phoneNb, String text);
    void sendEmail(String to, String text);
    void sendInInternalApplication(String text);
    void sendSlackMessage(String slackUser, String text);
}

