import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CircleTests {

    @Test
    public void shouldImplementIsPointInAreaMethod() throws InvocationTargetException, IllegalAccessException {
        var circle = new Circle(0,0,10);

        var method = TestHelpers.getMethod("Circle", "isPointInsideArea");

        boolean result1 = (boolean) method.get().invoke(circle, 4,4);
        assertTrue(result1);

        boolean result2 = (boolean) method.get().invoke(circle, 12,12);
        assertFalse(result2);
    }
}
