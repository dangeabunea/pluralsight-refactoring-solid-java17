import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskManagerTests {

    @Test
    public void shouldNotCloseBugsThatWereNotVerified(){
        var tasks = List.of(
                new Feature("Implement button for save feature", 2),
                new Feature("Implement DB connection", 6),
                new Bug("Fix localization issues", 3)
        );

        var tm = new TaskManager();
        tm.closeAll(tasks);

        assertEquals(2, tasks.stream().filter(t -> !t.isOpen()).toList().size());
    }

    @Test
    public void shouldCloseBugsThatWereNotVerified(){
        var verifiedBug = new Bug("Fix localization issues", 3);
        verifiedBug.setVerifiedByCustomer(true);

        var tasks = List.of(
                new Feature("Implement button for save feature", 2),
                new Feature("Implement DB connection", 6),
                verifiedBug
        );

        var tm = new TaskManager();
        tm.closeAll(tasks);

        assertEquals(3, tasks.stream().filter(t -> !t.isOpen()).toList().size());
    }
}
