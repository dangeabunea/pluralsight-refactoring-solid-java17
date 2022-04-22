import java.util.List;

public class TaskManager {
    public void closeAll(List<Task> tasks) {
        for (var task : tasks) {
            task.close();
        }
    }
}
