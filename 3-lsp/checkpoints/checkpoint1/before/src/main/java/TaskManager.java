import java.util.List;

public class TaskManager {
    public void closeAll(List<Task> tasks) {
        for (var task : tasks) {
            // Bugs can only be closed after they were verified by the customer
            if (task instanceof Bug) {
                if (((Bug) task).isVerifiedByCustomer()) {
                    task.close();
                }
            } else {
                task.close();
            }
        }
    }
}
