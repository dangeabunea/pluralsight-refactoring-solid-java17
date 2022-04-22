import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BugTests {
    @Test
    public void containsOverrideCloseMethod(){
        var  method = TestHelpers.getMethod("Bug", "close");
        assertTrue(method.isPresent());

        var methodDeclaringClass = method.get().getDeclaringClass().getName();
        assertEquals("Bug", methodDeclaringClass, "The close method is not declared in the Bug class");
    }
}
